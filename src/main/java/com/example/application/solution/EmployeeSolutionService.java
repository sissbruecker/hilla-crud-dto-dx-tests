package com.example.application.solution;

import com.example.application.Address;
import com.example.application.AddressRepository;
import com.example.application.Department;
import com.example.application.DepartmentRepository;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import dev.hilla.BrowserCallable;
import dev.hilla.Nullable;
import dev.hilla.crud.CrudService;
import dev.hilla.crud.JpaFilterConverter;
import dev.hilla.crud.filter.AndFilter;
import dev.hilla.crud.filter.Filter;
import dev.hilla.crud.filter.PropertyStringFilter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.stream.Collectors;

@BrowserCallable
@AnonymousAllowed
public class EmployeeSolutionService implements CrudService<EmployeeSolutionDTO, Long> {
    private final EmployeeSolutionRepository employeeRepository;
    private final AddressRepository addressRepository;
    private final DepartmentRepository departmentRepository;
    private final JpaFilterConverter jpaFilterConverter;

    public EmployeeSolutionService(EmployeeSolutionRepository employeeRepository, AddressRepository addressRepository, DepartmentRepository departmentRepository, JpaFilterConverter jpaFilterConverter) {
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
        this.departmentRepository = departmentRepository;
        this.jpaFilterConverter = jpaFilterConverter;
    }

    @Override
    public @Nullable EmployeeSolutionDTO save(EmployeeSolutionDTO value) {
        EmployeeSolution employee;
        if (value.id() != null && value.id() > 0) {
            employee = employeeRepository.getReferenceById(value.id());
        } else {
            employee = new EmployeeSolution();
        }
        employee.setName(value.name());
        employee.setEmail(value.email());

        if (employee.getAddress() == null) {
            employee.setAddress(new Address());
        }
        employee.getAddress().setStreet(value.address().street());
        employee.getAddress().setCity(value.address().city());
        addressRepository.save(employee.getAddress());

        Department department = departmentRepository.getReferenceById(value.departmentId());
        employee.setDepartment(department);

        return EmployeeSolutionDTO.fromEntity(employeeRepository.save(employee));
    }

    @Override
    public void delete(Long aLong) {
        employeeRepository.deleteById(aLong);
    }

    @Override
    public List<EmployeeSolutionDTO> list(Pageable pageable, @Nullable Filter filter) {
        // Map sort
        List<Sort.Order> orders = pageable.getSort().stream().map(order -> {
            if (order.getProperty().equals("departmentName")) {
                return new Sort.Order(order.getDirection(), "department.name");
            } else {
                return order;
            }
        }).collect(Collectors.toList());
        Sort mappedSort = Sort.by(orders);
        Pageable mappedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), mappedSort);

        // Map filter
        if (filter instanceof AndFilter andFilter) {
            andFilter.getChildren().forEach(child -> {
                if (child instanceof PropertyStringFilter propertyFilter) {
                    if (propertyFilter.getPropertyId().equals("departmentName")) {
                        propertyFilter.setPropertyId("department.name");
                    }
                }
            });
        }

        Specification<EmployeeSolution> spec = jpaFilterConverter.toSpec(filter, EmployeeSolution.class);
        return employeeRepository.findAll(spec, mappedPageable).map(EmployeeSolutionDTO::fromEntity).toList();
    }

    public List<Department> listDepartments() {
        return departmentRepository.findAll();
    }
}

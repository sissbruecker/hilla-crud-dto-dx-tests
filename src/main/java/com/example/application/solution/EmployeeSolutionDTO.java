package com.example.application.solution;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmployeeSolutionDTO(Long id,
                                  @NotNull @NotBlank String name,
                                  String email,
                                  AddressSolutionDTO address,
                                  String addressInfo,
                                  Long departmentId,
                                  String departmentName) {
    public static EmployeeSolutionDTO fromEntity(EmployeeSolution employee) {
        AddressSolutionDTO address = employee.getAddress() != null ? AddressSolutionDTO.fromEntity(employee.getAddress()) : null;
        String addressInfo = employee.getAddress() != null ? String.format("%s, %s", employee.getAddress().getStreet(), employee.getAddress().getCity()) : "";
        Long departmentId = employee.getDepartment() != null ? employee.getDepartment().getId() : null;
        String departmentName = employee.getDepartment() != null ? employee.getDepartment().getName() : "";

        return new EmployeeSolutionDTO(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                address,
                addressInfo,
                departmentId,
                departmentName
        );
    }
}

package com.example.application;

public record EmployeeDTO(Long id, String name, String email, AddressDTO address) {
    public static EmployeeDTO fromEntity(Employee employee) {
        AddressDTO address = employee.getAddress() != null ? AddressDTO.fromEntity(employee.getAddress()) : null;
        return new EmployeeDTO(employee.getId(), employee.getName(), employee.getEmail(), address);
    }
}

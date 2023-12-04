package com.example.application;

public record EmployeeDTO(Long id, String name, String email) {
    public static EmployeeDTO fromEntity(Employee employee) {
        return new EmployeeDTO(employee.getId(), employee.getName(), employee.getEmail());
    }
}

package com.example.application.solution;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmployeeSolutionDTO(Long id, @NotNull @NotBlank String name, String email, String street, String city, String country, String addressInfo) {
    public static EmployeeSolutionDTO fromEntity(EmployeeSolution employee) {
        String street = employee.getAddress() != null ? employee.getAddress().getStreet() : null;
        String city = employee.getAddress() != null ? employee.getAddress().getCity() : null;
        String country = employee.getAddress() != null ? employee.getAddress().getCountry() : null;
        String addressInfo = employee.getAddress() != null ? String.format("%s, %s, %s", street, city, country) : "";

        return new EmployeeSolutionDTO(employee.getId(), employee.getName(), employee.getEmail(), street, city, country, addressInfo);
    }
}

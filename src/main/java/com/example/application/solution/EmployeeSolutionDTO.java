package com.example.application.solution;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmployeeSolutionDTO(Long id,
                                  @NotNull @NotBlank String name,
                                  String email,
                                  AddressSolutionDTO address,
                                  String addressInfo) {
    public static EmployeeSolutionDTO fromEntity(EmployeeSolution employee) {
        AddressSolutionDTO address = employee.getAddress() != null ? AddressSolutionDTO.fromEntity(employee.getAddress()) : null;
        String addressInfo = employee.getAddress() != null ? String.format("%s, %s", employee.getAddress().getStreet(), employee.getAddress().getCity()) : "";

        return new EmployeeSolutionDTO(employee.getId(), employee.getName(), employee.getEmail(), address, addressInfo);
    }
}

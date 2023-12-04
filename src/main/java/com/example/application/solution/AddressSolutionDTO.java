package com.example.application.solution;

import com.example.application.Address;

public record AddressSolutionDTO(Long id, String street, String city) {
    public static AddressSolutionDTO fromEntity(Address address) {
        return new AddressSolutionDTO(address.getId(), address.getStreet(), address.getCity());
    }
}

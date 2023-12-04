package com.example.application;

public record AddressDTO(Long id, String street, String city) {
    public static AddressDTO fromEntity(Address address) {
        return new AddressDTO(address.getId(), address.getStreet(), address.getCity());
    }
}

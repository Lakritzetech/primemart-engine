package com.system.market.entities;

public record AddressResponseDTO(Long addressId, String road, Long number, String neighborhood, String city, String state, Long cep) {
    public AddressResponseDTO(Address address) {
        this(address.getAddressId(), address.getRoad(), address.getNeighborhood(), address.getNumber(), address.getCity(), address.getState(), address.getCep());
    }
}
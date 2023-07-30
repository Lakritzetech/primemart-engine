package com.system.market.entities.addreess;

import com.system.market.model.Address;

public record AddressResponseDTO(Long id, String road, Long number, String neighborhood, String city, String state, Long cep) {
    public AddressResponseDTO(Address address) {
        this(address.getId(), address.getRoad(), address.getNumber(), address.getNeighborhood(),  address.getCity(), address.getState(), address.getCep());
    }
}
package com.system.market.entities;

public record AddressRequestDTO(Long addressId, String road, Long number, String neighborhood, String city, String state, Long cep) {


}

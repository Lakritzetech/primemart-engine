package com.system.market.entities;

import java.util.Set;

public record AddressRequestDTO(Long addressId, String road, String charge, Long number, String neighborhood, String city, String state, Long cep, Set<Long> addressIds) {


}

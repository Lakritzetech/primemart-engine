package com.system.market.entities.addreess;

import java.util.Set;

public record AddressRequestDTO(Long id, String road, String charge, Long number, String neighborhood, String city, String state, Long cep, Set<Long> addressIds) {


}

package com.system.market.entities;

public record EmployeeRequestDTO(String name, String email, Long cpf, String shift, Long phone) {

    public Long getCpf() {
        return cpf;
    }
}

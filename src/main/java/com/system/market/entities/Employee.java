package com.system.market.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private Long phone;

    @NotBlank
    private String email;

    @NotBlank
    private String shift;

    @NotBlank
    private  String charge;

    @NotNull
    private Long cpf;

    @NotBlank
    private String permission;

    @NotNull
    private Date hiring;

    private  Date lastUpdate;

    private  Date shutdown;


    @ManyToOne
    @JoinColumn(name = "address_id")
    private  Address address;

    public Employee(EmployeeRequestDTO data) {
        this.name = data.name();
        this.email = data.email();
        this.cpf = data.cpf();
        this.shift = data.shift();
        this.phone = data.phone();
    }

}

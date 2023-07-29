package com.system.market.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "address")
public class Address {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank
        private String road;

        @NotNull
        private Long number;

        @NotBlank
        private String neighborhood;

        @NotBlank
        private String city;

        @NotBlank
        private String state;

        @NotNull
        private Long cep;

        @ManyToOne
        @JoinColumn(name = "employees_id")
        private  Employee employees;
        public Address(AddressResponseDTO data) {
                this.road = data.road();
                this.number = data.number();
                this.neighborhood = data.neighborhood();
                this.city = data.city();
                this.state = data.state();
                this.cep = data.cep();
        }
}

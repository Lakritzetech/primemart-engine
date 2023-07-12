package com.system.market.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "addressId")
@Table(name = "address")
public class Address {
        @Id

        @GeneratedValue(strategy =  GenerationType.IDENTITY)
        private Long addressId;
        @NotBlank
        private String road;
        @NotBlank
        private  Long number;
        @NotBlank
        private  String neighborhood;
        @NotBlank
        private  String city;
        @NotBlank
        private  String state;
        @NotNull
        private  Long cep;


        public Address(AddressResponseDTO data) {
                this.road = data.road();
                this.number = data.number();
                this.neighborhood = data.neighborhood();
                this.city = data.city();
                this.state = data.state();
                this.cep = data.cep();

        }


}

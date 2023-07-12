package com.system.market.controller;

import com.system.market.entities.*;
import com.system.market.repository.AddressRepository;
import com.system.market.repository.ProducRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("address")
public class AddressController {

    @Autowired
    AddressRepository addressRepository;
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<AddressResponseDTO> getAll() {
        List<AddressResponseDTO> addressList = addressRepository.findAll().stream().map(AddressResponseDTO::new).toList();
        return addressList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/id/{id}")
    public Optional<Address> findById(@PathVariable Long id ) {
        Optional<Address> getId = addressRepository.findById(id);
        return getId;
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/id/{id}")
    public  ResponseEntity<Address>  deleteID(@PathVariable Long id ) {
        var address = addressRepository.findById(id);
        addressRepository.delete(address.get());
        return ResponseEntity.ok().body(address.get());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<AddressResponseDTO> save(@RequestBody AddressResponseDTO data) {
        Address addressData = new Address(data);
        addressRepository.save(addressData);
        return ResponseEntity.ok().body(data);
         
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PatchMapping("/id/{id}")
    public ResponseEntity<Address> updateEmployee(@PathVariable Long id, @RequestBody AddressRequestDTO data) {
        Optional<Address> optionalAddress = addressRepository.findById(id);

        if (optionalAddress.isPresent()) {
            Address address = optionalAddress.get();

            if (data.road() != null) {
                address.setRoad(data.road());
            }
            if (data.number()!= null) {
                address.setNumber(data.number());
            }
            if (data.neighborhood()!= null) {
                address.setNeighborhood(data.neighborhood());
            }
            if (data.city()!= null) {
                address.setCity(data.city());
            }
            if (data.city()!= null) {
                address.setCity(data.city());
            }
            if (data.city()!= null) {
                address.setCity(data.city());
            }
            if (data.cep()!= null) {
                address.setCep(data.cep());
            }

            addressRepository.save(address);

            return ResponseEntity.ok().body(address);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
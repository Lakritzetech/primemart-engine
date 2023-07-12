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
@RequestMapping("product")
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
    public Optional<Address> findById(@PathVariable Long addresId ) {
        Optional<Address> getId = addressRepository.findById(addresId);
        return getId;
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/id/{id}")
    public  ResponseEntity<Address>  deleteID(@PathVariable Long acdressId ) {
        var address = addressRepository.findById(acdressId);
        addressRepository.delete(address.get());
        return ResponseEntity.ok().body(address.get());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void save(@RequestBody Address data) {
        Address addressData = new Address(data);
        addressRepository.save(addressData);
         
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PatchMapping("/edit/{id}")
    public ResponseEntity<Product> updateEmployee(@PathVariable Long id, @RequestBody ProductRequestDTO data) {
        Optional<Address> optionalAddress = addressRepository.findById(id);

        if (optionalAddress.isPresent()) {
            Address address = optionalAddress.get();

            if (data.name() != null) {
                address.setName(data.name());
            }
            if (data.preco()!= null) {
                address.setPreco(data.preco());
            }
            if (data.validade()!= null) {
                address.setValidade(data.validade());
            }
            if (data.quantidade()!= null) {
                address.setQuantidade(data.quantidade());
            }

            addressRepository.save(address);

            return ResponseEntity.ok().body(address);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
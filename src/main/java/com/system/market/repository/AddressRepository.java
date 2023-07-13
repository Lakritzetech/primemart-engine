package com.system.market.repository;

import com.system.market.entities.Address;
import com.system.market.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository <Address,Long>{


}

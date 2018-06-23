package com.java.emt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.java.emt.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}

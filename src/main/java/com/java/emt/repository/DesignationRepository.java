package com.java.emt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.emt.model.Designation;


@Repository
public interface DesignationRepository extends JpaRepository<Designation, Long>{

}

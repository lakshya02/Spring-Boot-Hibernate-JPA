package com.java.emt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.java.emt.model.ExAssociate;

@Repository
public interface ExAssociateRepository extends JpaRepository<ExAssociate, Long>{

}
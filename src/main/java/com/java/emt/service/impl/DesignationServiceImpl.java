package com.java.emt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.java.emt.exception.ResourceNotFoundException;
import com.java.emt.model.Designation;
import com.java.emt.repository.DesignationRepository;
import com.java.emt.service.DesignationService;

@Service
public class DesignationServiceImpl implements DesignationService{
	
	@Autowired
	DesignationRepository designationRepository;

	@Override
	public List<Designation> getAllDesignations() {
		return designationRepository.findAll();
	}

	@Override
	public Designation addDesignation(Designation Designation) {
		return designationRepository.save(Designation);
	}

	@Override
	public Designation getDesignationById(Long desId) {
		return designationRepository.findById(desId)
	            .orElseThrow(() -> new ResourceNotFoundException("Designation", "id",desId));
	}

	@Override
	public Designation updateDesignation(Long desId, Designation designationDetails) {
		Designation designation = designationRepository.findById(desId)
	            .orElseThrow(() -> new ResourceNotFoundException("Designation", "designationId", desId));

	    designation.setDesCode(designationDetails.getDesCode());
	    designation.setDesName(designationDetails.getDesName());
	    Designation updatedDesignation = designationRepository.save(designation);
	    return updatedDesignation;
	}

	@Override
	public ResponseEntity<?> deleteDesignation(Long desId) {
		 Designation designation = designationRepository.findById(desId)
		            .orElseThrow(() -> new ResourceNotFoundException("Designation", "id", desId));
		    designationRepository.delete(designation);
		    return ResponseEntity.ok().build();
	}

}

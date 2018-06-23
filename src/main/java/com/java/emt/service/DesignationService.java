package com.java.emt.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.java.emt.model.Designation;

public interface DesignationService {
	public List<Designation> getAllDesignations();
	public Designation addDesignation( Designation Designation);
	public Designation getDesignationById(Long desId);
	public Designation updateDesignation(Long desId, Designation designationDetails);
	public ResponseEntity<?> deleteDesignation(Long designationId);

}

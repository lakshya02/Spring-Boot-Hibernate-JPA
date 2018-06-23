package com.java.emt.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.emt.model.Designation;
import com.java.emt.service.DesignationService;

@RestController
public class DesignationController {
	
	@Autowired 
	DesignationService designationService;

	
	@GetMapping("/designation")
	public List<Designation> getAllDesignations() {
	    return designationService.getAllDesignations();
	}

	
	@PostMapping("/designation")
	public Designation addDesignation(@RequestBody Designation designation) {
		    return designationService.addDesignation(designation);
	}
	
	
	@GetMapping("/designation/{desId}")
	public Designation getDesignationById(@PathVariable(value = "desId") Long desId) {
	    return designationService.getDesignationById(desId);
	}
	
	
	@PutMapping("/designation/{desId}")
	public Designation updateDesignation(@PathVariable(value = "desId") Long desId,
	                                         @RequestBody Designation designationDetails) {

		return designationService.updateDesignation(desId, designationDetails);
	}
	
	
	@DeleteMapping("/deleteDes/{desId}")
	public ResponseEntity<?> deleteDesignation(@PathVariable(value = "desId") Long designationId) {
	    return designationService.deleteDesignation(designationId);
	}
}

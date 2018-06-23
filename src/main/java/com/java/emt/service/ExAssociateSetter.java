package com.java.emt.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.emt.model.Address;
import com.java.emt.model.Employee;
import com.java.emt.model.ExAssociate;
import com.java.emt.model.ExAssociateAddress;


public class ExAssociateSetter {
	@Autowired
	ExAssociate exAssociate;
	
	@Autowired
	ExAssociateAddress exAssociateAddress;
	
	public ExAssociate setExAssociate(Employee employee){
		ExAssociate exAssociate = new ExAssociate();
		exAssociate.setAge(employee.getAge());
		exAssociate.setContactNo(employee.getContactNo());
		exAssociate.setDateOfBirth(employee.getDateOfBirth());
		exAssociate.setDesignation(employee.getDesignation());
		exAssociate.setEmpId(employee.getEmpId());
		exAssociate.setFirstName(employee.getFirstName());
		exAssociate.setLastName(employee.getLastName());
		exAssociate.setGender(employee.getGender());
		exAssociate.setExAssociateAddress(setExAssoAddress(employee.getAddress()));
		return exAssociate;		
	}
	private ExAssociateAddress setExAssoAddress(Address address) {
		ExAssociateAddress exAssociateAddress = new ExAssociateAddress();
		exAssociateAddress.setCity(address.getCity());
		exAssociateAddress.setState(address.getState());
		exAssociateAddress.setStreet(address.getStreet());
		exAssociateAddress.setCity(address.getCity());
		exAssociateAddress.setZipcode(address.getZipcode());
		return exAssociateAddress;
	}
}

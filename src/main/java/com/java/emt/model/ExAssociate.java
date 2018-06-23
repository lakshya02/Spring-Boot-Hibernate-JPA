package com.java.emt.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ex_associate")
public class ExAssociate {
	@Id
 	@Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column
	private Long empId;
	
    @Column
    private String firstName;

	@Column
    private String lastName;
    
    @Column
    private String gender;
    
    @Column
    private String contactNo;
    
    @Column
    private int age;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "dob")
    private Date dateOfBirth;
    
    @OneToOne(cascade = CascadeType.ALL)
    private ExAssociateAddress exAssociateAddress;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    private Designation designation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public ExAssociateAddress getExAssociateAddress() {
		return exAssociateAddress;
	}

	public void setExAssociateAddress(ExAssociateAddress exAssociateAddress) {
		this.exAssociateAddress = exAssociateAddress;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}


}

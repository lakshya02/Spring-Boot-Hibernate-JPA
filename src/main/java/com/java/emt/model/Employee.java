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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "employee")
public class Employee {
	 	@Id
	 	@Column(name="emp_id")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
	    private Address address;
	    
	    @ManyToOne(cascade = CascadeType.MERGE)
	    private Designation designation;

		public Employee() {

		}
		@JsonCreator
		public Employee(@JsonProperty("empId") Long empId,@JsonProperty("firstName") String firstName,@JsonProperty("lastName") String lastName,@JsonProperty("gender") String gender, @JsonProperty("dob") Date dateOfBirth,@JsonProperty("age") int age, @JsonProperty("contactNo") String contactNo,@JsonProperty("address") Address address, @JsonProperty("designation") Designation designation) {
			super();
			this.empId = empId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.dateOfBirth = dateOfBirth;
			this.contactNo = contactNo;
			this.address = address;
			this.gender = gender;
			this.age=age;
			this.designation = designation;
		}
		
	    public Designation getDesignation() {
			return designation;
		}
		public void setDesignation(Designation designation) {
			this.designation = designation;
		}
		
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
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
		public Date getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		
		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public Long getEmpId() {
			return empId;
		}

		public void setEmpId(Long empId) {
			this.empId = empId;
		}

		public String getContactNo() {
			return contactNo;
		}

		public void setContactNo(String contactNo) {
			this.contactNo = contactNo;
		}
}

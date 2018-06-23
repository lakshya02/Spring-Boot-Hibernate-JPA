package com.java.emt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "ex_asso_add")
public class ExAssociateAddress {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id", unique = true, nullable = false)
	private long addressId;
	
	@Column(name = "address_street", nullable = false, length=250)
	private String street;
	
	@Column(name = "address_city", nullable = false, length=50)	
	private String city;
	
	@Column(name = "address_state", nullable = false, length=50)
	private String state;
	
	@Column(name = "address_zipcode", nullable = false, length=10)
	private String zipcode;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	@JsonIgnore
	private ExAssociate exAssociate;
	
	
	
	public ExAssociateAddress() {
		super();
	}

	@JsonCreator
	public ExAssociateAddress(@JsonProperty("address_street") String street,@JsonProperty("address_city") String city,@JsonProperty("address_state") String state,@JsonProperty("address_zipcode") String zipcode,@JsonProperty("id") ExAssociate exAssociate) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.exAssociate= exAssociate;
	}

	public ExAssociate getExAssociate() {
		return exAssociate;
	}

	public void setExAssociate(ExAssociate exAssociate) {
		this.exAssociate = exAssociate;
	}

	public long getAddressId() {
		return this.addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
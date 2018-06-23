package com.java.emt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "designation")
public class Designation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long desId;
	
    @Column
    private String desCode;

    @Column
    private String desName;
    
    public Designation() {
		
	}
    @JsonCreator
	public Designation(@JsonProperty("des_id") Long desId,@JsonProperty("des_code") String desCode,@JsonProperty("des_name") String desName) {
		super();
		this.desId = desId;
		this.desCode = desCode;
		this.desName = desName;
	}

	public Long getDesId() {
		return desId;
	}

	public void setDesId(Long desId) {
		this.desId = desId;
	}

	public String getDesCode() {
		return desCode;
	}

	public void setDesCode(String desCode) {
		this.desCode = desCode;
	}

	public String getDesName() {
		return desName;
	}

	public void setDesName(String desName) {
		this.desName = desName;
	}

}

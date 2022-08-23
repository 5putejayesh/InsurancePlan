package com.jayesh.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="PLAN_CATEGORY")
public class PlanCategory {
	
	@Id
	@GeneratedValue
	@Column(name="CATEGORY_ID")
	private Integer planCatId;
	
	@Column(name="CATEGORY_NAME")
	private String planCatName;
	
	@Column(name="ACTIVE_SW")
	private String active_sw;
	
	@Column(name="CREATE_DATE")
	private LocalDate createdDate;
	
	@Column(name="UPDATE_DATE")
	private LocalDate updatedDate;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	
	
}

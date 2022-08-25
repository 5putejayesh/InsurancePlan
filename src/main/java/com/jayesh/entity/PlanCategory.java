package com.jayesh.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
	
	@Column(name="ACTIVE_SW",length = 1)
	private String active_sw;
	
	@Column(name="CREATE_DATE")
	@CreationTimestamp
	private LocalDate createdDate;
	
	@Column(name="UPDATE_DATE")
	@UpdateTimestamp
	private LocalDate updatedDate;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	
	
}

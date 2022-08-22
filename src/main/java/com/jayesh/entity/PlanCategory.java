package com.jayesh.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	
	public Integer getPlanCatId() {
		return planCatId;
	}
	public void setPlanCatId(Integer planCatId) {
		this.planCatId = planCatId;
	}
	public String getPlanCatName() {
		return planCatName;
	}
	public void setPlanCatName(String planCatName) {
		this.planCatName = planCatName;
	}
	public String getActive_sw() {
		return active_sw;
	}
	public void setActive_sw(String active_sw) {
		this.active_sw = active_sw;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDate getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	

}

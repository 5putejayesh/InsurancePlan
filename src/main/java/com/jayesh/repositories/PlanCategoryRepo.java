package com.jayesh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayesh.entity.PlanCategory;

public interface PlanCategoryRepo extends JpaRepository<PlanCategory, Integer>{

}

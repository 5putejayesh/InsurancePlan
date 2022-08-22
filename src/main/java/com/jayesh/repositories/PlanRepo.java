package com.jayesh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayesh.entity.Plan;

public interface PlanRepo extends JpaRepository<Plan, Integer> {

}

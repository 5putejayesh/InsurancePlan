package com.jayesh.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayesh.entity.Plan;
import com.jayesh.entity.PlanCategory;
import com.jayesh.repositories.PlanCategoryRepo;
import com.jayesh.repositories.PlanRepo;
import com.jayesh.service.PlanService;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	PlanCategoryRepo categoryRepo;

	@Autowired
	PlanRepo planRepo;

	@Override
	public Map<Integer, String> getPlanCategories() {
		List<PlanCategory> categories = categoryRepo.findAll();
		return categories.stream().collect(Collectors.toMap(PlanCategory::getPlanCatId, PlanCategory::getPlanCatName));
	}

	@Override
	public boolean savePlan(Plan plan) {
		Plan savedPlan = planRepo.save(plan);
		return savedPlan.getPlanId()!=null;
	}

	@Override
	public List<Plan> getAllPlans() {
		return planRepo.findAll();
	}

	@Override
	public Plan getPlanById(Integer planId) {
		Optional<Plan> findById = planRepo.findById(planId);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean updatePlan(Plan plan) {

		Plan savedPlan = planRepo.save(plan);
		return savedPlan.getPlanId()!=null;
	}

	@Override
	public boolean deletePlanById(Integer planId) {
		boolean status=false;
		try {
			planRepo.deleteById(planId);
			status=true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean planStatusChange(Integer planId, String status) {

		Optional<Plan> findById = planRepo.findById(planId);
		if(findById.isPresent()) {
			Plan plan = findById.get();
			plan.setActive_sw(status);
			planRepo.save(plan);
			return true;
		}
		
		return false;
	}

}

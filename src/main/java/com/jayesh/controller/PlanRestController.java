package com.jayesh.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jayesh.constants.AppConstants;
import com.jayesh.entity.Plan;
import com.jayesh.props.AppProperties;
import com.jayesh.service.PlanService;


@RestController
public class PlanRestController {

	
	private PlanService planService;
	
	private Map<String,String> messages;
	
	public PlanRestController(PlanService planService, AppProperties appProperties) {
		this.planService=planService;
		messages=appProperties.getMessages();
	}
	
	@GetMapping("/categories")
	public ResponseEntity<Map<Integer,String>> planCategories(){
		return new  ResponseEntity<>(planService.getPlanCategories(),HttpStatus.OK);
	}
	
	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> plans(){
		return new ResponseEntity<>(planService.getAllPlans(),HttpStatus.OK);
	}
	
	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planId){
		return new ResponseEntity<>(planService.getPlanById(planId),HttpStatus.OK);
	}
	
	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody Plan  plan){
		String responseMsg=AppConstants.EMPTY_STR;
		boolean isSaved = planService.savePlan(plan);
		if(isSaved) {
			responseMsg=messages.get(AppConstants.PLAN_SAVED);
		}
		else {
			responseMsg=messages.get(AppConstants.PLAN_NOT_SAVED);
		}
		
		return new ResponseEntity<>(responseMsg,HttpStatus.CREATED);
	}
	
		
	@PutMapping("/plan")
	public ResponseEntity<String> updatePlan(@RequestBody Plan  plan){
		String responseMsg=AppConstants.EMPTY_STR;
		boolean isSaved = planService.updatePlan(plan);
		if(isSaved) {
			responseMsg=messages.get(AppConstants.PLAN_UPDATED);
		}
		else {
			responseMsg=messages.get(AppConstants.PLAN_NOT_UPDATED);
		}
		
		return new ResponseEntity<>(responseMsg,HttpStatus.OK);
	}
	
	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId){
		boolean isDeleted = planService.deletePlanById(planId);
		String msg=AppConstants.EMPTY_STR;
		
		if(isDeleted) {
			msg=messages.get(AppConstants.PLAN_DELETED);
		}
		else {
			msg=messages.get(AppConstants.PLAN_NOT_DELETED);
		}
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> statusChange(@PathVariable Integer planId, @PathVariable String status){
		String msg=AppConstants.EMPTY_STR;
		boolean planStatusChange = planService.planStatusChange(planId, status);
		
		if(planStatusChange) {
			msg=messages.get(AppConstants.PLAN_STATUS_CHNAGED);
		}
		else {
			msg=messages.get(AppConstants.PLAN_STATUS_NOT_CHNAGED);
		}
		
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
}

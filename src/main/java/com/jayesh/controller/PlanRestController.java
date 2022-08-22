package com.jayesh.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jayesh.entity.Plan;
import com.jayesh.service.PlanService;

@RestController
public class PlanRestController {

	@Autowired
	PlanService planService;
	
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
		String responseMsg="";
		boolean isSaved = planService.savePlan(plan);
		if(isSaved) {
			responseMsg="Plan Saved";
		}
		else {
			responseMsg="Plan Not Saved";
		}
		
		return new ResponseEntity<>(responseMsg,HttpStatus.CREATED);
	}
	
		
	@PutMapping("/plan")
	public ResponseEntity<String> updatePlan(@RequestBody Plan  plan){
		String responseMsg="";
		boolean isSaved = planService.updatePlan(plan);
		if(isSaved) {
			responseMsg="Plan Updated";
		}
		else {
			responseMsg="Plan Not Updated";
		}
		
		return new ResponseEntity<>(responseMsg,HttpStatus.OK);
	}
	
	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId){
		boolean isDeleted = planService.deletePlanById(planId);
		String msg="";
		
		if(isDeleted) {
			msg="Plan Deleted";
		}
		else {
			msg="Plan Not Deleted";
		}
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> statusChange(@PathVariable Integer planId, @PathVariable String status){
		String msg="";
		boolean planStatusChange = planService.planStatusChange(planId, status);
		
		if(planStatusChange) {
			msg="status changed";
		}
		else {
			msg="status not changed";
		}
		
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
}

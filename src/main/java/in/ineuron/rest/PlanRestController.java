package in.ineuron.rest;

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

import in.ineuron.entity.Plan;
import in.ineuron.service.PlanService;

@RestController
public class PlanRestController {
	
	@Autowired
	public PlanService planService;
	private Integer planId;
	
	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> planCategories(){
		Map<Integer,String> planCategories = planService.getPlanCategories();
		return new ResponseEntity<>(planCategories, HttpStatus.OK);
	}
	
	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan){
		String responseMsg="";
		boolean savePlan = planService.savePlan(plan);
		
		if (savePlan) {
			responseMsg="Plan saved";
		}else {
			responseMsg="Plan not saved";
		}
		return new ResponseEntity<>(responseMsg, HttpStatus.CREATED);
		
	}
	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> plans(){
		List<Plan> allPlans = planService.getAllPlans();
		return new ResponseEntity<>(allPlans, HttpStatus.OK);
	}
	
	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Plan plan){
		Plan planById = planService.getPlanById(planId);
		return new ResponseEntity<>(planById, HttpStatus.OK);
				
	}
	
	@PutMapping("/plan")
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan){
		String msg="";
		boolean b = planService.updatePlan(plan);
		
		if (b) {
			msg="Plan updated";
		}else {
			msg="Plan not updated";
		}
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@RequestBody Plan plan){
		String msg="";
		boolean deletePlan = planService.deletePlanById(planId);
		
		if (deletePlan) {
			msg="Plan deleted";
		}else {
			msg="Plan not deleted";
		}
		return new ResponseEntity<>(msg, HttpStatus.OK);
		
	}
	@PutMapping("/status/{planId}/{status}")
	public ResponseEntity<String> statusChange(@PathVariable Integer planId, @PathVariable String status){
		String msg="";
		boolean statusChange = planService.planStatusChange(planId, status);
		if (statusChange) {
			msg="Status is changed";
		}else {
			msg="Status not changed";
		}
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
}
	

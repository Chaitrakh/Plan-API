package in.ineuron.service;

import java.util.List;
import java.util.Map;

import in.ineuron.entity.Plan;

public interface PlanService {
	
	public Map<Integer, String> getPlanCategories();
	
	public boolean savePlan(Plan plan);
	
	public List<Plan> getAllPlans();
	
	public Plan getPlanById(Integer PlanId);
	
	public boolean updatePlan(Plan plan);
	
	public boolean deletePlanById(Integer PlanId);
	
	public boolean planStatusChange(Integer planId, String status);
		
	}


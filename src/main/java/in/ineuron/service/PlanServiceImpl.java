package in.ineuron.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.entity.Plan;
import in.ineuron.entity.PlanCategory;
import in.ineuron.repository.PlanCategoryRepo;
import in.ineuron.repository.PlanRepo;

@Service
public class PlanServiceImpl implements PlanService {
	@Autowired
	private PlanRepo planRepo;

	@Autowired
	private PlanCategoryRepo planCategoryRepo;

	@Override
	public Map<Integer, String> getPlanCategories() {

		List<PlanCategory> list = planCategoryRepo.findAll();

		Map<Integer, String> hashMap = new HashMap<>();
		list.forEach(category -> {
			hashMap.put(category.getCategoryId(), category.getCategoryName());
		});
		return hashMap;
	}

	@Override
	public boolean savePlan(Plan plan) {

		Plan saved = planRepo.save(plan);
		return saved.getPlanEndDate() != null ? true : false;
	}

	@Override
	public List<Plan> getAllPlans() {
		return planRepo.findAll();
	}

	@Override
	public Plan getPlanById(Integer PlanId) {
		Optional<Plan> byId = planRepo.findById(PlanId);
		if(byId.isPresent()) {
			return byId.get();
		}
		return null;
	}
	@Override
	public boolean updatePlan(Plan plan) {
		Plan save = planRepo.save(plan);
		return plan.getPlanEndDate() != null;
	}

	@Override
	public boolean deletePlanById(Integer PlanId) {
		boolean status=false;
		try {
			planRepo.deleteById(PlanId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean planStatusChange(Integer planId, String status) {
		Optional<Plan> byId = planRepo.findById(planId);
		if (byId.isPresent()) {
			Plan plan = byId.get();	
			plan.setActivesw(status);
			planRepo.save(plan);
			return true;
			}
		return false;
	}

}

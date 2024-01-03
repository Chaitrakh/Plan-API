package in.ineuron.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.entity.Plan;

public interface PlanRepo extends JpaRepository<Plan, Integer>{

}

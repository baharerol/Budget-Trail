package com.budgettrail.repository;

import com.budgettrail.model.TravelPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TravelPlanRepository extends JpaRepository<TravelPlan, Long> {
    List<TravelPlan> findByUserId(Long userId);
} 
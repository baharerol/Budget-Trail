package com.budgettrail.service;

import com.budgettrail.model.TravelPlan;
import com.budgettrail.model.PlanDetail;
import com.budgettrail.repository.TravelPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TravelPlanService {
    @Autowired
    private TravelPlanRepository travelPlanRepository;

    public TravelPlan createTravelPlan(TravelPlan travelPlan) {
        travelPlan.setCreationDate(LocalDateTime.now());
        return travelPlanRepository.save(travelPlan);
    }

    public List<TravelPlan> getTravelPlansByUser(Long userId) {
        return travelPlanRepository.findByUserId(userId);
    }

    public TravelPlan getTravelPlanById(Long id) {
        return travelPlanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Travel plan not found"));
    }
} 
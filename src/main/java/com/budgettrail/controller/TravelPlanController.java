package com.budgettrail.controller;

import com.budgettrail.model.TravelPlan;
import com.budgettrail.service.TravelPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/travel-plans")
public class TravelPlanController {
    @Autowired
    private TravelPlanService travelPlanService;

    @PostMapping
    public ResponseEntity<TravelPlan> createTravelPlan(@RequestBody TravelPlan travelPlan) {
        return ResponseEntity.ok(travelPlanService.createTravelPlan(travelPlan));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TravelPlan>> getTravelPlansByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(travelPlanService.getTravelPlansByUser(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TravelPlan> getTravelPlanById(@PathVariable Long id) {
        return ResponseEntity.ok(travelPlanService.getTravelPlanById(id));
    }
} 
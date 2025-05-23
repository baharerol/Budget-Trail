package com.budgettrail.controller;

import com.budgettrail.model.Activity;
import com.budgettrail.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @GetMapping("/city/{cityId}")
    public ResponseEntity<List<Activity>> getActivitiesByCity(@PathVariable Long cityId) {
        return ResponseEntity.ok(activityService.getActivitiesByCity(cityId));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Activity>> getActivitiesByType(@PathVariable String type) {
        return ResponseEntity.ok(activityService.getActivitiesByType(type));
    }

    @GetMapping("/price/{price}")
    public ResponseEntity<List<Activity>> getActivitiesByPrice(@PathVariable Double price) {
        return ResponseEntity.ok(activityService.getActivitiesByPrice(price));
    }

    @PostMapping
    public ResponseEntity<Activity> createActivity(@RequestBody Activity activity) {
        return ResponseEntity.ok(activityService.saveActivity(activity));
    }
} 
package com.budgettrail.service;

import com.budgettrail.model.Activity;
import com.budgettrail.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> getActivitiesByCity(Long cityId) {
        return activityRepository.findByCityId(cityId);
    }

    public List<Activity> getActivitiesByType(String type) {
        return activityRepository.findByType(type);
    }

    public List<Activity> getActivitiesByPrice(Double price) {
        return activityRepository.findByPriceLessThanEqual(price);
    }

    public Activity saveActivity(Activity activity) {
        return activityRepository.save(activity);
    }
} 
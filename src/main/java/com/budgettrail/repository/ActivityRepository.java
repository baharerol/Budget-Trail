package com.budgettrail.repository;

import com.budgettrail.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findByCityId(Long cityId);
    List<Activity> findByType(String type);
    List<Activity> findByPriceLessThanEqual(Double price);
} 
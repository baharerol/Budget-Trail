package com.budgettrail.repository;

import com.budgettrail.model.TravelPreferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelPreferencesRepository extends JpaRepository<TravelPreferences, Long> {
    List<TravelPreferences> findByUserId(Long userId);
} 
package com.budgettrail.service;

import com.budgettrail.model.TravelPreferences;
import com.budgettrail.repository.TravelPreferencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelPreferencesService {

    @Autowired
    private TravelPreferencesRepository preferencesRepository;

    public List<TravelPreferences> findByUserId(Long userId) {
        return preferencesRepository.findByUserId(userId);
    }
} 
package com.budgettrail.service;

import com.budgettrail.model.City;
import com.budgettrail.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public List<City> getCitiesByCountry(String country) {
        return cityRepository.findByCountry(country);
    }

    public List<City> getCitiesByBudget(Double budget) {
        return cityRepository.findByDailyCostLessThanEqual(budget);
    }

    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    public List<City> getCitiesByRegion(String region) {
        return cityRepository.findByRegion(region);
    }

    public List<City> getSuitableCities(String region, Double budget, Integer days) {
        return cityRepository.findSuitableCities(region, budget, days);
    }

    public List<City> getSuitableCitiesWithActivity(String region, Double budget, Integer days, String activityType) {
        return cityRepository.findSuitableCitiesWithActivity(region, budget, days, activityType);
    }
} 
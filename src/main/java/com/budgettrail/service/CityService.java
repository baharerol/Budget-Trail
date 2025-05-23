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
        return cityRepository.findByAverageBudgetLessThanEqual(budget);
    }

    public City saveCity(City city) {
        return cityRepository.save(city);
    }
} 
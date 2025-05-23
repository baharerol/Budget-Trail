package com.budgettrail.controller;

import com.budgettrail.model.City;
import com.budgettrail.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping
    public ResponseEntity<List<City>> getAllCities() {
        return ResponseEntity.ok(cityService.getAllCities());
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<List<City>> getCitiesByCountry(@PathVariable String country) {
        return ResponseEntity.ok(cityService.getCitiesByCountry(country));
    }

    @GetMapping("/budget/{budget}")
    public ResponseEntity<List<City>> getCitiesByBudget(@PathVariable Double budget) {
        return ResponseEntity.ok(cityService.getCitiesByBudget(budget));
    }

    @PostMapping
    public ResponseEntity<City> createCity(@RequestBody City city) {
        return ResponseEntity.ok(cityService.saveCity(city));
    }
} 
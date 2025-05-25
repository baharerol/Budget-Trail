package com.budgettrail.service;

import com.budgettrail.model.City;
import com.budgettrail.model.TravelPreferences;
import com.budgettrail.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TravelRecommendationService {

    @Autowired
    private CityRepository cityRepository;

    public Map<String, Object> getRecommendations(TravelPreferences preferences) {
        Map<String, Object> recommendation = new HashMap<>();
        
        try {
            // Calculate number of days
            LocalDate startDate = LocalDate.parse(preferences.getStartDate());
            LocalDate endDate = LocalDate.parse(preferences.getEndDate());
            int days = (int) ChronoUnit.DAYS.between(startDate, endDate);

            // Calculate daily budget
            double dailyBudget = preferences.getBudget() / days;

            // Get all cities in the selected region
            List<City> citiesInRegion = cityRepository.findByRegion(preferences.getRegion());

            // Filter cities by travel type and daily budget
            List<City> suitableCities = citiesInRegion.stream()
                .filter(city -> city.getActivities().contains(preferences.getTravelType()))
                .filter(city -> city.getDailyCost() <= dailyBudget)
                .collect(Collectors.toList());

            // If no cities found with the specific travel type, try without travel type filter
            if (suitableCities.isEmpty()) {
                suitableCities = citiesInRegion.stream()
                    .filter(city -> city.getDailyCost() <= dailyBudget)
                    .collect(Collectors.toList());
            }

            // Prepare recommendations
            if (!suitableCities.isEmpty()) {
                List<Map<String, Object>> cityRecommendations = new ArrayList<>();
                
                // Add all suitable cities
                for (City city : suitableCities) {
                    Map<String, Object> cityRecommendation = new HashMap<>();
                    cityRecommendation.put("city", city.getName());
                    cityRecommendation.put("totalCost", preferences.getBudget());
                    cityRecommendation.put("dailyCost", city.getDailyCost());
                    cityRecommendation.put("activities", city.getActivities());
                    cityRecommendation.put("days", days);
                    cityRecommendation.put("description", city.getDescription());
                    cityRecommendation.put("imageUrl", city.getImageUrl());
                    
                    // Add accommodation recommendations based on budget
                    List<String> accommodationOptions = getAccommodationOptions(city.getDailyCost(), dailyBudget);
                    cityRecommendation.put("accommodation", accommodationOptions);
                    
                    // Add transportation recommendations
                    List<String> transportationOptions = getTransportationOptions(city.getRegion());
                    cityRecommendation.put("transportation", transportationOptions);
                    
                    cityRecommendations.add(cityRecommendation);
                }
                
                recommendation.put("recommendations", cityRecommendations);
            } else {
                recommendation.put("error", "Uygun destinasyon bulunamadı");
                recommendation.put("message", String.format(
                    "Kriterlerinize uygun destinasyon bulunamadı. Bölge: %s, Bütçe: %.2f TL/gün, Gün: %d, Tur Tipi: %s",
                    preferences.getRegion(),
                    dailyBudget,
                    days,
                    preferences.getTravelType()
                ));
            }
        } catch (Exception e) {
            recommendation.put("error", "Bir hata oluştu");
            recommendation.put("message", "Hata: " + e.getMessage());
        }

        return recommendation;
    }

    private List<String> getAccommodationOptions(double cityDailyCost, double dailyBudget) {
        List<String> options = new ArrayList<>();
        double remainingBudget = dailyBudget - cityDailyCost;
        
        if (remainingBudget >= 500) {
            options.add("Lüks Otel");
            options.add("Butik Otel");
        }
        if (remainingBudget >= 300) {
            options.add("Standart Otel");
            options.add("Pansiyon");
        }
        if (remainingBudget >= 150) {
            options.add("Hostel");
            options.add("Airbnb");
        }
        if (remainingBudget >= 50) {
            options.add("Ekonomik Hostel");
            options.add("Kamp");
        }
        
        return options;
    }

    private List<String> getTransportationOptions(String region) {
        List<String> options = new ArrayList<>();
        
        switch (region) {
            case "Yurt İçi":
                options.add("İç Hat Uçuşu");
                options.add("Otobüs");
                options.add("Tren");
                break;
            case "Avrupa":
                options.add("Dış Hat Uçuşu");
                options.add("Tren (Eurail)");
                options.add("Otobüs (Eurolines)");
                break;
            case "Asya":
                options.add("Dış Hat Uçuşu");
                options.add("Yerel Trenler");
                options.add("Yerel Otobüsler");
                break;
            default:
                options.add("Uçak");
                options.add("Otobüs");
                options.add("Tren");
        }
        
        return options;
    }
} 
package com.budgettrail.controller;

import com.budgettrail.model.TravelPreferences;
import com.budgettrail.model.User;
import com.budgettrail.service.TravelRecommendationService;
import com.budgettrail.service.TravelPreferencesService;
import com.budgettrail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/travel-plans")
public class TravelPlansController {

    @Autowired
    private TravelPreferencesService preferencesService;

    @Autowired
    private TravelRecommendationService recommendationService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String showTravelPlans(Model model) {
        try {
            // Get current authenticated user
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth == null || !auth.isAuthenticated()) {
                return "redirect:/login";
            }

            String username = auth.getName();
            User user = userService.findByUsername(username);
            if (user == null) {
                return "redirect:/login";
            }

            // Get user's travel preferences
            List<TravelPreferences> preferences = preferencesService.findByUserId(user.getId());
            if (preferences == null || preferences.isEmpty()) {
                model.addAttribute("preferences", List.of());
                return "travel-plans";
            }

            // Get recommendations for each preference
            Map<Long, Map<String, Object>> recommendations = new HashMap<>();
            for (TravelPreferences pref : preferences) {
                Map<String, Object> recommendation = recommendationService.getRecommendations(pref);
                recommendations.put(pref.getId(), recommendation);
            }

            model.addAttribute("preferences", preferences);
            model.addAttribute("recommendations", recommendations);
            return "travel-plans";

        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/login";
        }
    }
} 
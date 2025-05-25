package com.budgettrail.controller;

import com.budgettrail.model.TravelPreferences;
import com.budgettrail.model.User;
import com.budgettrail.repository.TravelPreferencesRepository;
import com.budgettrail.repository.UserRepository;
import com.budgettrail.service.TravelRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Controller
public class TravelPreferencesController {

    @Autowired
    private TravelPreferencesRepository travelPreferencesRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TravelRecommendationService recommendationService;

    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("newPreferences", new TravelPreferences());
        return "index";
    }

    @PostMapping("/travel-preferences/save")
    public String savePreferences(@ModelAttribute TravelPreferences preferences, Model model) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth == null || !auth.isAuthenticated()) {
                return "redirect:/login";
            }

            String username = auth.getName();
            User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

            preferences.setUser(user);
            travelPreferencesRepository.save(preferences);

            Map<String, Object> recommendations = recommendationService.getRecommendations(preferences);
            model.addAttribute("recommendations", recommendations);

            return "redirect:/travel-plans";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "redirect:/";
        }
    }

    @GetMapping("/travel-preferences")
    public String getMyPreferences(Model model) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth == null || !auth.isAuthenticated()) {
                return "redirect:/login";
            }

            String username = auth.getName();
            User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

            List<TravelPreferences> preferences = travelPreferencesRepository.findByUserId(user.getId());
            model.addAttribute("preferences", preferences);

            return "travel-preferences";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "redirect:/";
        }
    }
} 
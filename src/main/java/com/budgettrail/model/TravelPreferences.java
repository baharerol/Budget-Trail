package com.budgettrail.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "travel_preferences")
public class TravelPreferences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double budget;

    @Column(nullable = false)
    private String region; // Avrupa, Asya, Yurt İçi

    @Column(nullable = false)
    private String travelType; // Kültür, Macera, Dinlenme

    @Column(nullable = false)
    private String startDate;

    @Column(nullable = false)
    private String endDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
} 
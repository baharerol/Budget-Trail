package com.budgettrail.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String region; // Avrupa, Asya, Yurt İçi

    @Column(nullable = false)
    private Double dailyCost; // Günlük ortalama maliyet

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "city_activities", joinColumns = @JoinColumn(name = "city_id"))
    @Column(name = "activity", nullable = false)
    private List<String> activities; // Kültür, Macera, Dinlenme

    @Column(length = 1000)
    private String description;

    @Column
    private String imageUrl;
} 
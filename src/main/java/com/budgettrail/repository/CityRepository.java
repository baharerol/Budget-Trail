package com.budgettrail.repository;

import com.budgettrail.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findByRegion(String region);
    
    List<City> findByCountry(String country);
    
    List<City> findByDailyCostLessThanEqual(Double budget);
    
    @Query("SELECT c FROM City c WHERE c.region = :region AND (c.dailyCost * :days) <= :budget")
    List<City> findSuitableCities(@Param("region") String region, 
                                 @Param("budget") Double budget, 
                                 @Param("days") Integer days);
    
    @Query("SELECT c FROM City c WHERE c.region = :region AND (c.dailyCost * :days) <= :budget AND :activityType MEMBER OF c.activities")
    List<City> findSuitableCitiesWithActivity(@Param("region") String region,
                                            @Param("budget") Double budget,
                                            @Param("days") Integer days,
                                            @Param("activityType") String activityType);
} 
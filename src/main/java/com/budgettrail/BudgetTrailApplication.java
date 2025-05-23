package com.budgettrail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EntityScan("com.budgettrail.model")
@EnableJpaRepositories("com.budgettrail.repository")
public class BudgetTrailApplication {

    public static void main(String[] args) {
        SpringApplication.run(BudgetTrailApplication.class, args);
    }
} 
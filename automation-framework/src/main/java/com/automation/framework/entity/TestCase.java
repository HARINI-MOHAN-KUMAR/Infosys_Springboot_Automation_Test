package com.automation.framework.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "test_cases")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String testName;

    @Column(length = 1000)
    private String description;

    // In a real scenario, this could be a JSON or One-to-Many relationship needed for detailed steps.
    // For MVP, we will store steps as a delimited string or simple text.
    @Column(columnDefinition = "TEXT")
    private String testSteps; 

    @Column(nullable = false)
    private String expectedResult;
    
    // chrome, firefox, etc.
    private String browserPreference;

    private boolean active = true;

    private LocalDateTime createdAt = LocalDateTime.now();
}

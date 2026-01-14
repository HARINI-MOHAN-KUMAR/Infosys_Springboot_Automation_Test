package com.automation.framework.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "execution_results")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExecutionResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "test_case_id")
    private TestCase testCase;

    @Column(nullable = false)
    private String status; // PASS, FAIL, SKIPPED

    private LocalDateTime executionTime = LocalDateTime.now();

    private String screenshotPath;

    @Column(columnDefinition = "TEXT")
    private String executionLog;
}

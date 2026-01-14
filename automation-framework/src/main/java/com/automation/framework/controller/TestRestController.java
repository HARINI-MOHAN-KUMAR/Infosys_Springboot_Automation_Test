package com.automation.framework.controller;

import com.automation.framework.entity.ExecutionResult;
import com.automation.framework.entity.TestCase;
import com.automation.framework.service.AutomationExecutorService;
import com.automation.framework.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/execution")
public class TestRestController {

    @Autowired
    private AutomationExecutorService executorService;

    @Autowired
    private TestCaseService testCaseService;

    @PostMapping("/run/{id}")
    public ResponseEntity<ExecutionResult> runTest(@PathVariable Long id) {
        TestCase testCase = testCaseService.getTestCaseById(id)
                .orElseThrow(() -> new RuntimeException("Test not found"));

        ExecutionResult result = executorService.executeTest(testCase);
        return ResponseEntity.ok(result);
    }
}

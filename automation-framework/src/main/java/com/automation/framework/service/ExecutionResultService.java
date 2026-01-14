package com.automation.framework.service;

import com.automation.framework.entity.ExecutionResult;
import com.automation.framework.repository.ExecutionResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExecutionResultService {

    @Autowired
    private ExecutionResultRepository repository;

    public List<ExecutionResult> getRecentResults() {
        return repository.findTop10ByOrderByExecutionTimeDesc();
    }

    public ExecutionResult getResultById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Result not found"));
    }
}

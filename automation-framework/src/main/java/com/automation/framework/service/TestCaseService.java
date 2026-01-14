package com.automation.framework.service;

import com.automation.framework.entity.TestCase;
import com.automation.framework.repository.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestCaseService {

    @Autowired
    private TestCaseRepository repository;

    public List<TestCase> getAllTestCases() {
        return repository.findAll();
    }

    public TestCase saveTestCase(TestCase testCase) {
        return repository.save(testCase);
    }

    public Optional<TestCase> getTestCaseById(Long id) {
        return repository.findById(id);
    }

    public void deleteTestCase(Long id) {
        repository.deleteById(id);
    }
}

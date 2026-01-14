package com.automation.framework.controller;

import com.automation.framework.entity.TestCase;
import com.automation.framework.service.ExecutionResultService;
import com.automation.framework.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestCaseController {

    @Autowired
    private TestCaseService testCaseService;

    @Autowired
    private ExecutionResultService executionResultService;

    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("testCases", testCaseService.getAllTestCases());
        model.addAttribute("recentResults", executionResultService.getRecentResults());
        return "dashboard";
    }

    @GetMapping("/test/new")
    public String createTestForm(Model model) {
        model.addAttribute("testCase", new TestCase());
        return "test_form";
    }

    @PostMapping("/test/save")
    public String saveTest(@ModelAttribute TestCase testCase) {
        testCaseService.saveTestCase(testCase);
        return "redirect:/";
    }

    @GetMapping("/test/delete/{id}")
    public String deleteTest(@PathVariable Long id) {
        testCaseService.deleteTestCase(id);
        return "redirect:/";
    }

    @GetMapping("/history")
    public String history(Model model) {
        // Reusing the service method for now, in real app we'd have pagination
        model.addAttribute("results", executionResultService.getRecentResults());
        return "history";
    }

    @GetMapping("/analytics")
    public String analytics() {
        return "analytics";
    }

    @GetMapping("/settings")
    public String settings() {
        return "settings";
    }
}

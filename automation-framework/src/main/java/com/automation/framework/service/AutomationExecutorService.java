package com.automation.framework.service;

import com.automation.framework.core.BrowserFactory;
import com.automation.framework.entity.ExecutionResult;
import com.automation.framework.entity.TestCase;
import com.automation.framework.repository.ExecutionResultRepository;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;

@Service
@Slf4j
public class AutomationExecutorService {

    @Autowired
    private BrowserFactory browserFactory;

    @Autowired
    private ExecutionResultRepository executionResultRepository;

    public ExecutionResult executeTest(TestCase testCase) {
        log.info("Starting execution for test: {}", testCase.getTestName());
        ExecutionResult result = new ExecutionResult();
        result.setTestCase(testCase);
        result.setExecutionTime(LocalDateTime.now());

        StringBuilder executionLog = new StringBuilder();
        WebDriver driver = null;

        try {
            driver = browserFactory.createDriver();
            executionLog.append("Browser launched successfully.\n");

            // Simple Keyword Driven Logic
            String[] steps = testCase.getTestSteps().split("\n");

            for (String step : steps) {
                if (step.trim().isEmpty())
                    continue;
                processStep(driver, step.trim(), executionLog);
            }

            result.setStatus("PASS");
            executionLog.append("Test executed successfully.\n");

        } catch (Exception e) {
            log.error("Test failed", e);
            result.setStatus("FAIL");
            executionLog.append("Test Failed: ").append(e.getMessage()).append("\n");
            // In a real app, capture screenshot here
        } finally {
            if (driver != null) {
                driver.quit();
                executionLog.append("Browser closed.\n");
            }
        }

        result.setExecutionLog(executionLog.toString());
        return executionResultRepository.save(result);
    }

    private void processStep(WebDriver driver, String step, StringBuilder logs) {
        // Format: KEYWORD|TARGET|DATA
        // Example: OPEN|https://google.com
        // TYPE|name:q|Selenium
        // CLICK|name:btnK

        String[] parts = step.split("\\|");
        String keyword = parts[0].toUpperCase();

        logs.append("Executing: ").append(step).append("\n");

        switch (keyword) {
            case "OPEN":
                driver.get(parts[1]);
                break;
            case "TYPE":
                WebElement element = findElement(driver, parts[1]);
                element.sendKeys(parts[2]);
                break;
            case "CLICK":
                WebElement btn = findElement(driver, parts[1]);
                btn.click();
                break;
            case "ASSERT_TITLE":
                String actualTitle = driver.getTitle();
                if (!actualTitle.contains(parts[1])) {
                    throw new RuntimeException(
                            "Title assertion failed. Expected " + parts[1] + " but got " + actualTitle);
                }
                break;
            case "WAIT":
                try {
                    Thread.sleep(Long.parseLong(parts[1]));
                } catch (InterruptedException e) {
                }
                break;
            default:
                logs.append("Unknown keyword: ").append(keyword).append("\n");
        }
    }

    private WebElement findElement(WebDriver driver, String locator) {
        // Locator format: type:value (e.g., id:submit, name:q, css:.btn)
        String[] locParts = locator.split(":", 2);
        String type = locParts[0].toLowerCase();
        String value = locParts[1];

        switch (type) {
            case "id":
                return driver.findElement(By.id(value));
            case "name":
                return driver.findElement(By.name(value));
            case "css":
                return driver.findElement(By.cssSelector(value));
            case "xpath":
                return driver.findElement(By.xpath(value));
            default:
                throw new IllegalArgumentException("Invalid locator type: " + type);
        }
    }
}

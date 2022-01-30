package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "./src/test/java/com/features",
        glue = {"/com/stepDefinitions"}, // path of step definition
        plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true,
        dryRun = false) // check all the steps have the definitions and will not execute


public class TestRunner extends AbstractTestNGCucumberTests {
}

package com.stepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.CommonUtils;
import utils.ConfigProperties;

import java.io.IOException;

public class Hooks {

    @Before
    public static void setup(){
        ConfigProperties readProperty = new ConfigProperties();
        readProperty.initialize();
    }

    @After
    public static void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {

            String screenshotName = scenario.getName().replaceAll(" ", "_");

            byte[] screenshot = ((TakesScreenshot) CommonUtils.appDriver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", screenshotName);
        }
    }
}
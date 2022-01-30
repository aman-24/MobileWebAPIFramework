package com.stepDefinitions;

import base.AppiumServer;
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
    public static void setup() {
        ConfigProperties readProperty = new ConfigProperties();
        readProperty.initialize();
    }


    @After
    public static void tearDown(Scenario scenario) throws IOException {
        if (CommonUtils.appDriver != null && scenario.isFailed()) {

            String screenshotName = scenario.getName().replaceAll(" ", "_");

            byte[] screenshot = ((TakesScreenshot) CommonUtils.appDriver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", screenshotName);
        }
        else if (CommonUtils.webDriver != null && scenario.isFailed()) {

            String screenshotName = scenario.getName().replaceAll(" ", "_");

            byte[] screenshot = ((TakesScreenshot) CommonUtils.webDriver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", screenshotName);
        }

        if (CommonUtils.appDriver != null)
            CommonUtils.appDriver.quit();

        if (CommonUtils.webDriver != null)
            CommonUtils.webDriver.quit();
        AppiumServer.stop();
    }
}
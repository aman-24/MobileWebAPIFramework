package com.stepDefinitions;

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
    public static void setup() throws Exception {
        ConfigProperties readProperty = new ConfigProperties();
        readProperty.initialize();
        CommonUtils utils = new CommonUtils();
        if (ConfigProperties.platform.equalsIgnoreCase("Android"))
            utils.launchMobileDriver();
        else if (ConfigProperties.platform.equalsIgnoreCase("Web"))
            System.out.println("Running web app");
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
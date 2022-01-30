package com.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import screens.ChromeScreen;
import screens.HomeScreen;
import utils.CommonUtils;

public class SelendroidSteps extends CommonUtils {
    public static final Logger log = Logger.getLogger(SelendroidSteps.class);
    HomeScreen hs = new HomeScreen(appDriver);
    ChromeScreen cs = new ChromeScreen(appDriver);

    @Given("^User Opens the App$")
    public void userOpensTheApp() throws Exception {
        log.info("Selendroid app is opened");
    }

    @Then("^Verify home screen title.$")
    public void verifyHomeScreenTitle() {
        log.info("Verify title of the home page");
        hs.verifyHomeTile();
    }

    @And("Verify all home screen elements.")
    public void verifyAllHomeScreenElements() {
        log.info("Validate all home screen elements");
        hs.validatesHomeScreenElements();
    }

    @When("User clicks on Chrome button.")
    public void userClicksOnChromeButton() {
        log.info("User clicks on Chrome button");
        hs.clickChromeButton();
    }

    @Then("Verify text heading.")
    public void verifyTextHeading() {
        log.info("User verifies heading");
    }

    @And("Enter his name {string}.")
    public void enterHisName(String arg0) {
        log.info("User enters his name");
        cs.enterName(arg0);
    }
}

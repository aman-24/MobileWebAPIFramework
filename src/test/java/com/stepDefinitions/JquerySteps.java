package com.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import utils.CommonUtils;
import utils.ConfigProperties;
import webScreens.DroppableScreen;
import webScreens.HomeScreen;

public class JquerySteps extends CommonUtils {
    public static final Logger log = Logger.getLogger(SelendroidSteps.class);
    HomeScreen hs ;
    DroppableScreen ds;

    @Given("User Opens browser.")
    public void userOpensBrowser() throws Exception {
        log.info("User opens the browser");
        launchWebDriver();
        hs = new HomeScreen(webDriver);
        ds = new DroppableScreen(webDriver);
    }

    @Then("User open Jquery UI Website.")
    public void userOpenJqueryUIWebsite() {
        log.info("User goes to " + ConfigProperties.baseWebURL);
        webDriver.get(ConfigProperties.baseWebURL);
    }

    @When("User clicks on Demo option.")
    public void userClicksOnDemoOption() {
        log.info("User clicks on demos option");
        hs.clickDemos();
    }

    @When("User clicks on Droppable option.")
    public void userClicksOnDroppableOption() {
        log.info("User clicks on droppable");
        hs.clickDroppable();
    }

    @Then("User drags and drops.")
    public void userDragsAndDrops() {
        ds.dragAndDrop();
    }
}

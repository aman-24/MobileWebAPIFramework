package com.stepDefinitions;

import api.CreateUser;
import api.GetUser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.testng.Assert;
import utils.APIUtils.HeaderBuilder;
import utils.APIUtils.RestUtils;
import utils.APIUtils.URLBuilder;

import java.util.HashMap;

public class APISteps extends RestUtils {
    public static final Logger log = Logger.getLogger(SelendroidSteps.class);
    HeaderBuilder header = new HeaderBuilder();
    GetUser getUserResponse;
    CreateUser createUserResponse;
    Response response;
    String endpoint;

    @Given("User creates the API Endpoint")
    public void userCreatesTheAPIEndpoint() {
        log.info("Get the user endpoint");
        endpoint = URLBuilder.getUserEndPointUrl();
    }

    @When("User send get request for Page {string}")
    public void userSendGetRequestForPage(String arg0) {
        log.info("User send get request wiht page number = " + arg0);
        HashMap pram = new HashMap<String, String>();
        pram.put("page", arg0);
        response = getRequest(endpoint, pram,  header.getBasicHeaders());
    }

    @Then("User validates if status code is {int}")
    public void userValidatesIfStatusCodeIs(int arg0) {
        log.info("User verifies the status code");
        Assert.assertTrue(getStatusCode(response) == arg0, "Status code is not " + arg0);
    }

    @And("User reads the response for get user")
    public void userReadsTheResponse() {
        log.info("user reads the response in POJO format");
        response.body().print();
        getUserResponse = response.getBody().as(GetUser.class);
    }

    @And("User validate {string} for id <{int}>")
    public void userValidateFirId(String arg0, int arg1) {
        log.info("User verifies the name of employee for id " + arg1);
        for (GetUser.Data data: getUserResponse.data){
            if (data.id == arg1)
                Assert.assertTrue(data.first_name.equals(arg0), "First name did not match");
        }
    }

    @When("User send post request for {string} and {string}")
    public void userSendPostRequestForAnd(String arg0, String arg1) {
        HashMap body = new HashMap<String, String>();
        body.put("name", arg0);
        body.put("job", arg1);
        response = postRequest(endpoint, header.getBasicHeaders(), body);
    }

    @And("User validate if ID is generated")
    public void userValidateIfIDIsGenerated() {
        Assert.assertNotNull(createUserResponse.id);
    }

    @And("User reads the response for create user")
    public void userReadsTheResponseForCreateUser() {
        log.info("user reads the response in POJO format");
        createUserResponse = response.getBody().as(CreateUser.class);
    }

    @And("User Validate response schema {string}")
    public void userValidateResponseSchema(String arg0) {
        log.info("User validates schema");
        validateJsonSchema(response, "responseSchema/" + arg0);
    }
}

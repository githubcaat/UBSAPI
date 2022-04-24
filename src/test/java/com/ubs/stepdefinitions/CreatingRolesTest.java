package com.ubs.stepdefinitions;

import com.ubs.pojos.Role;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class CreatingRolesTest {
    Response response;
    Role requestRole;

    @Given("User creates a mock data for creating a new roles")
    public void user_creates_a_mock_data_for_creating_a_new_roles() {
    requestRole=new Role("Manager");
    }
    @Then("User sends POST request {string} with {string} ,{string},{string}")
    public void user_sends_post_request_with(String end_point, String Role1, String Role2, String Role3) {
        response=given().
                contentType(ContentType.JSON).
                body(requestRole).
                when().
                post(end_point);
    }
    @Then("User validates that role data was created")
    public void user_validates_that_role_data_was_created() {
        Role actualRoleData=response.as(Role.class);
        Assert.assertEquals(requestRole.getRole(),actualRoleData.getRole());

    }
    }



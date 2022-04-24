package com.ubs.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

public class AssociateRolesTest {
    Response response;
    HashMap<String,Object> role=new HashMap<>();

    @Given("User sends PATCH request {string} with {string},{string}")
    public void user_sends_patch_request_with(String end_point, String employeeId, String employeeRole) {
        role.put("employeeId",employeeId);
        role.put("employeeRole",employeeRole);
        response=given().
                contentType(ContentType.JSON).
                body(role).
                when().patch(end_point);
    }
    @Then("User asserts the Status Code that is {int}")
    public void user_asserts_the_status_code_that_is(int statusCode) {
       Assert.assertEquals(statusCode,response.getStatusCode());
    }
    @Then("User validates that Role is assigned  to employee")
    public void user_validates_that_role_is_assigned_to_employee() {
        JsonPath json=response.jsonPath();
        Assert.assertEquals(role.get("employeeId"),json.getInt("employeeId"));
        Assert.assertEquals(role.get("employeeRole"),json.getInt("employeeRole"));
    }

}

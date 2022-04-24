package com.ubs.stepdefinitions;

import com.ubs.testData.EmployeeData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
public class ListingEmployeesTest  {

    Response response;
    HashMap<String ,Object>expectedData=new HashMap<>();
    @Given("User sends a GET request {string}")
    public void user_sends_a_get_request(String end_point) {

        EmployeeData employee=new EmployeeData();
       expectedData = employee.testData();


        Response response=given().
                accept("application/json").
                when().
                get(end_point);

    }
    @Then("User takes a response")
    public void user_takes_a_response(String end_point) {

        response.prettyPrint();
        JsonPath json=response.jsonPath();


    }
    @Then("User asserts Status Code that is {int}")
    public void user_asserts_status_code_that_is(int statusCode) {

        Assert.assertEquals(statusCode,response.getStatusCode());
    }
    @Then("User validates all of employee's list")
    public void user_validates_all_of_employee_s_list() {
        JsonPath json=response.jsonPath();
        Assert.assertEquals(expectedData.get("firstName"),json.getString("data[0].employeeFirstName"));
        Assert.assertEquals(expectedData.get("lastName"),json.getString("data[0].employeeLastName"));
        Assert.assertEquals(expectedData.get("employeeId"),json.getInt("data[0].employeeId"));
    }


}

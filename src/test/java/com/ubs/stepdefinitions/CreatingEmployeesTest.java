package com.ubs.stepdefinitions;

import com.ubs.pojos.Employee;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import static io.restassured.RestAssured.given;


public class CreatingEmployeesTest {
    Response response;
    Employee requestEmployee;
    @Given("User creates a mock data for creating a new employee")
    public void user_creates_a_mock_data_for_creating_a_new_employee() {
       requestEmployee=new Employee("Elon","Musk",123456);//expected

    }
    @Then("User sends POST request {string} with mock data")
    public void user_sends_post_request_with_mock_data(String end_point) {
       response=given().
               contentType(ContentType.JSON).
               body(requestEmployee).
               when().
               post(end_point);
    }

    @Then("User validates that data was created")
    public void user_validates_that_data_was_created() {

        Employee actualData=response.as(Employee.class);//pojodan alindi
        Assert.assertEquals(requestEmployee.getEmployeeFirstName(),actualData.getEmployeeFirstName());
        Assert.assertEquals(requestEmployee.getEmployeeLastName(),actualData.getEmployeeLastName());
        Assert.assertEquals(requestEmployee.getEmployeeId(),actualData.getEmployeeId());

}}

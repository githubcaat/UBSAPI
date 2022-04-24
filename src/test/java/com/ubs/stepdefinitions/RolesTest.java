package com.ubs.stepdefinitions;

import com.ubs.pojos.Role;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;



public class RolesTest {
    Response response;
    Role requestRole;
    @Then("User validates all of role's list")
    public void user_validates_all_of_role_s_list() {

        Role actualRoleData=response.as(Role.class);
        Assert.assertEquals(requestRole.getRole(),actualRoleData.getRole());
        }

    }


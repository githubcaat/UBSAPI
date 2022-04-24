package com.ubs.testBase;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class TestBaseUrl {
    //this are for end_points but I didn't use because of i don't have it
    //i just wrote it for you
    protected RequestSpecification spec;
    @Before
    public void setup(){
        spec=new RequestSpecBuilder().
                setBaseUri("url").
                build();
    }
}

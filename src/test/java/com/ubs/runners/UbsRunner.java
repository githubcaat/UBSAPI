package com.ubs.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:Reports/htmlReport.html",
                "json:Reports/jsonReport.json"},
        features="src/test/resources/features",
        glue="com/ubs/stepdefinitions",
        dryRun = true,
        tags="@roles"
       //publish=true
)
public class UbsRunner {

}

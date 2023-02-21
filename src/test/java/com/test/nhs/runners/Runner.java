package com.test.nhs.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/Login.feature",
        //feature file right click copy path from content root
        glue = "com/test/nhs/stepdefinitions",
        //stepdefinitions package right click copy path from source root
        dryRun = false,
//        tags = "@regression",
        plugin = {"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt",
                "json:target/cucumber-reports/cucumber.json"}
)



public class Runner {
}

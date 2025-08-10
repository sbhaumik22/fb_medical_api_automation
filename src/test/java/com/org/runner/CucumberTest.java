package com.org.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = {"com/org/api/stepDefinitions", "com/org/hooks", "com/org/utils"}, plugin = {
        "pretty",
        "json:target/jsonReports/cucumber.json",
        "html:target/cucumber-html-report"
}, monochrome = true)
public class CucumberTest {

}

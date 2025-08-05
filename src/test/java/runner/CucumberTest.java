package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",            // Path to .feature files
        glue = {"stepDefinitions"},                 // Step definitions and hooks packages
        plugin = {
                "pretty",
                "json:target/jsonReports/cucumber.json",         // JSON report for reporting plugin
                "html:target/cucumber-html-report" // optional HTML report
        },
        monochrome = true                                   // Cleaner console output
//        tags = "@SignUp"                                     // Run specific tag
)
public class CucumberTest {

}

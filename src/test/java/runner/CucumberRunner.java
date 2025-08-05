package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/login.feature",            // Path to .feature files
        glue = "stepDefinitions",                            // Step definitions package
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"
        },
        monochrome = true                                   // Cleaner console output
//        tags = "@SignUp"                                     // Run specific tag
)
public class CucumberRunner {


}

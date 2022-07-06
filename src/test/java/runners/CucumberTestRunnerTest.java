package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",glue = {"stepdefinitions", "utils"},
        monochrome = true,
        plugin = {
                "pretty",
                "html:target/cucumber-report/cucumber.html"}
)
public class CucumberTestRunnerTest {
}
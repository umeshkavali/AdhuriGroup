package testRunner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src\\test\\java\\features",
        glue = "stepDefinitions",
        plugin = {"pretty", "html:target/cucumber-reports"}
)

public class TestRun 
{
	
}

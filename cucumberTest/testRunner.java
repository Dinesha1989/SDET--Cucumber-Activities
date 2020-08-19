package cucumberTest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	
    features = "src/Feature",
    glue = {"stepDefinition"},
   tags={"@activity2_5"},
   plugin = {"pretty", "json:Reports/json_report"},	
   monochrome = true,
  strict = true
)

public class testRunner {

	
}

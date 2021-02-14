package runner;

import io.cucumber.testng.*;

/*
 * The below syntax is to run using Junit
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features", glue = {"stepDefinition"})
public class RegressionRunner {	
	
}
*/

@CucumberOptions(glue = "stepDefinitions", 
features = "src/test/java/features", 
plugin = { "html:target/cucumber-htmlreport", "json:target/cucumber-report.json" }, 
monochrome = true)
public class RegressionRunner extends AbstractTestNGCucumberTests{

}
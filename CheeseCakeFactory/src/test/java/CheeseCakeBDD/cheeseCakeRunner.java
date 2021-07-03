package CheeseCakeBDD;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources", 
		glue ="stepDefinition",
		tags=" @sprint3"
		//plugin = {"html:target/cucumber-html-report"}
		)

public class cheeseCakeRunner {
	
	

}

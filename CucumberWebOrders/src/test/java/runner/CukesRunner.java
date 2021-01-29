package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

    features="src\\main\\resources\\Features",
    glue="step_definitions",
	dryRun=false,	
	monochrome=true,	
	tags="@Login",
    plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
	                 "junit:target/cucumber-reports/Cucumber.xml",
	                 "html:target/cucumber-reports/report.html",
	                 "rerun:target/rerun.txt"}
	
		)


public class CukesRunner {

}

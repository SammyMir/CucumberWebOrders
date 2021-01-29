package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="@target/rerun.txt",//Cucumber picks the failed scenarios from this file
        glue="step_definitions",
        dryRun=false,
        monochrome=true,
        tags="@Login",
        plugin = { "pretty", "json:target/cucumber-reports/CucumberReport.json",
                 "junit:target/cucumber-reports/CucumberReport.xml",
                 "html:target/cucumber-reports/CucumberReport.html"}
        )


public class FailedScenariosRunner {

}

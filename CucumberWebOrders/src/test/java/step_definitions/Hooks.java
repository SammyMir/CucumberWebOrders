package step_definitions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Driver;

public class Hooks {

	
	 WebDriver driver;
	    
	    @Before()
	    public void setUp(Scenario scenario) {
	        
	        WebDriverManager.chromedriver().setup();
	        driver=Driver.getDriver();
	        driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	        System.out.println("I am in the hooks before ");
	    }
	    
	    @After()
	    public void tearDown(Scenario scenario)  {
	      if(scenario.isFailed()) {
	        TakesScreenshot ts = (TakesScreenshot)Driver.getDriver();
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        try {
				FileUtils.copyFile(source, new File("./Screenshot/Screen.png"));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	        System.out.println("the Screenshot is taken");
	        Driver.closeDriver();
	    }
	        Driver.closeDriver();
	        System.out.println("I am in the hooks after. ");
	    }
	
}

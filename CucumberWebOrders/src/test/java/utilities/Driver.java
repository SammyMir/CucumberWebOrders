package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

private static WebDriver driver;
    
    private Driver() {
        
    }
    
    public static WebDriver getDriver() {
        if(driver==null) {
            String browserType=ConfigReader.getProperty("browser");
            switch(browserType) {
            
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();    
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver=new InternetExplorerDriver();
                break;
            }
        }
    
        return driver;
    }
    
    public static void closeDriver() {
        if(driver!=null) {
            driver.quit();
            driver=null;
        }
    }
	
}

package stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass
{
	public static WebDriver driver;
	
	@Before
    public void setUp(Scenario scenario)
	{
        BaseClass.setUp(); 
    }

    @After
    public void tearDown(Scenario scenario)
    {
    	BaseClass.tearDown(); 
    }
    
    @AfterStep
    public void getScreenshot(Scenario scenario)
    {
    	if (scenario.isFailed()) 
    	{
            if (driver != null) 
            { // Check if driver is not null
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            } 
            
            else 
            {
                System.err.println("Driver is null. Cannot capture screenshot.");
            }
        }
    }
}

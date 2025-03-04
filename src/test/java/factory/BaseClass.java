package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{	

	public static WebDriver driver;    
	
	
    public static void setUp() 
    {
    	
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
       
    }
    
    
    public static void tearDown() 
    {
        if (driver != null) 
        {
            driver.quit();
        }
        
    }

}

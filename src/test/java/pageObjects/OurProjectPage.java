package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OurProjectPage extends BasePage
{
	
	@FindBy(xpath = "(//div[@class='elementor-widget-container']//a//img)[not(ancestor::header)][position()<=18]")
    public List<WebElement> projectImages; 
	
	
	public OurProjectPage(WebDriver driver) 
	{
		super(driver);
	}

    public void navigateToHomePage(String url) 
    {
        driver.get(url);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public List<WebElement> getProjectImages() 
    {
        return driver.findElements(By.xpath("(//div[@class='elementor-widget-container']//a//img)[not(ancestor::header)][position()<=18]"));
    }

    public List<String> captureOpenedWindowTitles() 
    {
        List<String> titles = new ArrayList<>();
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) 
        {
            if (!originalWindow.contentEquals(windowHandle)) 
            {
                driver.switchTo().window(windowHandle);
                titles.add(driver.getTitle());
                driver.close();
            }
        }
        driver.switchTo().window(originalWindow);
        return titles;
    }
}

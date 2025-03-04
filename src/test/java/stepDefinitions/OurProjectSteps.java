package stepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import factory.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.OurProjectPage;

public class OurProjectSteps extends BaseClass
{
//	public WebDriver driver;
	public OurProjectPage ourProjectPage;

    @Given("User launch the browser")
    public void userLaunchTheBrowser() 
    {
        ourProjectPage = new OurProjectPage(driver);
    }

    @Then("User navigates to the URL {string}")
    public void userNavigatesToTheURL(String url) 
    {
        ourProjectPage.navigateToHomePage(url);
    }

    @And("User verify the page title as {string} visible successfully")
    public void userVerifyThePageTitleAsVisibleSuccessfully(String expectedTitle) 
    {
        String actualTitle = ourProjectPage.getPageTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println("Capturing the Page Title as:"+expectedTitle);
    }

    
    @Then("User clicks on each Image present on the WebPage under Our Projects")
    public void userClicksOnEachImagePresentOnTheWebPageUnderOurProjects() 
    {
        List<WebElement> images = ourProjectPage.getProjectImages();
        for (WebElement image : images) 
        {
            try {
                WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(20));
                WebElement clickableImage = mywait.until(ExpectedConditions.elementToBeClickable(image));
                clickableImage.click();

                // Capture the opened window titles after clicking each image
                List<String> titles = ourProjectPage.captureOpenedWindowTitles();
                System.out.println("Captured Titles: " + titles);

            } 
            catch (ElementClickInterceptedException e) 
            {
            	System.out.println(e.getMessage());
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", image);
            }
        }
    }

    @Then("User capture each page title of Opened window")
    public void userCaptureEachPageTitleOfOpenedWindow() 
    {
        List<String> titles = ourProjectPage.captureOpenedWindowTitles();
        System.out.println("Opened Window Titles: " + titles);
    }

    @And("User close the browser")
    public void userCloseTheBrowser() 
    {
    	
    }
	
	
}

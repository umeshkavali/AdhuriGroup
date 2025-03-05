package testRunner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= {"C:\\Users\\umesh\\OneDrive\\Desktop\\Eclipse\\AdhuriGroup\\src\\test\\java\\features"},
		glue="stepDefinitions",
		plugin= {"pretty", "html:reports/myreport.html", 
				"rerun:target/rerun.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
			},
		
		dryRun=false,    // checks mapping between scenario steps and step definition methods
		monochrome=true,    // to avoid junk characters in output
		publish=true  		// the reports can see it in web browser if it's in true
	    
	)

public class TestRun 
{
	
}

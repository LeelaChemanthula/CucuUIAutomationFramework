package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
		
		features = {
						"src/test/java/Features/ViewPrivacyPolicy.feature"
					}
		,glue = ("com.stepdefinitions")
		//,tags = {}
		//,dryRun = true
		,plugin = {
					"pretty","html:cucumberreports/cucumber-html-report.html",
					"json:cucumberreports/cucumber-json-report.json",
					"junit:cucumberreports/cucumber-xml-report.xml",
					"rerun:cucumberreports/rerun.txt",
				  },
		monochrome = true
		)

@RunWith(Cucumber.class)
public class testExcludeFromRun {

}

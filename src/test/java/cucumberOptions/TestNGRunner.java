package cucumberOptions;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cucumber.listener.Reporter;
import config.ConfigFileReader;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(
		features = "src/test/java/features",
		glue = {"stepDefinitions"},
		tags = {"@product"},
		format = {
				"pretty",
				"html:target/cucumber-reports/cucumber-pretty",
				"json:target/cucumber-reports/CucumberTestReport.json",
				"rerun:target/cucumber-reports/rerun.txt"
		},plugin = {"json:target/cucumber-reports/CucumberTestReport.json",
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"})

public class TestNGRunner {
	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}

	/**
	 * @return returns two dimensional array of {@link CucumberFeatureWrapper} objects.
	 */

	@DataProvider
	public Object[][] features() {
		return testNGCucumberRunner.provideFeatures();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
		//driver.quit();
		Reporter.loadXMLConfig(new File(ConfigFileReader.getConfigPropertyVal("reportConfigPath")));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		testNGCucumberRunner.finish();

	}

}

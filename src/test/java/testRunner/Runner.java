package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "FeatureFiles" }, tags = "@customer", monochrome = true, dryRun = false, glue = {
		"stepDefinition" }, plugin = { "pretty", "junit:target/cucumber/customertestcase.xml","json:target/cucumber/customertestcase.json","html:target/cucumber/customertestcase.html" })
public class Runner {

}

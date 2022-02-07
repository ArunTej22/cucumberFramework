package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"FeatureFile"},tags= {"@Multipledata"},glue= {"LoginstepsMultidata"},monochrome=true,plugin= {"pretty", "html:target/cucumber-reports"})

public class RunnerMultidata {
	

}

 package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features ="./src/test/resources/LoginValid.feature"
,glue = {"stepDefinitions"},tags="@Sanity"
,plugin= {"pretty","html:target/Bddreport.html"})
public class RunnerClass
{
	
}

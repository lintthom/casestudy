package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src\\test\\resources\\e-learningsignup\\E-learning_SignUp.feature"},
glue=  {"elearning_stepdefinition"},
dryRun = false,
strict=true,
plugin= {"html:testoutput/cucucmber.html","junit:testoutput/cucmber.xml", "json:testoutput/cucumber.json"})
public class Test_Runner {
	


}

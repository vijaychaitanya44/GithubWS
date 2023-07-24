package com.qa.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "D:/GithubWS/Git_Maven_Proj/Cucumber_Rest_Framework/src/test/resources/featurefiles",
				 glue = {"com.qa.stepDef","com.qa.hooks"},
				 tags = "@naukri",
				 monochrome = true,
				 plugin = { "pretty","html:target/cucumber.html" })
public class TestCaseRunner {

}
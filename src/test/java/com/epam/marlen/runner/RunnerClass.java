package com.epam.marlen.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "json:target/cucumber-report.json",
        "html:target/cucumber-report" }, features = "src/test/resources/cucumber/mail_base.feature", glue = {
        "com/epam/marlen/steps"})
public class RunnerClass extends AbstractTestNGCucumberTests{
}

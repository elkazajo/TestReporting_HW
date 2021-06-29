package com.epam.marlen.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "json:target/cucumber-report.json",
        "html:target/cucumber-report" }, features = "src/test/resources/cucumber/mail_base.feature", glue = {
        "com/epam/marlen/steps"})
public class RunnerClass extends AbstractTestNGCucumberTests{
//    public static void main(String[] args) {
//        TestNG testNG = new TestNG();
//
//        XmlSuite xmlSuite = new XmlSuite();
//        xmlSuite.setName("SeleniumHW");
//        List<String> files = new ArrayList<>(new ArrayList<>() {
//            {
//                add("testng.xml");
//            }
//        });
//        xmlSuite.setSuiteFiles(files);
//
//        List<XmlSuite> suites = new ArrayList<>();
//        suites.add(xmlSuite);
//        testNG.setXmlSuites(suites);
//        testNG.run();
//    }
}

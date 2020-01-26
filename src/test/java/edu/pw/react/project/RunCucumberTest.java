package edu.pw.react.project;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty", features = "src/test/resources/is_it_friday_yet.feature")
//@CucumberOptions(plugin = "pretty", features = "src/test/resources/hellocucumber")
public class RunCucumberTest
{
}
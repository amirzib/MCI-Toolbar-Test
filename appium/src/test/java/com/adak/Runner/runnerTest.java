package com.adak.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/resources/feature/login.feature"},
    glue = {"com.adak.step_defenitions"},
    dryRun = false,
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome = true
    // tags="@A"
    )
public class runnerTest {

}

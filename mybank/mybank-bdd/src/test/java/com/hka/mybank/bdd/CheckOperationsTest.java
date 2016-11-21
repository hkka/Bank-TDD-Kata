package com.hka.mybank.bdd;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.runtime.arquillian.api.Tags;

@Tags("@ShowAllClientOperations")
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/operations.feature", plugin = {"pretty", "html:target/cucumber"})
public class CheckOperationsTest {

}

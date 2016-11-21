package com.hka.mybank.bdd;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.runtime.arquillian.api.Tags;

@Tags("@WithDrawAmountIsSubstractedFromExistingBalance")
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/withdraw.feature", plugin = {"pretty", "html:target/cucumber"})
public class WithDrawOperationTest {

}

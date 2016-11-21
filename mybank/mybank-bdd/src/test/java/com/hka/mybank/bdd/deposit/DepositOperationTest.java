package com.hka.mybank.bdd.deposit;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.runtime.arquillian.api.Tags;

@Tags("@DepositAmountIsAddedToExistingBalance")
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/deposit.feature", plugin = {"pretty", "html:target/cucumber"})
public class DepositOperationTest {

}

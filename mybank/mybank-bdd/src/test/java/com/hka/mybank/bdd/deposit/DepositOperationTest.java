package com.hka.mybank.bdd.deposit;

import org.junit.runner.RunWith;

import com.hka.mybank.bdd.utils.DepositOperationStepsDef;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.runtime.arquillian.api.Glues;
import cucumber.runtime.arquillian.api.Tags;

@Glues({ DepositOperationStepsDef.class })
@Tags("@DepositAmountIsAddedToExistingBalance")
@RunWith(Cucumber.class)
//@CucumberOptions(features = "features/deposit.feature", plugin = {"pretty", "html:target/cucumber"})
@CucumberOptions(features = "test/resources/features/deposit.feature", plugin = {"pretty", "html:target/cucumber"})
public class DepositOperationTest {

}

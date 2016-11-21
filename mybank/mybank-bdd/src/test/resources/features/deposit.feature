Feature: Deposit
        In order to save money
		As a bank client
		I want to make a deposit in my account

  @DepositAmountIsAddedToExistingBalance
  Scenario: Account Balance is increased by deposit amount 
  Given a MyBank client with 20 as account balance
  When i "deposit" 10
  Then my account balance is 30
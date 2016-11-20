Feature: Deposit
        In order to save money
		As a bank client
		I want to make a deposit in my account

  @DepositAmountIsAddedToExistingBalance
  Given a MyBank client
  And a i have an account with 20.00 as current balance
  When i deposit 10.00
  Then my account balance is 30.00
Feature: WithDraw
        In order to retrieve some or all of my savings
		As a bank client
		I want to make a withdrawal from my account

  @WithDrawAmountIsSubstractedFromExistingBalance
  Scenario: Account Balance is updated by withdraw amount 
  Given a MyBank client with 20 as account balance
  When i "retrieve" 10
  Then my account balance is 10
  
  @WithDrawThrowsExceptionWhenWithDrowAmountIsGreaterThanBalance
  Scenario: WithDraw is rejected when amount to retirieve is greater than balance
  Given a MyBank client with 20 as account balance
  When i "retrieve" 30
  Then my account balance is 20
  And a mybankexception is thrown with error message "Insufficient Funds"
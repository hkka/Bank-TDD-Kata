Feature: In order to check my operations
		 As a bank client
		 I want to see the history (operation, date, amount, balance)  of my operations

  @ShowAllClientOperations
  Scenario: Client can visualize his operations
  Given a MyBank client with 20 as account balance
  And i "deposit" 10
  And i "retrieve" 5 
  When i check my operations  
  Then i can see
  | type      | amount  | balance |
  | deposit   | 10      | 30      |
  | withdraw  | 5       | 25      |

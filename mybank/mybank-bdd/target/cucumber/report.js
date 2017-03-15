$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/withdraw.feature");
formatter.feature({
  "line": 1,
  "name": "WithDraw",
  "description": "      In order to retrieve some or all of my savings\r\nAs a bank client\r\nI want to make a withdrawal from my account",
  "id": "withdraw",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 7,
  "name": "Account Balance is updated by withdraw amount",
  "description": "",
  "id": "withdraw;account-balance-is-updated-by-withdraw-amount",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 6,
      "name": "@WithDrawAmountIsSubstractedFromExistingBalance"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "a MyBank client with 20 as account balance",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "i \"retrieve\" 10",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "my account balance is 10",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "20",
      "offset": 21
    }
  ],
  "location": "MyBankOperationStepsDef.a_MyBank_client_with_as_account_balance(int)"
});
formatter.result({
  "duration": 4678276,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "retrieve",
      "offset": 3
    },
    {
      "val": "10",
      "offset": 13
    }
  ],
  "location": "MyBankOperationStepsDef.i(String,int)"
});
formatter.result({
  "duration": 485648,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 22
    }
  ],
  "location": "MyBankOperationStepsDef.my_account_balance_is(int)"
});
formatter.result({
  "duration": 150687,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "WithDraw is rejected when amount to retirieve is greater than balance",
  "description": "",
  "id": "withdraw;withdraw-is-rejected-when-amount-to-retirieve-is-greater-than-balance",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 12,
      "name": "@WithDrawThrowsExceptionWhenWithDrowAmountIsGreaterThanBalance"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "a MyBank client with 20 as account balance",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "i \"retrieve\" 30",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "my account balance is 20",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "a mybankexception is thrown with error message \"Insufficient Funds\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "20",
      "offset": 21
    }
  ],
  "location": "MyBankOperationStepsDef.a_MyBank_client_with_as_account_balance(int)"
});
formatter.result({
  "duration": 172613,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "retrieve",
      "offset": 3
    },
    {
      "val": "30",
      "offset": 13
    }
  ],
  "location": "MyBankOperationStepsDef.i(String,int)"
});
formatter.result({
  "duration": 884058,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "20",
      "offset": 22
    }
  ],
  "location": "MyBankOperationStepsDef.my_account_balance_is(int)"
});
formatter.result({
  "duration": 142755,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Insufficient Funds",
      "offset": 48
    }
  ],
  "location": "MyBankOperationStepsDef.a_mybankexception_is_thrown_with_error_message(String)"
});
formatter.result({
  "duration": 4934862,
  "status": "passed"
});
});
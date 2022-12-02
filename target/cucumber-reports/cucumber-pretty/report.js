$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("TransactionProduct.feature");
formatter.feature({
  "line": 1,
  "name": "Transaction product",
  "description": "",
  "id": "transaction-product",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "User buy the product",
  "description": "",
  "id": "transaction-product;user-buy-the-product",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@product"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Open the list product page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User choose the \"\u003cproduct\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Validate product on detail product page",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "User input criteria to \"\u003ccolor\u003e\" and \"\u003cquantity\u003e\" product",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Tap add cart button",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "Validate product on My Cart Page",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Log in account to proceed payment",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "Fill shipping address",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "Fill account payment",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "Validate checkout deliver data",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "Validate success buy product",
  "keyword": "Then "
});
formatter.examples({
  "line": 17,
  "name": "",
  "description": "",
  "id": "transaction-product;user-buy-the-product;",
  "rows": [
    {
      "cells": [
        "product",
        "color",
        "quantity"
      ],
      "line": 18,
      "id": "transaction-product;user-buy-the-product;;1"
    },
    {
      "cells": [
        "Sauce Lab Back Packs",
        "Blue",
        "2"
      ],
      "line": 19,
      "id": "transaction-product;user-buy-the-product;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 19,
  "name": "User buy the product",
  "description": "",
  "id": "transaction-product;user-buy-the-product;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@product"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Open the list product page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User choose the \"Sauce Lab Back Packs\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Validate product on detail product page",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "User input criteria to \"Blue\" and \"2\" product",
  "matchedColumns": [
    1,
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Tap add cart button",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "Validate product on My Cart Page",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Log in account to proceed payment",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "Fill shipping address",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "Fill account payment",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "Validate checkout deliver data",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "Validate success buy product",
  "keyword": "Then "
});
formatter.match({
  "location": "TransactionProductScenario.open_the_list_product_page()"
});
formatter.result({
  "duration": 10167996200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sauce Lab Back Packs",
      "offset": 17
    }
  ],
  "location": "TransactionProductScenario.userChooseThe(String)"
});
formatter.result({
  "duration": 1021362100,
  "status": "passed"
});
formatter.match({
  "location": "TransactionProductScenario.ValidateProductOnDetailPage()"
});
formatter.result({
  "duration": 3292787800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Blue",
      "offset": 24
    },
    {
      "val": "2",
      "offset": 35
    }
  ],
  "location": "TransactionProductScenario.UserInputCriteria(String,int)"
});
formatter.result({
  "duration": 6664785000,
  "status": "passed"
});
formatter.match({
  "location": "TransactionProductScenario.TapAddCartButton()"
});
formatter.result({
  "duration": 258111200,
  "status": "passed"
});
formatter.match({
  "location": "TransactionProductScenario.ValidateProductOnMyCartPage()"
});
formatter.result({
  "duration": 8250322400,
  "status": "passed"
});
formatter.match({
  "location": "TransactionProductScenario.LogInAccount()"
});
formatter.result({
  "duration": 3649754200,
  "status": "passed"
});
formatter.match({
  "location": "TransactionProductScenario.FillShippingAddress()"
});
formatter.result({
  "duration": 11821553200,
  "status": "passed"
});
formatter.match({
  "location": "TransactionProductScenario.FillAccountPayment()"
});
formatter.result({
  "duration": 8809711700,
  "status": "passed"
});
formatter.match({
  "location": "TransactionProductScenario.ValidateCheckoutDeliver()"
});
formatter.result({
  "duration": 7444403600,
  "status": "passed"
});
formatter.match({
  "location": "TransactionProductScenario.ValidateSuccessBuyProduct()"
});
formatter.result({
  "duration": 1144889100,
  "status": "passed"
});
});
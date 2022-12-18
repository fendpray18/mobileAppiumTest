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
    },
    {
      "line": 3,
      "name": "@Android"
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
        "Sauce Lab Back Packs aja",
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
      "name": "@Android"
    },
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
  "name": "User choose the \"Sauce Lab Back Packs aja\"",
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
  "duration": 10050162300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sauce Lab Back Packs aja",
      "offset": 17
    }
  ],
  "location": "TransactionProductScenario.userChooseThe(String)"
});
formatter.result({
  "duration": 20514393400,
  "error_message": "org.openqa.selenium.NoSuchElementException: An element could not be located on the page using the given search parameters.\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027MAJOO-498WTNB-X\u0027, ip: \u0027192.168.25.202\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_291\u0027\nDriver info: io.appium.java_client.android.AndroidDriver\nCapabilities {appWaitActivity: com.saucelabs.mydemoapp.and..., appWaitPackage: com.saucelabs.mydemoapp.and..., automationName: uiautomator2, databaseEnabled: false, desired: {appWaitActivity: com.saucelabs.mydemoapp.and..., appWaitPackage: com.saucelabs.mydemoapp.and..., automationName: uiautomator2, deviceName: Android Device, newCommandTimeout: 14, platformName: android}, deviceApiLevel: 30, deviceManufacturer: realme, deviceModel: RMX1921, deviceName: de0d891a, deviceScreenDensity: 480, deviceScreenSize: 1080x2340, deviceUDID: de0d891a, javascriptEnabled: true, locationContextEnabled: false, networkConnectionEnabled: true, newCommandTimeout: 14, pixelRatio: 3, platform: LINUX, platformName: Android, platformVersion: 11, statBarHeight: 96, takesScreenshot: true, viewportRect: {height: 2036, left: 0, top: 96, width: 1080}, warnings: {}, webStorageEnabled: false}\nSession ID: db0e2ddf-8758-440a-8a67-f9540f203540\n*** Element info: {Using\u003dxpath, value\u003d//android.widget.ImageView[@content-desc\u003d\u0027Sauce Lab Back Packs aja\u0027]}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat io.appium.java_client.remote.AppiumCommandExecutor.execute(AppiumCommandExecutor.java:250)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.execute(DefaultGenericMobileDriver.java:41)\r\n\tat io.appium.java_client.AppiumDriver.execute(AppiumDriver.java:1)\r\n\tat io.appium.java_client.android.AndroidDriver.execute(AndroidDriver.java:1)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElement(DefaultGenericMobileDriver.java:61)\r\n\tat io.appium.java_client.AppiumDriver.findElement(AppiumDriver.java:1)\r\n\tat io.appium.java_client.android.AndroidDriver.findElement(AndroidDriver.java:1)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElementByXPath(DefaultGenericMobileDriver.java:151)\r\n\tat io.appium.java_client.AppiumDriver.findElementByXPath(AppiumDriver.java:1)\r\n\tat io.appium.java_client.android.AndroidDriver.findElementByXPath(AndroidDriver.java:1)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElement(DefaultGenericMobileDriver.java:57)\r\n\tat io.appium.java_client.AppiumDriver.findElement(AppiumDriver.java:1)\r\n\tat io.appium.java_client.android.AndroidDriver.findElement(AndroidDriver.java:1)\r\n\tat pageObjects.MainPage.findProductSelected(MainPage.java:44)\r\n\tat stepDefinitions.TransactionProductScenario.userChooseThe(TransactionProductScenario.java:47)\r\n\tat ✽.When User choose the \"Sauce Lab Back Packs aja\"(TransactionProduct.feature:6)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "TransactionProductScenario.ValidateProductOnDetailPage()"
});
formatter.result({
  "status": "skipped"
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
  "status": "skipped"
});
formatter.match({
  "location": "TransactionProductScenario.TapAddCartButton()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TransactionProductScenario.ValidateProductOnMyCartPage()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TransactionProductScenario.LogInAccount()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TransactionProductScenario.FillShippingAddress()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TransactionProductScenario.FillAccountPayment()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TransactionProductScenario.ValidateCheckoutDeliver()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TransactionProductScenario.ValidateSuccessBuyProduct()"
});
formatter.result({
  "status": "skipped"
});
});
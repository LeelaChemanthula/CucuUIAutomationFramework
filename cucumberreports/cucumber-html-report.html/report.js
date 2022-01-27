$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/Features/FaceBookLogin/LoginFaceBookFeature.feature");
formatter.feature({
  "name": "FaceBook user login validation",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "FaceBook user login validation",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "user launches the application \"FaceBook\"",
  "keyword": "Given "
});
formatter.match({
  "location": "com.stepdefinitions.Steps1.launchesApplication(String,String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "user waits for page to load",
  "keyword": "Then "
});
formatter.match({
  "location": "com.stepdefinitions.Steps1.userWaitsForPage(String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "user is on page \"FaceBookPage\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.stepdefinitions.Steps1.onPage(String,String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "user validates FaceBook Page title",
  "keyword": "Then "
});
formatter.match({
  "location": "com.stepdefinitions.Steps1.validateFaceBookPageTitle(String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "user validates FB Create account message",
  "keyword": "Then "
});
formatter.match({
  "location": "com.stepdefinitions.Steps1.validateFBAppointmentMsg(String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "user enters data in the textbox \"emailOrPhone1\" as \"sample@gmail.com\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.stepdefinitions.Steps1.entersDataInTextbox(String,String,String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "error_message": "org.junit.ComparisonFailure: expected:\u003c[com.customexceptions.PageObjectNotFoundException: \"emailOrPhone1\" not found in page \"FaceBookPage.java\"]\u003e but was:\u003c[sample@gmail.com]\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:115)\r\n\tat org.junit.Assert.assertEquals(Assert.java:144)\r\n\tat com.stepdefinitions.Steps1.entersDataInTextbox(Steps1.java:95)\r\n\tat ✽.user enters data in the textbox \"emailOrPhone1\" as \"sample@gmail.com\"(///D:/CucuUIAutomationFramework/src/test/java/Features/FaceBookLogin/LoginFaceBookFeature.feature:10)\r\n",
  "status": "failed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "skipped"
});
formatter.step({
  "name": "user enters data in the textbox \"password1\" as \"sample\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.stepdefinitions.Steps1.entersDataInTextbox(String,String,String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "status": "skipped"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.beforestep({
  "status": "skipped"
});
formatter.step({
  "name": "user waits for page to load",
  "keyword": "Then "
});
formatter.match({
  "location": "com.stepdefinitions.Steps1.userWaitsForPage(String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "status": "skipped"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.beforestep({
  "status": "skipped"
});
formatter.step({
  "name": "user waits for page to load",
  "keyword": "Then "
});
formatter.match({
  "location": "com.stepdefinitions.Steps1.userWaitsForPage(String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "status": "skipped"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.beforestep({
  "status": "skipped"
});
formatter.step({
  "name": "Step2 class test statement",
  "keyword": "Then "
});
formatter.match({
  "location": "com.stepdefinitions.Steps2.launchesApplication(String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "status": "skipped"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.beforestep({
  "status": "skipped"
});
formatter.step({
  "name": "user closes the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "com.stepdefinitions.Steps1.closesBrowser(String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "status": "skipped"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "FaceBook user login validation Failure",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "user launches the application \"FaceBook\"",
  "keyword": "Given "
});
formatter.match({
  "location": "com.stepdefinitions.Steps1.launchesApplication(String,String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "user waits for page to load",
  "keyword": "Then "
});
formatter.match({
  "location": "com.stepdefinitions.Steps1.userWaitsForPage(String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "user is on page \"FaceBookPage\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.stepdefinitions.Steps1.onPage(String,String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "user validates FaceBook Page title",
  "keyword": "Then "
});
formatter.match({
  "location": "com.stepdefinitions.Steps1.validateFaceBookPageTitle(String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "user validates FB Create account message",
  "keyword": "Then "
});
formatter.match({
  "location": "com.stepdefinitions.Steps1.validateFBAppointmentMsg(String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "user enters data in the textbox \"emailOrPhone\" as \"leelachams@gmail.com\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.stepdefinitions.Steps1.entersDataInTextbox(String,String,String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "user enters data in the textbox \"password\" as \"sample\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.stepdefinitions.Steps1.entersDataInTextbox(String,String,String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "user enters my data",
  "rows": [
    {},
    {}
  ],
  "keyword": "When "
});
formatter.match({
  "location": "com.stepdefinitions.Steps2.entersData(String,DataTable) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "error_message": "org.junit.ComparisonFailure: expected:\u003c[java.lang.NullPointerException]\u003e but was:\u003c[100]\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:115)\r\n\tat org.junit.Assert.assertEquals(Assert.java:144)\r\n\tat com.stepdefinitions.Steps2.entersData(Steps2.java:53)\r\n\tat ✽.user enters my data(///D:/CucuUIAutomationFramework/src/test/java/Features/FaceBookLogin/LoginFaceBookFeature.feature:27)\r\n",
  "status": "failed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "skipped"
});
formatter.step({
  "name": "user waits for page to load",
  "keyword": "Then "
});
formatter.match({
  "location": "com.stepdefinitions.Steps1.userWaitsForPage(String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "status": "skipped"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.beforestep({
  "status": "skipped"
});
formatter.step({
  "name": "user waits for page to load",
  "keyword": "Then "
});
formatter.match({
  "location": "com.stepdefinitions.Steps1.userWaitsForPage(String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "status": "skipped"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.beforestep({
  "status": "skipped"
});
formatter.step({
  "name": "Step2 class test statement",
  "keyword": "Then "
});
formatter.match({
  "location": "com.stepdefinitions.Steps2.launchesApplication(String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "status": "skipped"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.beforestep({
  "status": "skipped"
});
formatter.step({
  "name": "user closes the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "com.stepdefinitions.Steps1.closesBrowser(String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "status": "skipped"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/java/Features/GoogleLogin/LoginGmail.feature");
formatter.feature({
  "name": "Google Search validation",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Google Search validation",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "user launches the application \"Google\"",
  "keyword": "Given "
});
formatter.match({
  "location": "com.stepdefinitions.Steps1.launchesApplication(String,String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "user waits for page to load",
  "keyword": "Then "
});
formatter.match({
  "location": "com.stepdefinitions.Steps1.userWaitsForPage(String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "user is on page \"GooglePage\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.stepdefinitions.Steps1.onPage(String,String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "user clicks the button \"gmailLink\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.stepdefinitions.Steps1.clicksButton(String,String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "user waits for page to load",
  "keyword": "Then "
});
formatter.match({
  "location": "com.stepdefinitions.Steps1.userWaitsForPage(String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "user is on page \"GmailPage\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.stepdefinitions.Steps1.onPage(String,String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "user waits for page to load",
  "keyword": "Then "
});
formatter.match({
  "location": "com.stepdefinitions.Steps1.userWaitsForPage(String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "user clicks the button \"signIn\"",
  "keyword": "Then "
});
formatter.match({
  "location": "com.stepdefinitions.Steps1.clicksButton(String,String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "user enters data in the textbox \"email\" as \"leelacham009@gmail.com\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.stepdefinitions.Steps1.entersDataInTextbox(String,String,String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "error_message": "org.junit.ComparisonFailure: expected:\u003c[org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//input[@id\u003d\u0027identifierId\u0027]\"}\n  ]\u003e but was:\u003c[leelacham009@gmail.com]\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:115)\r\n\tat org.junit.Assert.assertEquals(Assert.java:144)\r\n\tat com.stepdefinitions.Steps1.entersDataInTextbox(Steps1.java:95)\r\n\tat ✽.user enters data in the textbox \"email\" as \"leelacham009@gmail.com\"(///D:/CucuUIAutomationFramework/src/test/java/Features/GoogleLogin/LoginGmail.feature:12)\r\n",
  "status": "failed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "skipped"
});
formatter.step({
  "name": "user clicks the button \"next\"",
  "keyword": "Then "
});
formatter.match({
  "location": "com.stepdefinitions.Steps1.clicksButton(String,String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "status": "skipped"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.beforestep({
  "status": "skipped"
});
formatter.step({
  "name": "user enters data in the textbox \"password\" as \"sample\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.stepdefinitions.Steps1.entersDataInTextbox(String,String,String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "status": "skipped"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.beforestep({
  "status": "skipped"
});
formatter.step({
  "name": "user closes the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "com.stepdefinitions.Steps1.closesBrowser(String) in file:/D:/CucuUIAutomationFramework/target/test-classes/"
});
formatter.result({
  "status": "skipped"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
});
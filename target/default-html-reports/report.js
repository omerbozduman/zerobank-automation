$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Google.feature");
formatter.feature({
  "name": "Search Car in London",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Google"
    }
  ]
});
formatter.scenario({
  "name": "Search Cars in London from Google",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Google"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user is on the Google",
  "keyword": "Given "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.GoogleStepDefs.the_user_is_on_the_Google()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user search \"Cars in London\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.GoogleStepDefs.the_user_search(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "displayed the result",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.GoogleStepDefs.displayed_the_result()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify the available \"gumtree\" Links number",
  "keyword": "And "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.GoogleStepDefs.verifyTheAvailableLinksNumber(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "navigate to each Gumtree Link",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.GoogleStepDefs.navigate_to_each_Gumtree_Link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify the title is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.GoogleStepDefs.verify_the_title_is_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify the number of cars grater the 0",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.GoogleStepDefs.verifyTheNumberOfCarsGraterThe(int)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});
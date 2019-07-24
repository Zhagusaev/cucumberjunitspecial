$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/DBFeatures/MyApplicationTest.feature");
formatter.feature({
  "name": "Testing My Application",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verifying table data with DB",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@db"
    },
    {
      "name": "@jiraid\u003dTED-65432"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User navigates to My Application homepage",
  "keyword": "Given "
});
formatter.match({
  "location": "MyAppSteps.user_navigates_to_My_Application_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User gets the data from UI table",
  "keyword": "And "
});
formatter.match({
  "location": "MyAppSteps.user_gets_the_data_from_UI_table()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify data is matched with DB",
  "keyword": "Then "
});
formatter.match({
  "location": "MyAppSteps.verify_data_is_matched_with_DB()"
});
formatter.result({
  "error_message": "java.sql.SQLException: Invalid column index: getValidColumnIndex\n\tat oracle.jdbc.driver.OracleResultSetMetaData.getValidColumnIndex(OracleResultSetMetaData.java:138)\n\tat oracle.jdbc.driver.OracleResultSetMetaData.getColumnName(OracleResultSetMetaData.java:306)\n\tat Utilities.DBUtils.getColumnNames(DBUtils.java:69)\n\tat StepDefs.MyAppSteps.verify_data_is_matched_with_DB(MyAppSteps.java:80)\n\tat ✽.verify data is matched with DB(file:src/test/resources/DBFeatures/MyApplicationTest.feature:7)\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "status": "passed"
});
});
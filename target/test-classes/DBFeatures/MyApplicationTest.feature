Feature: Testing My Application

  @db @jiraid=TED-65432
    Scenario: Verifying table data with DB
    Given User navigates to My Application homepage
    And User gets the data from UI table
    Then verify data is matched with DB
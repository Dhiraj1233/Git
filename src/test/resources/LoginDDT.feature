Feature: Login data driven

  @DataDriven
  Scenario: Check login with excel credentials
    Given User opens the login Page
    When user enters the credentials from excel and click on login
    When Close the browser

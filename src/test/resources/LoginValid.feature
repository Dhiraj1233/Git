Feature: Login to open Cart

  @Sanity
  Scenario: Login with valid credentials
    Given user opens login page
    When user enter "<username>" and "<password>"
    And click on login button
		Then home page should be displayed
    Then Logout the page
    Then close the browser
    
    
    Examples: 
      | username            | password   |
    	|David5414@gmail.com	| Admin@123	 |
    	
    	
  @Regression
  Scenario: Login with invalid credentials
    Given user opens login page
    When user enter "<username>" and "<password>"
    And click on login button
		Then home page should be displayed
    Then Logout the page
    Then close the browser
    
    
    Examples: 
      | username            | password     |
    	|David5414@gmail.com	| Admin@1232	 |
    	|David5414@gmail.com	| Admin@1234	 |
   
   
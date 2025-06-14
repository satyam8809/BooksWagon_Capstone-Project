Feature: User Login

  Scenario Outline: Login with valid credentials
    Given user is on the login page
    When the user enters email as "<Email>" and password "<Password>" and click login button
    Then user should be logged in successfully

    Examples: 
      | Email                         | Password  |
      | satyamsingh8809793391@gmail.com | satyam@1234 |

  Scenario: Login with invalid credentials
    Given user is on the login page
    When the user enters email as "<Email>" and password "<Password>" and click login button
    Then user should get error message
    
    Examples: 
      | Email                         | Password  |
      | satyamsing8809793391@gmail.com | test@123456 |
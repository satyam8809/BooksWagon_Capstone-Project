Feature: Place Order

  Scenario Outline: Successful book purchase
    Given user is on the login page
    When the user enters email as "<Email>" and password "<Password>" and click login button
    Then user should be logged in successfull
    When user search for "<bookName>"
    And user add the first result to cart
    And user view my cart
    And user proceed to checkout
    When user enters address details
    And user enters pincode "<pincode>"
    And user is redirected to review page
    And user completes checkout
    Then user should see logout successfully

    Examples: 
      | Email                         | Password  | bookName | pincode |
      | satyamsingh8809793391@gmail.com | satyam@1234 | Selenium |  600042 |

  Scenario Outline: Failed book purchase due to payment error
    Given user is on the login page
    When the user enters email as "<Email>" and password "<Password>" and click login button
    When user search for "<bookName>"
    And user add the first result to cart
    And user view my cart
    And user proceed to checkout
    When user enters address details
    And user enters pincode "<pincode>"
    Then user should see error message on checkout

    Examples: 
      | Email                         | Password  | bookName | pincode | 
      | satyamsingh8809793391@gmail.com | satyam@1234 | Java     |     123 |
@api
Feature: API CRUD testing with JSONPlaceholder using DataTable

  Scenario: CRUD operations with DataTable
    Given I have a base URI of "https://jsonplaceholder.typicode.com"
    When I perform the following operations:
      | Method | Endpoint     | Body                                                                 |
      | GET    | /posts       |                                                                      |
      | POST   | /posts       | {"title":"foo","body":"bar","userId":1}                              |
      | PUT    | /posts/1     | {"id":1,"title":"updated","body":"updated content","userId":1}       |
      | DELETE | /posts/1     |                                                                      |
    Then I should receive the following status codes:
      | Method | StatusCode |
      | GET    | 200        |
      | POST   | 201        |
      | PUT    | 200        |
      | DELETE | 200        |
    And each response time should be less than 3000 milliseconds

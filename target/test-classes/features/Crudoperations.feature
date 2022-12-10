Feature: To perform all CRUD operations

  Background: 
    Given The base URI is "http://localhost:3000"

  Scenario: To Perform the GET Operation on Employe DB
    When I perform the Get Operation
    Then Response code should be 200

  Scenario: To Perform the POST Operation on Employe DB
    When I create new employee with name "Parthi" and salary 10000
    And I perform the post Operation
    Then Response code should be 201

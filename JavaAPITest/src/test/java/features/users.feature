@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Title of your scenario 1
    Given test execution start for the test case id 101
    When the GET http request is sent for the "/users/" api
    Then response status code is 200

    
 Scenario: Title of your scenario 2
    Given test execution start for the test case id 102
    When the GET http request is sent for the "/users/1" api
    Then response status code is 200
    And the response object has valid response
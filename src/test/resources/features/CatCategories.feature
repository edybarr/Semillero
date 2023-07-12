@services
Feature: Make request to a service

  @GetCategories
  Scenario: Make Request to method Get for consult Categories
    Given I make the connection to the api
    When Execute method GET categories with the resource api "categories"
    Then see that the is returned 200


  @GetCategory
  Scenario: Make Request to method Get for consult an Category
    Given I make the connection to the api
    When Execute method GET categories with the resource api "categories"
    Then see that the is returned 200
    And Check if the categories exists successfully

  @GetTwoCategories
  Scenario: Make Request to method Get for consult Categories
    Given I make the connection to the api
    When Execute method GET categories with the resource api "categories?limit=2"
    Then see that the is returned 200
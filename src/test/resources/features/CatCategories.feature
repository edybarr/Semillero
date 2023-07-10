@services
Feature: Make request to a service

  @GetCategories
  Scenario: Make Request to method Get for consult an Categories
    Given I make the connection to the api
    When Execute method GET categories with the resource api "categories"
    Then see that the is returned 200
    And Check if the categories exists successfully
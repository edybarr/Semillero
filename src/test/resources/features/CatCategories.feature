@services
Feature: Make request to a service

  @GetCategories
  Scenario: Consult Categories using the GET Method
    Given I make the connection to the api
    When Execute method GET categories with the resource api "categories"
    Then see that the is returned 200


  @GetCategory
  Scenario: Consult a Category using the GET Method
    Given I make the connection to the api
    When Execute method GET categories with the resource api "categories"
    Then see that the is returned 200
    And Check if the categories exists successfully

  @GetCategorieslimit
  Scenario: Consult Categories using the GET Method with Limit 2
    Given I make the connection to the api
    When Execute method GET categories with the resource api "categories?limit=2"
    Then see that the is returned 200
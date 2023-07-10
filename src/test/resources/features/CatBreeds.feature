@services
Feature: Make request to a service

  @GetBreeds
  Scenario: Make request to method Get for consult the cat breeds
    Given I make the connection to the api
    When Execute the method GET with the resource api "breeds"
    Then see that the is returned 200


  @GetAnBreed
  Scenario: Make Request to method Get for consult an Breed
    Given I make the connection to the api
    When Execute the method GET with the resource api "breed"
    Then see that the is returned 200
    And Check if the breed exists successfully


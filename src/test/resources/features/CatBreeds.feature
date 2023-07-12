@services
Feature: Make request to a service

  @GetBreeds
  Scenario: Requesting Cat Breeds using the GET method
    Given I make the connection to the api
    When Execute the method GET with resource api "breeds"
    Then see that the is returned 200

 @GetAnBreed
Scenario Outline: Requesting a Specific Breed using the GET method
   Given I make the connection to the api
   When I Execute the method GET with the <breed> and the resource api "breed"
   Then see that the is returned 200
   And Check if the breed exists successfully
  Examples:
    |breed        |
    |"toyg"       |
    |"snow"       |
    |"abob"       |
    |"beng"       |

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

  @GetCategories
  Scenario: Make Request to method Get for consult an Categories
    Given I make the connection to the api
    When Execute method GET categories with the resource api "categories"
    Then see that the is returned 200
    And Check if the categories exists successfully

  @GetVotes
  Scenario: Make request to method Get for consult the cat votes
    Given I make the connection to the api
    When Execute the method GET vote with the resource api "votes"
    Then see that the is returned 200

  @GetVote
  Scenario: Make request to method Get vote with voteID for consult the cat votes
    Given I make the connection to the api
    When Execute the method GET vote with a voteID the resource api "votes" and ID "1071900"
    Then see that the is returned 200

  @PostVote
  Scenario: Make request to method POST for create an cat vote
    Given I make the connection to the api
    When Execute the method POST with the resource api "votes"
    Then see that the is returned 201
    And Check if the vote was create successfully

  @DeleteVote
  Scenario: Make request to method DELETE for delete a cat vote
    Given I make the connection to the api
    When Execute the method GET vote with the resource api "votes"
    And see that the is returned 200
    And Save a random vote
    And Execute the method DELETE with the resource api "votes"
    Then Code returned is 200
    And Check if the vote was delete successfully

    #Este Escenario pretende validar el comportamiento al intentar borrar votos que no existen
  @UHPDeleteVote
  Scenario: Make request to method DELETE for try delete a cat vote not exist
    Given I make the connection to the api
    When Execute the method DELETE with the resource api "votes"
    Then Code returned is 404
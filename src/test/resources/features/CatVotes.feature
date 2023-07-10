@services
Feature: Make request to a service

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

  @DeleteCreatedVote
  Scenario: Make a request to the DELETE method to remove a cat that has been created
    Given I make the connection to the api
    When Execute the method POST with the resource api "votes"
    And see that the is returned 201
    And Check if the vote was create successfully
    And Save the vote ID was create successfully
    And Execute the method DELETE with the resource api "votes"
    Then Code returned is 200
    And Check if the vote was delete successfully

  @UHPDeleteVote
  Scenario: Make request to method DELETE for try delete a cat vote not exist
    Given I make the connection to the api
    When Execute the method DELETE with the resource api "votes"
    Then Code returned is 404
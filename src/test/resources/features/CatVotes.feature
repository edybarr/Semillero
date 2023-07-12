@services
Feature: Make request to a service

  @GetVotes
  Scenario: Retrieve Cat Votes using the GET Method
    Given I make the connection to the api
    When Execute the method GET vote with the resource api "votes"
    Then see that the is returned 200

  @GetVote
  Scenario: Retrieve Cat Votes using the GET Method with a specific Vote ID
    Given I make the connection to the api
    When Execute the method GET vote with a voteID the resource api "votes" and ID "1071900"
    Then see that the is returned 200

  @PostVote
  Scenario: Create a Cat Vote using the POST Method
    Given I make the connection to the api
    When Execute the method POST with the resource api "votes"
    Then see that the is returned 201
    And Check if the vote was create successfully

  @DeleteVote
  Scenario: Delete a Cat Vote using the DELETE Method
    Given I make the connection to the api
    When Execute the method GET vote with the resource api "votes"
    And see that the is returned 200
    And Save a random vote
    And Execute the method DELETE with the resource api "votes"
    Then Code returned is 200
    And Check if the vote was delete successfully

  @DeleteCreatedVote
  Scenario: Remove a Created Cat Vote using the DELETE Method
    Given I make the connection to the api
    When Execute the method POST with the resource api "votes"
    And see that the is returned 201
    And Check if the vote was create successfully
    And Save the vote ID was create successfully
    And Execute the method DELETE with the resource api "votes"
    Then Code returned is 200
    And Check if the vote was delete successfully

  @UHPDeleteVote
  Scenario: Attempt to Delete a Non-existent Cat Vote using the DELETE Method
    Given I make the connection to the api
    When Execute the method DELETE with the resource api "votes"
    Then Code returned is 404
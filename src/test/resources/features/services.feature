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
  Then Check if the breed exists successfully

@DeleteBreed
 Scenario: Make request to method DELETE for delete an cat breeds
 Given I make the connection to the api
 When Execute the method DELETE with the resource api "delete"
 Then see that the is returned 200
 Then Check if the breed was delete successfully

 @CreateBreed
  Scenario: Make request to method POST for create an cat breeds
  Given I make the connection to the api
  When Execute the method POST with the resource api "create"
  Then see that the is returned 201
  Then Check if the breed was create successfully
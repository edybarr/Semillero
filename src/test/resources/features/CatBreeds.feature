@services
Feature: Make request to a service

  @GetBreeds
  Scenario: Requerir razas usando el método Get
    Given Que se especifica un entorno de prueba
    When Ejecutar método con el recurso "breeds"
    Then Valida que retorna el código 200

  @GetAnBreed
  Scenario Outline: Requerir una raza específica usando el método
    Given Que se especifica un entorno de prueba
    When Ejecutar el método con la <breed> y el recurso api "breed"
    Then Valida que retorna el código 200
    And Confirmar la raza se obtiene correctamente
    Examples:
      | breed  |
      | "toyg" |
      | "snow" |
      | "abob" |
      | "beng" |

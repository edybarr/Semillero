@services
Feature: Make request to a service

  @GetVotes
  Scenario: Obtener votos a través de la APICat
    Given Que se especifica un entorno de prueba
    When Se ejecuta el método para obtener los votos en la APICAT con el recurso "votes"
    Then Valida que retorna el código 200

  @GetVote
  Scenario: Obtener voto específico a través de la APICat
    Given Que se especifica un entorno de prueba
    When Se ejecuta el método para obtener un voto específico en la APICAT con el recurso "votes" y ID "1071900"
    Then Valida que retorna el código 200

  @PostVote
  Scenario: Crea un voto usando el método
    Given Que se especifica un entorno de prueba
    When Se ejecuta el method para crear un voto con el recurso "votes"
    Then Valida que retorna el código 201
    And Verifica si el voto se creó correctamente

  @DeleteVote
  Scenario: Borrar un voto usando el método
    Given Que se especifica un entorno de prueba
    When Se ejecuta el método para obtener los votos en la APICAT con el recurso "votes"
    And Valida que retorna el código 200
    And Guarda un voto aleatorio
    And Ejecuta el método con el recurso "votes"
    Then Valida que retorna código 200
    And Verifica si el voto fue borrado correctamente

  @DeleteCreatedVote
  Scenario: Eliminar un Voto de Gato Creado utilizando el Método
    Given Que se especifica un entorno de prueba
    When Se ejecuta el method para crear un voto con el recurso "votes"
    And Valida que retorna el código 201
    And Verifica si el voto se creó correctamente
    And Guarda el ID del voto que se creó exitosamente
    And Ejecuta el método con el recurso "votes"
    Then Valida que retorna código 200
    And Verifica si el voto fue borrado correctamente

  @UHPDeleteVote
  Scenario: Intentar Eliminar un Voto Inexistente utilizando el Método
    Given Que se especifica un entorno de prueba
    When Ejecuta el método con el recurso "votes"
    Then Valida que retorna el código 404
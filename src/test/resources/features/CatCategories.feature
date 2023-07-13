@services
Feature: Make request to a service

  @GetCategories
  Scenario: Consultar categorías usando el método
    Given Que se especifica un entorno de prueba
    When Ejecuta el método GET para obtener las categorías con el recurso "categories"
    Then Valida que retorna el código 200


  @GetCategory
  Scenario: Consultar una  Categoría usando el método
    Given Que se especifica un entorno de prueba
    When Ejecuta el método GET para obtener las categorías con el recurso "categories"
    Then Valida que retorna el código 200
    And Verifica la categoría se consultó correctamente

  @GetCategorieslimit
  Scenario: Consultar Categorías usando el método con límite 2
    Given Que se especifica un entorno de prueba
    When Ejecuta el método GET para obtener las categorías con el recurso "categories?limit=2"
    Then Valida que retorna el código 200
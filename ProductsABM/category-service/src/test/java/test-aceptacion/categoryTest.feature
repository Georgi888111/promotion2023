Feature: Category Test

  Scenario: Test GET categories
    Given url is 'localhost:8080/category'
    When method GET
    Then status 200
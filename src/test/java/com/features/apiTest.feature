Feature: Verify API requests

  Background:
    Given User creates the API Endpoint

    @apiTest
  Scenario Outline: : Verify get api with page <page>
    When User send get request for Page "<page>"
    Then User validates if status code is 200
    And User reads the response for get user
    And User validate "<first_name>" for id <10>

    Examples:
      | page | first_name | id |
      | 2    | Byron      | 10 |

      @apiTest
  Scenario Outline: : Verify user adds new entry
    When User send post request for "<name>" and "<job>"
    Then User validates if status code is 201
    And User reads the response for create user
    And User validate if ID is generated
    And User Validate response schema "<schema_file>"

    Examples:
      | name   | job |schema_file|
      | Bryant | BA  |createUserResponseSchema.json|

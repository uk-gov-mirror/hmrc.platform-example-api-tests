Feature: API Examples using Cucumber

  @Example
  Scenario: Request is made to a public service endpoint
    When a request is made to the example public endpoint
    Then it should respond successfully
    And the response body should be "Hello world - public zone"

  @Example
  Scenario: Request is made to a private service endpoint
    When a request is made to the example private endpoint
    Then it should respond successfully
    And the response body should be "Hello world - protected zone"

  @Contract
  Scenario: Contract example testing outbound hods proxy access
    When a request is made to a hods proxy endpoint
    Then it should respond successfully

Feature: Query a postcode and receive a 200 response

  Scenario Outline: Query a postcode and receive a 200 response
    Given the application is running
    When I send a get request to <url>
    Then I get a <returnCode> response

    Examples:
      | url                                | returnCode |
      | api.postcodes.io/postcodes/SW1P4JA | 200        |
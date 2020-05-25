Feature: Example
  A client wants to see an example

  @Disabled
  Scenario Outline: Example with some data
    Given a example with a value of X is <valueX>
    When the user requests <valueY>
    Then the machine should display <valueZ>

    Examples:
      | valueX | valueY   | valueZ |
      | 100    | 20       | 80     |
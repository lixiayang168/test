Feature: key press

Scenario Outline:
    Given navigate to the internet page
    When click the key press link
    And input keys as "<keys>"
    Then show I input the "<keys>"

Examples:
    | keys |
    | SPACE |
    | SHIFT |
    | BACK_SPACE|


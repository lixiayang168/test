Feature: iframe with keyboard operation
Scenario:
    Given navigate to iframe page
    When clear the original context and input new context as "Hello Word!"
    And change the context format
    Then check the context

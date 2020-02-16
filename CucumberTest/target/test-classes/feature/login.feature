Feature: login


Scenario:
    Given navigate to login page
    When I enter username as tomsmith
    And I enter password as SuperSecretPassword!
    Then login should pass

Scenario:
    Given navigate to login page
    When I enter username as 123
    And I enter password as 123
    Then login should fail
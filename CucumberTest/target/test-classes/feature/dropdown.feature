Feature: dropdown with tag

@SmokeTest
Scenario:
    Given open dropdown page
    When select option 1
    Then option 1 is selected


@RegressionTest
Scenario:
    Given open dropdown page
    When select option 2
    Then option 2 is selected
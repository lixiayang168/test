Feature: hovers using Scenario outline

Scenario Outline:
    Given navigate to Hover Page
    When I hover on "<number>" image
    Then show title "<title>"
    Then show link "<link>"

Examples:
    | number | title | link |
    | first | user1 | /users/1 |
    | second | user2 | /users/2 |
    | third | user3 | /users/3 |
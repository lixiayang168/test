Feature: nested frame with data table map

Scenario:
    Given navigate to the nested frame page
    Then check the context on each frame
    | leftframe | middleframe | rightframe | bottomframe |
    |  LEFT     | MIDDLE      | RIGHT      | BOTTOM      |
Feature: Verify Selendroid App

  Background:
    Given User Opens the App

  Scenario: Verify Home screen title.
    Then Verify home screen title.
    And Verify all home screen elements.

  Scenario Outline: User verify chrome screen.
    When User clicks on Chrome button.
    Then Verify text heading.
    And Enter his name "<name>".
    Examples:
      |name|
    |Aman Garg|
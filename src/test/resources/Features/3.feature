Feature: API Test and Comparison

  Scenario: User should be able to go to the staring page and login.

    Given User is at the Home Page
    When User is logging in into the website as a "<user>"
    And User is at the Collections Page
    And Open the Language dependence Window
    And Call API to see the most voted Board game
    Then Compare results with the page

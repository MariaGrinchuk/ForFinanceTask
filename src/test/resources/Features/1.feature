Feature: Base Page

  Scenario Outline: User should be able to go to the staring page and login.

    Given User is at the Home Page
    When User is logging in into the website as a "<user>"
    Then User can see his own profile page

    Examples:
      |  user           |
      |  client         |

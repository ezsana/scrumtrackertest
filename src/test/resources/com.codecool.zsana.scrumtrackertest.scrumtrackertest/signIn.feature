Feature: Sign in

# 1)
  Scenario: Valid sign in

    Given that I've clicked on Sign in button
    When I enter valid username and valid password
    Then I see a welcome message on the screen.

# 2)
  Scenario Outline: Invalid sign in

    Given that I've clicked on Sign in button
    When I enter <username> and / or <password>
    Then pop-up shows invalid login.

    Examples:
      | username | password |
      | valid    | invalid  |
      | invalid  | valid    |
      | blank    | valid    |
      | valid    | blank    |
      | blank    | blank    |
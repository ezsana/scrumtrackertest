Feature: Sign in

# 1)
  Scenario: Valid sign in

    Given that I've clicked on Sign in button
    When I enter valid username and valid password
    Then I see a welcome message on the screen
    And I close SignIn test.

# 2)
  Scenario Outline: Invalid sign in

    Given that I've clicked on Sign in button
    When I enter invalid "<username>", "<password>"
    Then pop-up shows invalid login
    And I close SignIn test.

    Examples:

      | username | password |
      | zsana    | password |
      | username | zsana    |
      | null     | zsana    |
      | zsana    | null     |
      | null     | null     |
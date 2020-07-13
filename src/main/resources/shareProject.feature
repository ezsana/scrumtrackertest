Feature: Share project - on unique projects page

# 1)
  Scenario: Successful inviting participant - valid account name

    Given that I've clicked on the invite participant button
    When I fill in the input and click on the add participant button
    Then the invited participant's name is seen.

# 2)
  Scenario: Unsuccessful inviting participant - invalid account name

    Given that I've clicked on the invite participant button
    When I fill in the input with invalid user name and click on the add participant button
    Then the invitation is not possible.
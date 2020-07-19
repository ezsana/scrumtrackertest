Feature: Share project - on unique projects page

# 1)
  Scenario Outline: Successful inviting participant - valid account name

    Given that I've clicked on the invite participant button
    When I fill in the "<inputfield>" and click on the add participant button
    Then the invited participant's name is seen: "<inputfield>"
    And I close the share project test no 1.

    Examples:

    | inputfield |
    | zsana      |

# 2)
  Scenario Outline: Unsuccessful inviting participant - invalid account name

    Given that I've clicked on the invite participant button
    When I fill in the input with invalid user name: "<invalidName>" and click on the add participant button
    Then the invitation is not possible with the "<invalidName>"
    And I close the test, deleting and creating the project again.

    Examples:

    | invalidName |
    | invalidUser |
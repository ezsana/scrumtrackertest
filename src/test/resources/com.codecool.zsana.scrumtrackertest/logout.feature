Feature: Logout

# 1)
  Scenario: Successful logging out

    Given that I'm logged in for logout test
    When I click on Logout button
    Then a pop-up window shows that logout was successful
    And I close logout test.
Feature: Logout

# 1)
  Scenario: Successful logging out

    Given that I'm logged in
    When I click on Logout button
    Then a pop-up window shows that logout was successful.
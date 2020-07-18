Feature: Homepage

# 1)
  Scenario: All web elements seen on homepage: Homepage / Projects / Logout buttons; welcome message; link to projects

    Given that I'm logged in
    When homepage is loaded
    Then all of the above web elements are seen
Feature: Sign up

# 1)
  Scenario: Valid registration

    Given I've clicked on Sign Up button
    And registration fields can be seen
    When I enter username, password and email and click on Sign up button
    Then pop-up window shows registration success.

# 2)
  Scenario: Invalid registration - all blank fields

    Given I've clicked on Sign Up button
    And registration fields can be seen
    When I leave all fields blank and click on Sign up button
    Then pop-up shows that I need to use at least five characters in all fields.

# 3)
  Scenario: Invalid registration - already existing account

    Given I've clicked on Sign up button
    And registration fields can be seen
    When I fill fields with already existing account data
    Then pop-up shows that the account already exists.

# 4)
  Scenario: Invalid registration - less than 5 characters used in username / password, e-mail valid

    Given I've clicked on Sign up button
    And registration fields can be seen
    When I write less than 5 characters in username / password with valid e-mail
    Then pop-up shows that I need to use at least five characters in all fields.

# 5)
  Scenario: Invalid registration - username / password blank, e-mail valid

    Given I've clicked on Sign up button
    And registration fields can be seen
    When username / password is blank and e-mail is valid
    Then pop-up shows that I need to use at least five characters in all fields.

# 6)
  Scenario: Invalid registration - valid username / password, invalid e-mail

    Given I've clicked on Sign up button
    And registration fields can be seen
    When username / password valid but e-mail is not in "xxxxx@xxxxx.xxx" form
    Then pop-up shows that e-mail is invalid.

# 7)
  Scenario: Invalid registration - valid username / password, blank e-mail

    Given I've clicked on Sign up button
    And registration fields can be seen
    When username / password is valid and e-mail is blank
    Then pop-up shows that all fields are required.
Feature: Sign up

# 1)
  Scenario: Valid registration

    Given I've clicked on Sign Up button
    When I enter username, password and email and click on Sign up button
    Then pop-up window shows registration success.

# 2)
  Scenario Outline: Invalid registration - all blank fields; username / password blank with valid email;
                    less than 5 characters username / password with valid e-mail; all-spaces username with valid
                    password and e-mail

    Given I've clicked on Sign Up button
    When I write "<username>", "<password>", "<email>"
    Then pop-up shows that I need to use at least five characters in all fields.

    Examples:

    | username | password |     email     |
    | null     | null     | null          |
    | null     | password | user@user.com |
    | username | null     | user@user.com |
    | user     | pass     | user@user.com |
    | spaces   | password | user@user.com |

# 3)
  Scenario Outline: Invalid registration - valid username / password, invalid email

    Given I've clicked on Sign Up button
    When "<username>" and "<password>" valid but "<email>" is not in xxxxx@xxxxx.xxx form
    Then pop-up shows that e-mail is invalid.

    Examples:

    | username | password |             email           |
    | username | password | e                           |
    | username | password | emailaddress.com            |
    | username | password | emailaddress@emailaddress   |
    | username | password | emailaddress@emailaddress.  |
    | username | password | @emailaddress.com           |
    | username | password | spaces@spaces.com           |
    | username | password | spaces@spaces.spaces        |


# 4)
  Scenario Outline: Invalid registration - valid <username> / <password>, blank <email>

    Given I've clicked on Sign Up button
    When <username> and <password> is valid and <email> is blank
    Then pop-up shows that all fields are required.

    Examples:
    | username | password | email |
    | username | password | null  |

# 5)
  Scenario: Invalid registration - already existing account

    Given I've clicked on Sign Up button
    When I fill fields with already existing account data
    Then pop-up shows that the account already exists.
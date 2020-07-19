Feature: All projects page

# 1)
  Scenario: all my projects can be seen on page

    Given that I'm logged in for project page test
    When I click on Projects button
    Then I can see all my projects
    And I close the project page test.

# 2)
  Scenario Outline: Unsuccessful creating project with less than three characters

    Given that I'm on the Projects page
    When I fill in the "Create Project" field with less than three character: "<invalidProjectName>"
    Then a pop-up shows that I have to write at least three letters to create a project
    And I close the project page test.

    Examples:

    | invalidProjectName |
    | pr                 |

# 3)
  Scenario Outline: Successful creating project

    Given that I'm on the Projects page
    When I write in the "create new project" field: "<validProjectName>" and click on "create project" button
    Then I can see my new project: "<validProjectName>"
    And I close the project page test.

    Examples:

    |    validProjectName     |
    | AddAndDeleteThisProject |

# 4)
  Scenario Outline: Successful deleting project

    Given that I'm on the Projects page
    When I click on the "<projectName>" delete project button
    Then the project is deleted
    And I close the project page test.

    Examples:

    |      projectName        |
    | AddAndDeleteThisProject |

# 5)
  Scenario: Successful archiving project

    Given that I'm on the Projects page
    When I click on the archive project button
    Then the archived project is replaced to the archived projects' container
    And I close the project page test.

# 6)
  Scenario: Successful unarchive project

    Given that I'm on the Projects page
    When I click on the show archive projects button and click on archive project button
    Then the archived project is replaced to the original container
    And I close the project page test.

# 7)
  Scenario Outline: Shared projects can be seen on page

    Given that I'm on the Projects page
    When I scroll down to "Projects I participated in"
    Then I can see projects which are shared with me: "<sharedProject>"
    And I close the project page test.

    Examples:

    |   sharedProject   |
    | zsanaProjectShare |

# 8)
  Scenario: To delete shared project is not possible if I'm not the owner of the project

    Given that I'm on the Projects page
    When I click on delete button in shared project
    Then I'm not able to delete it
    And I close the project page test.
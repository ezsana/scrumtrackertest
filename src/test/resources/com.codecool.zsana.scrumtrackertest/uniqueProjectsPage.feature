Feature: Unique projects page

# 1)
  Scenario Outline: Three built-in statuses can be seen on page

    Given that I've just created a new project: "<project>"
    When I click on the newly created project
    Then the page of this project shows up with three statuses: To Do; In Progress; Done
    Then I delete the project created for the test: "<project>"
    And close unique project test.

    Examples:

    |          project           |
    | CheckStatusesOfThisProject |

# 2)
  Scenario Outline: Successful adding new status

    Given that I'm on my unique project page
    When I fill in the "Add new status" field: "<newStatus>" and click Save button
    Then I can see the new status: "<newStatus>" on the page
    And close unique project test.

    Examples:

    | newStatus |
    | On Hold   |
    | new       |

# 3)
  Scenario Outline: Successful deleting status

    Given that I'm on my unique project page
    When I click on the status: "<status>" delete button
    Then status is deleted
    And close unique project test.

    Examples:

    | status  |
    | On Hold |
    | new     |

# 4)
  Scenario Outline: Unsuccessful adding new status with less than three character

    Given that I'm on my unique project page
    When I fill in the "Add new status" field with less than three character: "<invalidStatus>"
    Then a pop-up shows that I have to write more the three letters to create a new status
    And close unique project test.

    Examples:

    | invalidStatus |
    | ne            |
    | n             |
    | null          |

# 5)
  Scenario Outline: Successful adding new task

    Given that I'm on my unique project page
    When I fill in the "Add new task" field: "<newTaskName>" and click on Save button
    Then I can see the new task: "<newTaskName>" in the To Do container on the page
    And close unique project test.

    Examples:

    |     newTaskName      |
    | AddAndDeleteThisTask |
    | tsk                  |

# 6)
  Scenario Outline: Successful deleting task

    Given that I'm on my unique project page
    And that I have a task: "<taskName>"
    When I click on the task delete button
    Then the task is deleted
    And close unique project test.

    Examples:

    |       taskName       |
    | AddAndDeleteThisTask |
    | tsk                  |

# 7)
  Scenario Outline: Unsuccessful adding new task with less than three characters

    Given that I'm on my unique project page
    When I fill in the "Add new task" field with less than three character: "<invalidTaskName>"
    Then a pop-up shows that I have to write more the three letters to create a new task
    And close unique project test.

    Examples:

    | invalidTaskName |
    | ts              |
    | t               |
    | null            |

# 8)
  Scenario Outline: successful sending project details via e-mail - valid e-mail address

    Given that I'm on my unique project page
    When I click on send e-mail button and write "<validEmail>" into the input field
    Then I get a message that the e-mail is sent
    And close unique project test.

    Examples:

    |   validEmail    |
    | zsana6@zsana6.com |

# 9)
  Scenario Outline: unsuccessful sending project details via e-mail - invalid e-mail address

    Given that I'm on my unique project page
    When I click on send email button and write "<invalidEmail>" into the input field
    Then I get a message that the address is invalid
    And close unique project test.

    Examples:

    | invalidEmail |
    | invalidEmail |

# 10)
  Scenario Outline: Successful setting limit in the "In Progress" status

    Given that I'm on my unique project page
    When I click on Limit In Progress status button and I write the limit: "<limit>"
    Then message shows that the change was successful
    And close unique project test.

    Examples:

    | limit |
    | 2     |

# 11)
  Scenario Outline: Successful dragging a task from status to status

    Given that I'm on my unique project page
    When I drag the task "TransferThisTask" from one status to an other
    Then the aforementioned task would be in the new container: "<status>"
    And close unique project test.

    Examples:

    |    status   |
    | In Progress |

# 12)
  Scenario: Successful editing a task

    Given that I'm on my unique project page
    When I click on the Edit task button and make changes to the task: "EditThisTask" and click on Save button
    Then those changes are saved
    And close unique project test.

# 13)
  Scenario Outline: Unsuccessful to edit task task with less than three character

    Given that I'm on my unique project page
    When I click on the edit button and edit the title of task: "EditThisTask" using less than three character: "<wrongTitle>"
    Then I get a message to write more the three character for the title "<wrongTitle>"
    And close unique project test.

    Examples:

    | wrongTitle |
    | uu         |

# 14)
  Scenario: Without clicking on the save button the changed are not saved

    Given that I'm on my unique project page
    And that I clicked on the edit task button of "EditThisTask"
    When I fill the inputs but don't click on Save button and close the edit window
    Then the changes are not saved
    And close unique project test.

# 15)
  Scenario: Sprint progress by user story can be seen on page

    Given that I'm on my unique project page
    When I have tasks in statuses
    Then I can see the sprint progress by user story circle showing the progress state
    And close unique project test.

# 16)
  Scenario: Sprint progress by value can be seen on page

    Given that I'm on my unique project page
    When I have tasks in statuses
    Then I can see the sprint progress by value circle showing the progress state
    And close unique project test.
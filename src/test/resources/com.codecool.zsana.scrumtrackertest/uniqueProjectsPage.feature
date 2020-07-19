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
  Scenario: Successful adding new status

    Given that I'm on my unique project page
    When I fill in the "Add new status" field and click Save button
    Then I can see the new status on the page.

# 3)
  Scenario: Successful deleting status

    Given that I'm on my unique project page
    When I click on the status delete button
    Then status is deleted.

# 4)
  Scenario: Unsuccessful adding new status with less than three character

    Given that I'm on my unique project page
    When I fill in the "Add new status" field with less than three character
    Then a pop-up shows that I have to write more the three letters to create a new status.

# 5)
  Scenario: Successful adding new task

    Given that I'm on my unique project page
    When I fill in the "Add new task" field and click on Save button
    Then I can see the new task in the To Do container on the page.

# 6)
  Scenario: Successful deleting task

    Given that I have a task
    When I click on the task delete button
    Then the task is deleted.

# 7)
  Scenario: Unsuccessful adding new task with less than three characters

    Given that I'm on my unique project page
    When I fill in the "Add new task" field with less than three character
    Then a pop-up shows that I have to write more the three letters to create a new task.

# 8)
  Scenario: successful sending project details via e-mail - valid e-mail address

    Given that I'm on my unique project page
    When I click on send e-mail button and write valid e-mail address into the input field
    Then I get a message that the e-mail is sent.

# 9)
  Scenario: unsuccessful sending project details via e-mail - invalid e-mail address

    Given that I'm on my unique project page
    When I click on send email button and write invalid email address into the input field
    Then I get a message that the address is invalid.

# 10)
  Scenario: Successful setting limit in the "In Progress" status

    Given that I'm on my unique project page
    When I click on Limit In Progress status button and I write the limit
    Then message shows that the change was successful.

# 11)
  Scenario: Successful dragging a task from status to status

    Given that I have a task
    When I drag the task from one status to an other
    Then the aforementioned task would be in the new container.

# 12)
  Scenario: Successful editing a task

    Given that I have a task
    When I click on the Edit task button and make changes to the task and click on Save button
    Then those changes are saved.

# 13)
  Scenario: Unsuccessful to edit task task with less than three character

    Given that I have a task
    When I click on the edit button and edit the title using less than three character
    Then I get a message to write more the three character for the title.

# 14)
  Scenario: Without clicking on the save button the changed are not saved

    Given that I clicked on the edit task button
    When I fill the inputs but don't click on Save button and close the edit window
    Then the changes are not saved.

# 15)
  Scenario: Sprint progress by user story can be seen on page

    Given that I'm on my unique project page
    When I have tasks in statuses
    Then I can see the sprint progress by user story circle showing the progress state.

# 16)
  Scenario: Sprint progress by value can be seen on page

    Given that I'm on my unique project page
    When I have tasks in statuses
    Then I can see the sprint progress by value circle showing the progress state.
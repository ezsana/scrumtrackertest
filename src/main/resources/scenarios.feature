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


Feature: Sign in

# 8)
Scenario: Valid sign in

  Given that I've clicked on Sign in button
  When I enter valid username and valid password
  Then I see a welcome message on the screen.

# 9)
Scenario Outline: Invalid sign in

  Given that I've clicked on Sign in button
  When I enter <username> and / or <password>
  Then pop-up shows invalid login.

  Examples:
  | username | password |
  | valid    | invalid  |
  | invalid  | valid    |
  | blank    | valid    |
  | valid    | blank    |
  | blank    | blank    |


Feature: Homepage

# 10)
Scenario: All web elements seen on homepage: Homepage / Projects / Logout buttons; welcome message; link to projects

  Given that I'm logged in
  And after homepage is loaded
  Then all of the above web elements are seen


Feature: All projects page

# 11)
Scenario: all my projects can be seen on page

  Given that I'm logged in
  When I click on Projects button
  Then I can see all my projects.

# 12)
Scenario: Unsuccessful creating project with less than three characters

  Given that I'm on the Projects page
  When I fill in the "Create Project" field with less than three character
  Then a pop-up shows that I have to write at least three letters to create a project.

# 13)
Scenario: Successful creating project

  Given that I'm on the Projects page
  And I write in the "create new project" field and click on "create project" button
  Then I can see my new project

# 14)
Scenario: Successful deleting project

  Given that I'm on the Projects page
  When I click on the delete project button
  Then the project is deleted.

# 15)
Scenario: Successful archiving project

  Given that I'm on the Projects page
  When I click on the archive project button
  Then the archived project is replaced to the archived projects' container.

# 16)
Scenario: Successful unarchive project

  Given that I'm on the Projects page
  When I click on the show archive projects button and click on archive project button
  Then the archived project is replaced to the original container.

# 17)
Scenario: Shared projects can be seen on page

  Given that I'm on the Projects page
  When I scroll down to "Projects I participated in"
  Then I can see projects which are shared with me.

# 18)
Scenario: To delete shared project is not possible if I'm not the owner of the project

  Given that I'm on the Projects page
  When I click on delete button in shared project
  Then I'm not able to delete it.


Feature: Unique projects page

# 19)
Scenario: Three built-in statuses can be seen on page

  Given that I've just created a new project
  When I click on the newly created project
  Then the page of this project shows up
  And I can see three statuses: To Do; In Progress; Done

# 20)
Scenario: Successful adding new status

  Given that I'm on my unique project page
  When I fill in the "Add new status" field and click Save button
  Then I can see the new status on the page.

# 21)
Scenario: Successful deleting status

  Given that I'm on my unique project page
  When I click on the status delete button
  Then status is deleted.

# 22)
Scenario: Unsuccessful adding new status with less than three character

  Given that I'm on my unique project page
  When I fill in the "Add new status" field with less than three character
  Then a pop-up shows that I have to write more the three letters to create a new status.

# 23)
Scenario: Successful adding new task

  Given that I'm on my unique project page
  When I fill in the "Add new task" field and click on Save button
  Then I can see the new task in the To Do container on the page.

# 24)
Scenario: Successful deleting task

  Given that I have a task
  When I click on the task delete button
  Then the task is deleted.

# 25)
Scenario: Unsuccessful adding new task with less than three characters

  Given that I'm on my unique project page
  When I fill in the "Add new task" field with less than three character
  Then a pop-up shows that I have to write more the three letters to create a new task.

# 26)
Scenario: successful sending project details via e-mail - valid e-mail address

  Given that I'm on my unique project page
  When I click on send e-mail button and write valid e-mail address into the input field
  Then I get a message that the e-mail is sent.

# 27)
Scenario: unsuccessful sending project details via e-mail - invalid e-mail address

  Given that I'm on my unique project page
  When I click on send email button and write invalid email address into the input field
  Then I get a message that the address is invalid.

# 28)
Scenario: Successful setting limit in the "In Progress" status

  Given that I'm on my unique project page
  When I click on Limit In Progress status button and I write the limit
  Then message shows that the change was successful.

# 29)
Scenario: Successful dragging a task from status to status

  Given that I have a task
  When I drag the task from one status to an other
  Then the aforementioned task would be in the new container.

# 30)
Scenario: Successful editing a task

  Given that I have a task
  When I click on the Edit task button and make changes to the task and click on Save button
  Then those changes are saved.

# 31)
Scenario: Unsuccessful to edit task task with less than three character

  Given that I have a task
  When I click on the edit button and edit the title using less than three character
  Then I get a message to write more the three character for the title.

# 32)
Scenario: Without clicking on the save button the changed are not saved

  Given that I clicked on the edit task button
  When I fill the inputs but don't click on Save button and close the edit window
  Then the changes are not saved.

# 33)
Scenario: Sprint progress by user story can be seen on page

  Given that I'm on my unique project page
  When I have tasks in statuses
  Then I can see the sprint progress by user story circle showing the progress state.

# 34)
Scenario: Sprint progress by value can be seen on page

  Given that I'm on my unique project page
  When I have tasks in statuses
  Then I can see the sprint progress by value circle showing the progress state.


Feature: Share project tests - unique projects page

# 35)
Scenario: Successful inviting participant - valid account name

  Given that I've clicked on the invite participant button
  When I fill in the input and click on the add participant button
  Then the invited participant's name is seen.

# 36)
Scenario: Unsuccessful inviting participant - invalid account name

  Given that I've clicked on the invite participant button
  When I fill in the input with invalid user name and click on the add participant button
  Then the invitation is not possible.


Feature: Logout

# 37)
Scenario: Successful logging out

  Given that I'm logged in
  When I click on Logout button
  Then a pop-up window shows that logout was successful.










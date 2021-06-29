Feature: open e-mail page

  Scenario:
    Given user navigates to the mail page
    When page opens enters username
    And presses enter button
    And when the password form appears enters password
    Then presses login button to enter mail's main page
    Then close the browser window and kill the processes
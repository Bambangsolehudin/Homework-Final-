Feature: Login functionality

  Scenario Outline: Success Login (Positive)
    Given user is on saucedemo login page
    When  user input <username> as username
    When user input <password> as password
    And user click submit
    Then user verify <status> login result
    Examples:
      | username      | password     | status  |
      | standard_user | secret_sauce | success |

  Scenario Outline: Failed Login (negative)
    Given user is on saucedemo login page
    When  user input <username> as username
    When user input <password> as password
    And user click submit
    Then user verify <status> login result
    Examples:
     | username               | password     | status |
     | failed-login@gmail.com | failed-login | failed |
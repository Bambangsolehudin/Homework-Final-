Feature: Logout functionality

  Scenario Outline: Logout Menu
    Given user is on saucedemo login page
    When  user input <username> as username
    When user input <password> as password
    And user click submit
    And user click humberger menu
    And user click logout menu
    Then user success logout
    Examples:
      | username      | password     |  |
      | standard_user | secret_sauce |  |




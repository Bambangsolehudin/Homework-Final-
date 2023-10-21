Feature: Cart

  Scenario Outline: Add to Cart Product
    Given user is on saucedemo login page
    When  user input <username> as username
    When user input <password> as password
    And user click submit
    And user click button add to cart
    Then user showing button with text remove
    Examples:
      | username      | password     |  |
      | standard_user | secret_sauce |  |




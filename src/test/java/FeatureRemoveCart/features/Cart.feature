Feature: Cart

  Scenario Outline: Remove to Cart Product
    Given user is on saucedemo login page
    When  user input <username> as username
    When user input <password> as password
    And user click submit
    And user click button add to cart
    And user click button Remove
    Then user showing button with text Add cart again
    Examples:
      | username      | password     |  |
      | standard_user | secret_sauce |  |




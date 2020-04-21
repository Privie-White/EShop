Feature: E-shop features
  As a User I want to
  Add a random dress to cart
  Checkout
  Check previous orders

  Scenario:
    Given Login to the shop with credentials
    When User clicks women
    And User adds it to cart
    And User proceeds to checkout
    And User hits checkout again
    And Delivery addresses are checked to match
    And User proceeds to checkout again
    And user agrees to terms and services
    And User proceeds to checkout a third time
    And user clicks pay by check
    And user confirms order
    And Verify order is submitted
    And user goes back to order
    And number of orders is printed
    And Verify price of last order matches last order made
    Then Logout
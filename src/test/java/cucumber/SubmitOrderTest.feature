
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

  Background: 
  Given i have landed on ecommerce page
  @tag2
  Scenario Outline: Positive testing of submitting order 
    Given Logged in with username <username> and password <pass>
    When I add product <productname> to cart
    And checkout <productname> and submit the order 
    Then "THANKYOU FOR THE ORDER." message is displayed on the confirmation page.

    Examples: 
      | username                   | pass          | productname |
      | leotanya.kishore@gmail.com | Hello@123     | ZARA COAT 3 |
    
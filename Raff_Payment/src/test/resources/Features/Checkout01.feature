Feature: After logging in, adding and purchasing tickets using cash, and validating the points earned from the purchase

Scenario: Purchasing a ticket using a card
  Given the browser is launched and the user is logged in to the application
  And the home page should be displayed after login
  Then validate the title, price, and total cost for the purchase on the raffle page
  Then add the tickets to the cart
  And the cart page should be displayed
  Then validate that the points displayed for the purchase are correct
  When the checkout button is clicked
  Then the DNA payment popup should be displayed 
  And valid card details should be entered
  Then the user should be able to see the purchased tickets
  And the user should receive the correct points for the purchase
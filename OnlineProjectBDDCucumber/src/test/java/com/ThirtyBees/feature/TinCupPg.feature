Feature: Thirty Bees Application Tin Cup Page

@run
Scenario: Verify black colour selection option

Given user should be on Tin Cup Page
When user selects black colour
And go to add to cart page
Then user should able to see the black colour tin cup in cart

@run
Scenario: Verify selecting Quantity By Inserting Value

Given user should be on Tin Cup Page
When user enters particular quantity in quantity box
And clicks on 'add to cart' button
Then user should able to see the particular quantity in cart

@run
Scenario: Verify selecting Quantity By Increase Decrease button

Given user should be on Tin Cup Page
When user selects particular quantity by using Increase Decrease button
And clicks on 'add to cart' button
Then user should able to see that particular quantity in cart

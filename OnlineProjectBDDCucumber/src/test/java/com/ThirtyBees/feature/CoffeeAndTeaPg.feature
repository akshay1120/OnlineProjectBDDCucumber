Feature: Thirty Bees Application Coffee And Tea Page


Scenario: Verify sort Product By Price Lowest First

Given user should be on "Coffee And Tea" Page
When user select the option "Price : Lowest First"
Then actual and expected sequence products should be same


Scenario: Verify filter of 'Mean Bean Flavor'

Given user should be on "Coffee And Tea" Page
When user select the option 'Mean Bean Flavor'
Then actual and expected list products having 'Mean Bean Flavor' should be same


Scenario: Verify invalid product search

Given user should be on "Coffee And Tea" Page
When user enters '@#$' in search box
Then alert message with text 'No results were found for your search "@#$"' should appear


Scenario: Verify valid product search

Given user should be on "Coffee And Tea" Page
When user enters 'MUG' in search box
Then actual and expected list products with name 'MUG' should be same


Scenario: Verify 'Viewed products option'

Given user should be on "Coffee And Tea" Page
When user clicks on product 'Honey'
And navigate back to "Coffee And Tea" Page
Then user should be able to see product 'Honey' in viewed products


Scenario: Verify price range filter

Given user should be on "Coffee And Tea" Page
When user selects the price range
Then actual and expected list products belonging to that particular price range should be same
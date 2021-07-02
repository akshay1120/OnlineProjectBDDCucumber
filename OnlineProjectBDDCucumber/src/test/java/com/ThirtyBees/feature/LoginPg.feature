Feature: Thirty Bees Application Login Page


Scenario: Verify valid Login

Given user should be on Login Page
When user enters valid data 
Then user should land on 'My Account' page



Scenario Outline: Verify invalid Login

Given user should be on Login Page
When user enters "<email>" and "<password>" 
Then user should land on Login Page

Examples:
|email                |password       |
|neelam@gmail.com     |123456         |
|mangesh@gmail.com    |qwerty         |
|akshay@gmail.com     |asdfgh         |
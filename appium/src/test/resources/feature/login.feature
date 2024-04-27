Feature: logging in MCI

Scenario: login and otp
Given I start the app
When I skip the intro
And I enter my number and click on step code
And I enter the vertification code
And I skip biometric and tutorial
Then I should be in main app page   
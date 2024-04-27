Feature: Checking toolbar

Scenario: Checking packages
Given I open the app
When I click on packages on toolbar
And I click on buy new package
And I click on internet
And I click on conversation
And I click on mci
And I click on hybrid
And I click on sms
And I click on international
And I click on roming
Then everything should work correctly

Scenario:Checking charge
Given I open the app
When I click on charge on toolbar
And I click on extraordinary details 
And I click on loyality details
And I click on ladyes details
And I click on buy new charge
And I click on extraordinary
And I click on ladyes
And I click on teens
And I click on loyality
And I click on buy 
And I click on parachute
Then everything should work correctly

@A
Scenario:Checking wallet
Given I open the app
When I click on wallet on toolbar
And I click on increase balance
And I click on cash out
And I click on all transactions
Then everything should work correctly
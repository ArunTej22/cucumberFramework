Feature: Login functionality feature
Scenario: Login function
Given User launch orangehrm url
When User enter username And User enter password
When user clicks login button
Then user validate url
Then  user close browser
@Multipledata
Scenario Outline: login functionality with multiple data
Given user launch orangehrm url in "<Browser>"
When user enter "<Username>" in username
When user enter "<Password>" in password
When user click login
Then user validate login url
Then user close browser
Examples:
|Browser|Username|Password|
|chrome|Admin|Qedge123!@#|
|firefox|Admin|Qedge123|
|chrome|Admin|Qedge123|
|firefox|Admin|Qedge123!@#|
|chrome|Admin|Qedge123!@|
|firefox|Admin|Qedge123!|





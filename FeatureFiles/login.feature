Feature: Adactin page login verification with and without examples

#Scenario: login without examples
#Given user launches adactin page
#When user enters credentials
#Then user clicks login button
@test
Scenario Outline: login with examples
Given user launches adactin page
When user enters "<username>" and "<password>"
Then user clicks login button
Examples:
|username|password|
|AnithaTest|8Q1P97|
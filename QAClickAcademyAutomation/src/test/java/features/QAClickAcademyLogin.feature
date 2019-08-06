Feature: Login Feature 
Scenario: Test the Login with valid email and password 
	Given Navigate to the Login Page
	When Enter Email and Password from the Database
	Then Enter Login
	And Navigate to the successful page
	And close the Browser




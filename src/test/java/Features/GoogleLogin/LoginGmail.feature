Feature: Google Search validation
	
Scenario: Google Search validation
		  Given user launches the application "Google"
		  Then user waits for page to load
		  When user is on page "GooglePage"
		  When user clicks the button "gmailLink"
		  Then user waits for page to load
		  When user is on page "GmailPage"
		  Then user waits for page to load
		  Then user clicks the button "signIn"
		  When user enters data in the textbox "email" as "leelacham009@gmail.com"
		  Then user clicks the button "next"
		  When user enters data in the textbox "password" as "sample"
		  Then user closes the browser



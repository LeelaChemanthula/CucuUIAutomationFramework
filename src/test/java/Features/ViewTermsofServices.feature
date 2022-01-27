Feature: EyeLove home page View terms of Service link check

Scenario: Verify the view terms of service link

		  Given user launches the application "EyeLove"
		  Then user waits for page to load
		  When user is on page "EyeLovePage"
		  Then user clicks the web element "ViewTermsOfServiceLink"
		  Then user moves to new tab "Eyelove Canada"
		  Then user is on page "TermsOfServicePage"
		  Then user validates element "TermsOfServicePageHeader" is displayed as "LEGAL NOTICE"
		  Then user closes the current tab "Eyelove Canada"
		  Then user closes the browser




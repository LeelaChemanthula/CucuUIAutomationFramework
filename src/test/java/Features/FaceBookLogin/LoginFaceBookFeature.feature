Feature: FaceBook user login validation

@smoke
Scenario: FaceBook user login validation
		Given user launches the application "FaceBook"
		Then user waits for page to load
		When user is on page "FaceBookPage"
		Then user validates FaceBook Page title
		Then user validates FB Create account message
		When user enters data in the textbox "emailOrPhone1" as "sample@gmail.com"
		When user enters data in the textbox "password1" as "sample"
		Then user waits for page to load
		Then user waits for page to load
		Then Step2 class test statement
		Then user closes the browser


#@regression
Scenario: FaceBook user login validation Failure
		Given user launches the application "FaceBook"
		Then user waits for page to load
		When user is on page "FaceBookPage"
		Then user validates FaceBook Page title
		Then user validates FB Create account message
		When user enters data in the textbox "emailOrPhone" as "leelachams@gmail.com"
		When user enters data in the textbox "password" as "sample"
		When user enters my data
			| xpath		|data|
			| password  | 100|
		Then user waits for page to load
		Then user waits for page to load
		Then Step2 class test statement
		Then user closes the browser



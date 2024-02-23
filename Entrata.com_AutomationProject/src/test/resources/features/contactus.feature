Feature: ContactUs For Quetions or Feedback
  
	@Scenario1
	Scenario: Validate Resident Portal
	Given user open the browser and navigate on home page
	And click on sign in button
	When resident login link display then click on link
	And navigate on resident portal screen and click on website view
	Then verify resident portal screen successfully displayed
	
	@Scenario2
	Scenario Outline: Validate the Watch Demo Registration Form
	Given user open the browser and navigate on home page
	When click on watch demo button
	And enter details in text fileds
	|firstName|lastName|email|companyName|phoneNumber|jobTitle|
	|dnyaneshwar|hiwale|dnyaneshwarhiwale224@gmail.com|TCS|9766403282|QA Analyst|
	And click on watch demp button
	Then verify all details fill successfully
	
	@Scenario3
	Scenario Outline: Validate the Watch Demo Registration Form
	Given user open the browser and navigate on home page
	When click on base camp link
	And click on register Now button
	And enter personal details in register form
	|firstName|LastName|emailAddress|companyName|mobileNumber|title|
	|dnyaneshwar|hiwale|dnyaneshwarhiwale224@gmail.com|TCS|+91 9766403282|QA Analyst|
	And click on next button
	Then verify registration successfully done
	
	@Scenario4
	Scenario: Validate Broken links present on webPage
	Given user open the browser and navigate on home page
	Then access all the links present on webpage
	
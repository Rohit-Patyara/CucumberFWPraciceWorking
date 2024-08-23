@tag
Feature: 
As an admin user validate customer module
@supplier
Scenario Outline:
Validate supplier module with multiple sets of data
Given user launches browser
When user enter url as "http://webapp.qedgetech.com/" in a browser
When user waits for username with locator "xpath" and its value "//input[@id='username']"
When user enters username as "admin" with locator "xpath" and its value "//input[@id='username']" 
When user enters password as "master" with locator "name" and its value "password" 
When user click login button with locator "id" and its value "btnsubmit"
When user waits for customer link with locator "xpath" and its value "(//a[text()='Customers'])[2]"
When user click customer link with locator "xpath" and its value "(//a[text()='Customers'])[2]"
When user waits for Add icon with locator "xpath" and its value "(//span[@data-caption='Add'])[1]"
When user clicks Add icon button with locator "xpath" and its value "(//span[@data-caption='Add'])[1]"
When user waits for Customer Number with locator "name" and its value "x_Customer_Number"
When user captures Customer Number with locator "name" and its value "x_Customer_Number"
When user enters Customer Name as "<CustomerName>" with locator "xpath" and its value "//input[@id='x_Customer_Name']"
When user enters Address as "<Address>" with locator "xpath" and its value "//textarea[@id='x_Address']"
When user enters City as "<City>" with locator "xpath" and its value "//input[@id='x_City']"
When user enters Country as "<Country>" with locator "xpath" and its value "//input[@id='x_Country']"
When user enters Contact Person as "<ContactPerson>" with locator "xpath" and its value "//input[@id='x_Contact_Person']"
When user enters Phone Number as "<PhoneNumber>" with locator "xpath" and its value "//input[@id='x_Phone_Number']"
When user enters Email as "<Email>" with locator "xpath" and its value "//input[@id='x__Email']"
When user enters Mobile Number as "<MobileNumber>" with locator "xpath" and its value "//input[@id='x_Mobile_Number']"
When user enters Notes as "<Notes>" with locator "xpath" and its value "//input[@id='x_Notes']"
When user clicks Add button with locator "id" and its value "btnAction"
When user waits for Confirm Ok button with locator "xpath" and its value "//button[text()='OK!']"
When user clicks Confirm Ok button with locator "xpath" and its value "//button[text()='OK!']"
When user waits for Alert Ok button with locator "xpath" and its value "(//button[text()='OK'])[6]"
When user clicks Alert Ok button with locator "xpath" and its value "(//button[text()='OK'])[6]"
When user validates Customer Table
When user clicks Logout Link with locator "xpath" and its value "(//a[contains(text(),'Logout')])[1]"
When user close browser
Examples:
|CustomerName|Address|City|Country|ContactPerson|PhoneNumber|Email|MobileNumber|Notes|
|Tony Stark|1-85/B2|Newyork|USA|Dr Strange|1234567890|tonystark@gmail.com|987654321|Arc Reactor Owner|
|CaptainAmerica|1-85/B3|New Jersey|USA|Steve Rodgers|5647931520|cAmerica@gmail.com|647951250|Shield Owner|
|Spiderman|1-85/B4|Cairo|Egypt|Peter|5647931524|spiderman@gmail.com|975951250|Geek|
|BlackPanther|1-85/B5|London|Europe|King|5647941520|bPanther@gmail.com|685287452|Wakanda King|
|Thanos|1-85/B6|Hyderabad|India|Destructor|5678451520|thanos@gmail.com|657951250|Ruler|



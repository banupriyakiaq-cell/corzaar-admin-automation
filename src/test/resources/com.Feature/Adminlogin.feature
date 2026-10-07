Feature:corzaar application
Scenario Outline:Admin invalid 
Given user lanuch the application
When user click the admin button
When user enter the "<Email id>"
And user enter the password "<Password>"
And click the aunthendicate button
And user verify the "<status>" and "<Message>"
Examples:
|Email id|Password|status|Message| 
|admin@corzaar.com|Admin@1234| failed|Invalid admin credentials|   
|admin@2corzaar.com|Admin@123| failed|Invalid admin credentials|  
Scenario Outline:Admin valid
Given user lanuch the application
When user click the admin button
When user enter the "<Email id>"
And user enter the password "<Password>"
And click the aunthendicate button
And Admin is on the 2FA verification page 
And admin enters valid "<otp>"
And admin click the verify button 
And admin verify the "<valid>" and "<Message>"
Then admin should be logged in successfully
Examples:
|Email id|Password|otp|valid|Message|
|admin@corzaar.com|Admin@123|123467|invalid|Invalid admin OTP|
|admin@corzaar.com|Admin@123|123456|valid|    |


 
 
 

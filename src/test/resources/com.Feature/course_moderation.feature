Feature:corzaar application
Scenario Outline:course moderation module verify invalid course search
Given user is on tha dashboard page
When admin click the  course moderation module
And admin search the topic in search field "javafullstack"
And admin verify the course "javafullstack" as "Invalid" with "No courses found in this category."
Scenario Outline:verify course moderation status
Given user is on tha dashboard page
When admin click the  course moderation module
And admin search the course topic in search field "<course>"
And admin verify the "<course>" as "<Status>"  as "message"
And admin clear the search field in coursemoderation module
And admin using the filter option
And admin select the published option
And the option filter the details and should be displayed correctly
And admin select the reject button in displayed details  
And admin select the  underreview option
And admin select underreview option filter the details and should be displayed correctly
And admin select the reject button 	
And admin select the publish option 
 
And admin select the rejected option
Then admin select  rejected option filter the details and should be displayed correctly	
 	
Examples:
|course|Status| message|
|Selenium Automation Testing|valid|     |
|java selenium |valid|	|
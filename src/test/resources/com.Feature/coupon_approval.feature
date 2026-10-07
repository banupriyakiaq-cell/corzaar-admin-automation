Feature:Corzzar application
Scenario Outline:verify coupon approval module
Given  admin is on the dashboard page
When admin click the coupon approval module
And admin search the coupon code in search field "<Couponcode>"
And the displayed message depends on search code
And admin verify the details "<Status>" and "<Displayedmessage>"
And admin clear the couponapproval search field in  
And admin using the filter option in search the details
And admin select the pending option 
And it should be displayed correct details
And admin click the approve button the coupon approved for admin side
And admin reject the coupon
And  admin select the approved button
And the approved button displayed correct details 
And admin reject the discound details
And admin select the  rejected button
And the reject button should be displayed correct details
Then admin click the apporve button

Examples:
|Couponcode|Status|Displayedmessage|
|welcomeindia|invalid|No coupons found.|
|WELCOME25|VALID|   |
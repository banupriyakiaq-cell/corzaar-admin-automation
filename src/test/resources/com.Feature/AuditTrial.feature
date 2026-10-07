Feature:corzaar application
Scenario Outline:audit trail module verification

Given user is on the dashboard page againa
When admin select the audit trail module
And admin use searchfield and find the details "<SecurityAction>"
And verify the result "<Status>" with message "<expectedmessage>"
And admin clear the search field
And admin use the filter option
And admin select the course option
And verify the displayed result detils	
And admin select the  payouts option
And verify  payout details displayed correctly   	
   	
And admin select the  batches option
And verify  batches details displayed correctly   	
And admin select the  institute option
And verify  institute details displayed correctly   	
And admin select the coupons option
And verify  coupons details displayed correctly   	
And admin select the Certificates option
Then  verify  Certificates details displayed correctly   

Examples:
|SecurityAction|Status|	expectedmessage|
|selenium		|invalid|No audit logs recorded yet.|
|Course submitted|valid||





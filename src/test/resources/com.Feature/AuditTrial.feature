Feature: corzaar application

  Scenario Outline: audit trail module verification
    Given user is on the dashboard page again in
    When admin select the audit trail module
    And admin use searchfield and find the details "<SecurityAction>"
    And verify the result "<Status>" with message "<expectedmessage>"
    And admin verify the search field data details "<SecurityAction>"
    And admin clear the search field
    And admin use the filter option
    And admin select the course option
    And verify the displayed result detils "course"
    And admin select the  payouts option
    And verify  payout details displayed correctly "payouts"
    And admin select the  batches option
    And verify  batches details displayed correctly "batches"
   # And admin select the  institute option
   # And verify  institute details displayed correctly "institute"
    And admin select the coupons option
    And verify  coupons details displayed correctly "coupons"
    And admin select the Certificates option
    Then verify  Certificates details displayed correctly "Certificates"

    Examples:
      | SecurityAction   | Status  | expectedmessage             |
      | 3453334          | invalid | No audit logs recorded yet. |
      | @#@#@            | invalid | No audit logs recorded yet. |
      | selenium         | invalid | No audit logs recorded yet. |
      | Course submitted | valid   |                             |

  Scenario: Verify total audit and displated details
    Given user is on the dashboard page again in 
    When admin select the audit trail module
    Then admin verify the total auditcount and coutdetails displayed

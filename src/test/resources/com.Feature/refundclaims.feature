Feature: corazzar application

  Scenario Outline: approve notes field and validation
    Given user is on the admin dashboard page
    When admin click the refund claim module
    And Admin verify the totalrefunt count and displayed details
    And admin click the approve button and verify the update data
    And the popup window open enter "<Approvenotes>"
    Then verify the approval notes validation "<ExpectedResult>"
    And verift the notes data "<Approvenotes>"
    And click the confirm approval
    And again click the approval button and click the close button
    Then again click the approval button and click the close icon

    Examples:
      | Approvenotes | ExpectedResult |
      | 89787        | invalid        |
      | @#@@!(&      | invalid        |
      | welcome      | valid          |

  Scenario Outline:
    Given user is on the admin dashboard page
    When admin click the refund claim module
    Then admin click the reject button and verify the update data
    And confirmation popup open enter the reason "<Rejectnotes>"
    Then verify the  reject notes validation "<ExpectedResult>"
    And  verift the rejectnotes data "<Rejectnotes>"
    And click the confirm reject button
    And again click the reject button and click the close button
   Then  again click the reject button and click the close icon

    Examples:
    
    |Rejectnotes|ExpectedResult|
    |768788|invalid|
    |#$%$%$#|invalid|
    |approved|valid|

Feature: corzaar application

  Scenario Outline: merchantpayout record verify
    Given admin is on tha dashboard page agin
    When admin click the merchant payment module
    And admin verify the record settlement popup window
    And admin select the institute or merchant recipient
    And admin enter the settlement amount "<amount>"
    And admin enter the bank transfer details "<bankreceipet>"
    And admin enter the notes details "<notes>"
    And admin select the log settlement button
    And admin click the disburse payout option
    And admin again  select the merchant instittute recipient
    And admin again enter the settlement amount "<amount>"
    And admin again enter the bank transfer details "<bankreceipet>"
    And admin again enter the notes details "<notes>"
    And admin again select the log settlement button
    Then verify the settlement details should be added

    Examples:
|amount|bankreceipet| notes|

|		|NEFT-64451987|Advanced fee|
|4500	|			|course fee|
|7566	|NEFT-64451992|tutusion fee|

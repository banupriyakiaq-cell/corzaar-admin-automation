Feature: corzaar application

  @admin
  Scenario Outline: Admin credentials invalid
    Given user lanuch the application
    When user click the admin button
    When user enter the "<Email id>"
    And user enter the password "<Password>"
    And click the aunthendicate button
    And user verify the "<status>" and "<Message>"

    Examples:
      | Email id           | Password   | status | Message                   |
      |                    |            | empty  | Email                     |
      |                    | Admin@123  | empty  | Email                     |
      | admin@corzaar.com  |            | empty  | password                  |
      | admin@corzaar.com  | Admin@1234 | failed | Invalid admin credentials |
      | admin@2corzaar.com | Admin@123  | failed | Invalid admin credentials |

  @otp
  Scenario Outline: Admin otp invalid
    Given user lanuch the application
    When user click the admin button
    When user enter the "<Email id>"
    And user enter the password "<Password>"
    And click the aunthendicate button
    And Admin is on the 2FA verification page
    And admin verifies email and password after back navigation
    And admin enters valid "<otp>"
    And admin click the verify button
    And admin verify the "<valid>" and "<Message>"
    Then admin should be logged in successfully

    Examples:
      | Email id          | Password  | otp    | valid   | Message           |
      | admin@corzaar.com | Admin@123 |        | empty   | Otp               |
      | admin@corzaar.com | Admin@123 | 12     | invalid | Invalid admin OTP |
      | admin@corzaar.com | Admin@123 | asderf | invalid | Invalid admin OTP |
      | admin@corzaar.com | Admin@123 | 123467 | invalid | Invalid admin OTP |
      | admin@corzaar.com | Admin@123 | 123456 | valid   |                   |

Feature: corzaar application

  Scenario Outline: Admin invalid
    Given user lanuch the application
    When user click the admin button
    When user enter the "<Email id>"
    And user enter the password "<Password>"
    And click the aunthendicate button
    And user verify the "<status>" and "<Message>"

    Examples:
      | Email id           | Password   | status | Message                   |
      | admin@corzaar.com  | Admin@1234 | failed | Invalid admin credentials |
      | admin@2corzaar.com | Admin@123  | failed | Invalid admin credentials |

  @email
  Scenario: Admin login with empty email
    Given user lanuch the application
    When user click the admin button
    And admin enter the password "Adminu@123"
    And click the aunthendicate with empty email
    Then admin should see the email validation message

  @password
  Scenario: Admin login with empty password
    Given user lanuch the application
    When user click the admin button
    And admin enter the  emailid "Admin@123"
    And click the aunthendicate with empty password
    Then admin should see the password validation message

  @otp
  Scenario: Admin login with empty OTP
    Given user lanuch the application
    When user click the admin button
    And admin enter the emailids "admin@corzaar.com "
    And admin enter tha password "Admin@123"
    And click the anuthenticatebutton
    And and admin clicks verify with empty OTP
    Then admin should see the otp validation messahe

  Scenario Outline: Admin valid
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
      | Email id          | Password  | otp    | valid   | Message           |
      | admin@corzaar.com | Admin@123 | asderf | invalid | Invalid admin OTP |
      | admin@corzaar.com | Admin@123 | 123467 | invalid | Invalid admin OTP |
      | admin@corzaar.com | Admin@123 | 123456 | valid   |                   |

Feature: corzaar application

   

  Scenario Outline: verify course moderation status
    Given user is on tha dashboard page
    When admin click the  course moderation module
    And admin search the course topic in search field "<course>"
    And admin verify the "<course>" as "<Status>"  with "<message>"
    And admin verify the entered search value "<course>"
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
      | course                      | Status  | message                            |
      | 3443                        | invalid | No courses found in this category. |
      | #$#$##                      | invalid | No courses found in this category. |
      | javafull stack              | invalid | No courses found in this category. |
      | Selenium Automation Testing | valid   |                                    |
      
  @count
  Scenario: verify total course count
    Given user is on tha dashboard page
    When admin click the  course moderation module
    Then admin verify total course count

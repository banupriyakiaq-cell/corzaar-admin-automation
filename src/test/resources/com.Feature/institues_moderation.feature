Feature: corzaar application

  @institute
  Scenario Outline: search institute by institute name
    Given user is on the institues moderation page
    When admin click the institues moderation module
    When admin enters "<InstituteName>" in institute search field
    Then and verify the "<status>" valid "<expected>" details
    And admin verify the search field details "<InstituteName>"
    When admin clear the search field in institute module

    Examples:
      | InstituteName          | status  | expected                      |
      | 1234r      | invalid | No matching institutes found. |
      | @#$%%#     | invalid | No matching institutes found. |
      | kiaq                    | invalid | No matching institutes found. |
      | Global Business Academy | valid   | Global Business Academy       |

  @place
  Scenario Outline: institues place
    Given user is on the institues moderation page
    When admin click the institues moderation module
    When admin enters the in institute place "<Place>" search field
    And admin enter the field displayed correct matching details in
    Then admin should see institutes from place "<Place>" with "<Status>" and expected "<expected>"
    And admin verift the details od search field "<Place>"
    When admin clear the plase details in search field

    Examples:
      | Place      | Status  | expected                      |
      | 1234       | invalid | No matching institutes found. |
      | @#$%%#     | invalid | No matching institutes found. |
      | Coimbatore | invalid | No matching institutes found. |
      | Bengaluru  | valid   | Bengaluru                     |

  @filter
  Scenario: Filter option
    Given user is on the institues moderation page
    When admin click the institues moderation module
    When admin select the approved option it should be displayed releted option
    And admin click the reject button and verify the count details
    And admin select the Pending option it should be displayed releted option
    And admin click the approve button and verify the count details
    And admin select the Rejected option it should be displayed releted option
    And admin select the again approve button and verify the count details
    And admin select the suspend option it should be displayed releted option
    Then admin again select the suspended button and verify the count details

  Scenario: verify total count and displayed count
    Given user is on the institues moderation page
    When admin click the institues moderation module
    Then admin verify the toatl institutes count and displayed details

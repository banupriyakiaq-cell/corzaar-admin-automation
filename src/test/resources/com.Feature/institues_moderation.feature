Feature: corzaar application
@institute
  Scenario Outline: search institute by institute name
    Given user is on the institues moderation page
    When admin click the institues moderation module
    When admin enters "<Institute Name>" in institute search field
    Then and verify the "<status>" valid "<expected>" details
	When admin clear the search field in institute module
    Examples:
      | Institute Name          | status  | expected                      |
      | kiaq                    | invalid | No matching institutes found. |
      | Global Business Academy | valid   | Global Business Academy       |
@place
  Scenario Outline: institues place
    Given user is on the institues moderation page
    When admin click the institues moderation module
    When admin enters the in institute place "<Place>" search field
    And admin enter the field displayed correct matching details in
    Then admin should see institutes from place "<Place>" with "<Status>" and expected "<expected>"
	When admin clear the plase details in search field
    Examples:
      | Place      | Status  |expected|
      | Coimbatore | invalid |No matching institutes found.|
      | Bengaluru  | valid   |Bengaluru|
@filter
  Scenario: Filter option
    Given user is on the institues moderation page
    When admin click the institues moderation module
    When admin select the approved option it should be displayed releted option
    And admin click the reject button
    And admin select the Pending option it should be displayed releted option
    And admin click the approve button
    And admin select the Rejected option it should be displayed releted option
    And admin select the again approve button
    And admin select the suspend option it should be displayed releted option
    Then admin again select the suspended button

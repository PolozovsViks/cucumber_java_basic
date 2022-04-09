@TaskNumber0neForCucumber
Feature: Task1
  As a user
  I should get errors, if entering invalid input

  Background:
    Given I am on Number page

@FirstTaskOfTask0ne
  Scenario Outline: for invalid inputs
    When I enter number "<number>"
    And I click submit
    Then I see error message "<message>"
    Examples:
      | number    | message                |
      | 27        | Number is too small    |
      | 127       | Number is too big      |
      | blablabla | Please enter a number  |

  @SecondTaskOfTask0ne
  Scenario: for valid input
    When I enter my valid number "81"
    And I click submit
    Then I see Alert saying "Square root of 81 is 9.00"
    And I click Ok
    And I get returned to initial page with clear input field and no errors


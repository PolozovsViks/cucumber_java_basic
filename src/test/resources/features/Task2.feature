@TaskNumberTwoForCucumber
Feature: Task2
  As a user
  I should be able to add new person
  I should be able to edit a person
  I should be able to remove a person
  I should be able to reset original list
  I should check that clear button works correctly

  Background:
    Given I am on People with jobs page

  Scenario Outline: for adding person
    When I click on Add Person
    And I get redirected to new page to enter data
    And I input Name "<name>"
    And I input Job "<job>"
    And I click on Add
    Then I see new person is added to list of people

    Examples:
      | name  | job        |
      | Rick  | Scientist  |

  Scenario: for editing person
    When I click pencil to edit person
    And I get redirected to new page to enter data
    And I change job to: "Scientist"
    And I click on Edit
    Then I see Persons info is changed accordingly

  Scenario: for removing person
    When I click x to remove person
    Then I see person is removed

  Scenario: for resetting the list
    When I click on Add Person
    And I get redirected to new page to enter data
    And I change job to: "Scientist"
    And I click on Add
    And I click pencil to edit person
    And I get redirected to new page to enter data
    And I change job to: "Pilot"
    And I click on Edit
    And I click x to remove person
    And I click on Reset List
    Then I see list is reset to original

  Scenario: for checking the Clear button
    When I click on Add Person
    And I get redirected to new page to enter data
    And I change job to: "Pilot"
    And I click on Clear all fields
    Then I see the fields are cleared















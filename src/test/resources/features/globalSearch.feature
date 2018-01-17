Feature: Global Search functionality

  Scenario Outline: Search by product name
    Given Home page is opened
    Then Enter "<product name>" into Global Search field
    Examples:
      | product name |
      | телевизор    |

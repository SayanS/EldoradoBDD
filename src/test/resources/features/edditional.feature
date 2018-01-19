Feature: 1Global Search functionality

  Scenario Outline: 1Search by product name
    Given Home page is opened
    Given User credentials
      | login | password |
      | John  | qwerty   |
    When Change user "email" to unique value
    Then Enter "<product name>" into Global Search field
    Examples:
      | product name |
      | телевизор    |


#  Scenario Outline: 1 Search by product name
#    Given Home page is opened
#    Then Enter "<product name>" into Global Search field
#    Examples:
#      | product name |
#      | телевизор    |
#
#  Scenario Outline: 2 Search by product name
#    Given Home page is opened
#    Then Enter "<product name>" into Global Search field
#    Examples:
#      | product name |
#      | телевизор    |
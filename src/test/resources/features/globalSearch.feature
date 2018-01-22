Feature: Global Search functionality

#  @ignore
#  Scenario Outline: Test experiments
#    Given Home page is opened
#    Given User credentials
#      | login | password |
#      | John  | qwerty   |
#    When Change user "email" to unique value
#    Then Enter "<product name>" into Global Search field
#    Examples:
#      | product name |
#      | телевизор    |

  Scenario Outline: Check Search city
    Given Home page is opened
    When Click on "Нет" button of Select city pop-up
    When Enter "<text>" into City name field on Select city pop-up
    Then Each context city on Select city pop-up should start with "<text>"
    Examples:
      | text    |
      | П       |
      | Харьков |




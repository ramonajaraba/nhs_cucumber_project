Feature: Dashboard page cards

  Background:
    Given the user navigate to the NHS website
    When  user login with credentials 'admin' and 'admin'
    When user validates page title 'NHS patients' and url 'http://www.techtorialacademy.link/app'
    Then user sees 3 cards
#
  Scenario: Dashboard page has 3 cards
    Then user validates the cards have the same dimensions and are on the same line
#
  Scenario: Dashboard cards have numbers
    Then user validates the cards have positive numbers

  Scenario Outline: Dashboard cards have the right text
    Then user validates the cards with '<cardIndex>' have the expected title '<value>'
    Examples:
      | cardIndex | value               |
      | 1         | Patients with rooms |
      | 2         | Patients waiting    |
      | 3         | Free rooms          |


#  Scenario Outline:   Dashboard cards have the right background color
#    Then user validates the cards with '<cardIndex>' have the expected color '<value>'
#    Examples:
#      | cardIndex | value |
#      | 1         | blue  |
#      | 2         | red   |
#      | 3         | yellow |

#
#  Scenario Outline: Dashboard cards have the right icons
#    Then user validates the cards with '<cardIndex>' have the expected '<value>'
#    Examples:
#      | cardIndex | value    |
#      | 1         | hotel    |
#      | 2         | child    |
#      | 3         | hospital |
#
##

#



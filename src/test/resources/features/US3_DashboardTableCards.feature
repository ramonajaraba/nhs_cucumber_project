Feature: Dashboard page cards: US2, US3

  Acceptance criteria:
  - Landing Page:
  - title: LoginPage,
  - url: http://www.techtorialacademy.link/
  - Successful login by using correct admin credentials
  - username: admin
  - password: admin
  - Home Page:
  - title: NHS patients
  - url: http://www.techtorialacademy.link/app
  - Home page has accessible: hospital information, health information, and manage the rooms
  -3 table cards
  - Table card 1:
  - titles: no., Patients with rooms, Room, Score(by default - descending order)

  Background:
    Given the user navigate to the NHS website
    When  user login with credentials 'admin' and 'admin'
    When user validates page title 'NHS patients' and url 'http://www.techtorialacademy.link/app'

  Scenario: Dashboard page has 3 table cards
    Then user sees 3 table cards

  Scenario: Table card 1 - validate titles
    Then user validates table card1 titles
      | no.                 |
      | Patients with rooms |
      | Room                |
      | Score               |

  Scenario: Table is sorted by default
    Then user validates table is sorted by default by column 4 in 'descending' order
    Then user validates the table 1 values from column 1 are in 'descending' order



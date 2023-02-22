Feature: Login to NHS website

  Background:
    Given the user navigate to the NHS website
    And validates page title 'LoginPage'

  Scenario: Successful login by using correct admin credentials
    And credential field attribute is required 'true'
    When  user login with credentials 'admin' and 'admin'
    Then user validates page title 'NHS patients' and url 'http://www.techtorialacademy.link/app'

  Scenario Outline: Unsuccessful login by using invalid credentials
    And credential field attribute is required 'true'
    When  user login with credentials "<username>" and '<password>'
    Then user validates page title 'LoginPage' and url 'http://www.techtorialacademy.link/'

    Examples:
      | username | password |
      | adeffgf  | admin    |
      | admin    | asfrgg   |
      | dsghf    | sfgfjy   |

  Scenario Outline: Unsuccessful login by using blank credentials
    And credential field attribute is required 'true'
    When  user login with credentials '<username>' and '<password>'
    Then user validates page title 'LoginPage' and url 'http://www.techtorialacademy.link/'
    Examples:
      | username | password |
      |          | admin    |
      | admin    |          |
      |          |          |




Feature: Tapu.com Automation test

  @Case1
  Scenario: Register
    Given User navigate to "TapuHomepage"
    Then  Click -Ucretsiz Uye Ol- button
    Then  Insert requested data
    And   Click checkbox
    Then  Click sing in button
    Given The modul of Number Verify cancel with click x
    Then  Name used during registration verify with name in the homepage
    Given Click my information below the name at the menu
    And   Verify this iformations with the data used during registiration

  @Case2
   Scenario: Login
    Given User navigate to "TapuHomepage"
    Then   Verify is homepage open
    And    Login to this site and Verify for successful login
    Given  Navigate to the bottom of this site
    Then   Clickability is verify in the fields under the headings -Gayrimenkul Danismanlarimiz- and -Sozlesmeler-
    And    Verify whether the texts of the h1 tag on the redirected pages are the same as the previous page
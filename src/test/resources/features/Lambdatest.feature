Feature: Lambdatest

  Scenario: Lambdatest form submiting
    Given I navigate to Lambdatest home page
    Then I click input form submit link
    Then  I enter all required data in form
    And I click submit
    Then I validate success message


  Scenario: Lambdatest form submiting 2
    Given I navigate to Lambdatest home page
    Then I click input form submit link
    When  I fill out the form with following information
      | name     | Islam              |
      | email    | IslamAsh@gmail.com |
      | password | Islam234           |
      | company  | Codefish           |
      | website  | Codefish.io        |
      | country  | United States      |
      | city     | Des Plaines        |
      | address1 | Devon 2200         |
      | address2 | Burlington 300     |
      | state    | IL                 |
      | zipCode  | 60443              |

    And I click submit
    Then I validate success message
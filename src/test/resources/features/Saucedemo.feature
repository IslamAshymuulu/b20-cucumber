Feature: Saucedemo

  Background:   // - helps to run steps BEFORE EVERY scenario in given feature file.
    When I navigate to page

  Scenario: Validate saucedemo

    Then I submit username and password
    Then Print out all item names from page

    Scenario: Login with locked user

      When I login with locked username and password
      Then I should get error message

      Scenario: Login with visual_user

        Then I logining to page
        Then  I select item
        Then I print the price
        Then  I adding item to cart
        Then I going to cart
        Then I validate that item is in the cart

        Scenario: Login with visual user

          When I login with visual user
          Then I should see "onesie" item
          And price should be 7.99
Feature: CaseKaro Cart Flow

  Scenario: Add all materials of same case to cart
    Given I open CaseKaro website
    When I click on Mobile Covers
    And I search for iPhone
    And I open iPhone 16 Pro from search results
    And I open first product
    And I add "Hard" material to cart
    And I add "Soft" material to cart
    And I add "Glass" material to cart
    Then I should see 3 items in the cart
    And I print cart item details

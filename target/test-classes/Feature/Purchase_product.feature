Feature: User Purchased product Pillow in Website Demo Midtrans

  @scenario-positive
  Scenario: Success Purchase product Pillow
    Given user Open browser
    And user go Demo Midtrans website
    And user choose "Midtrans Pillow" product
    And user click "BUY NOW" button
    And user fills the data in Shopping Cart
    When user click button "CHECKOUT"
    Then user is in Checkout page
    And user choose "Credit/debit card" payment method
    And user fill card number "4811111111111114"
    And user fill expiration date "02/42"
    And user fill cvv number "123"
    And user choose "Promo Senin"
    When user click button pay now
    Then user is in confirmation information page
    And user input password transaction "112233"
    When user click ok button
    Then user get transaction is success

  Scenario: Failed Purchase product Pillow
    Given user Open browser
    And user go Demo Midtrans website
    And user choose "Midtrans Pillow" product
    And user click "BUY NOW" button
    And user fills the data in Shopping Cart
    When user click button "CHECKOUT"
    Then user is in Checkout page
    And user choose "Credit/debit card" payment method
    And user fill card number "4811111111111114"
    And user fill expiration date "02/42"
    And user fill cvv number "123"
    And user choose "Proceed without promo"
    When user click button pay now
    Then user is in confirmation information page
    #And user input password transaction "112234"
    #When user click ok button
    #Then user transaction is failed
Feature: Purchase

    Background:
        Given Alan wants purchase
        And the browser must be open

    Scenario: Purchase product
        Given the user is in home page
         When the user search a iPhone item
         And add to cart the product
         And the user search a iMac item
         And add to cart the product
         And view the shopping cart
         And click in the checkout button
         And select the guest option
         And fill billing detail form
         And select delivery method
         And select the payment method
         And confirm the order
         Then the message Your order has been placed! must be visible

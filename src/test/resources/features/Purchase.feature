Feature: Purchase

    Background:
        Given Alan open the the browser in the shopping page

    Scenario: Purchase product
        Given Alan is in home page
        When Alan search a "iPhone" item
        And Alan add to cart the product
        And Alan search a "iMac" item
        And Alan add to cart the product
        And Alan view the shopping cart
        And Alan click in the checkout button
        And Alan choose the guest option
        And Alan fill billing detail form
        And Alan choose delivery method
        And Alan choose the payment method
        And Alan confirm the order
        Then Alan see the message "Your order has been placed!" must be visible

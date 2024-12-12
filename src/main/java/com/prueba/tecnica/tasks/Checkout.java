package com.prueba.tecnica.tasks;

import com.prueba.tecnica.userInterfaces.CheckoutPage;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class Checkout {

    public static Task checkoutOptions() {
        return Task.where("{0} select checkout options",
                Click.on(CheckoutPage.GUEST_RADIO_BUTTON),
                Click.on(CheckoutPage.CONTINUE_BUTTON)
        );
    }

    public static Task fillBillingForm(String firstName, String lastName, String email, String phone, String address,
                                       String city, String postalCode, String country, String state) {
        return Task.where("{0} fill billing form",
                Enter.theValue(firstName).into(CheckoutPage.FIRST_NAME_TEXT_INPUT),
                Enter.theValue(lastName).into(CheckoutPage.LAST_NAME_TEXT_INPUT),
                Enter.theValue(email).into(CheckoutPage.EMAIL_INPUT_TEXT),
                Enter.theValue(phone).into(CheckoutPage.TELEPHONE_INPUT_TEXT),
                Enter.theValue(address).into(CheckoutPage.ADDRESS_ONE_INPUT_TEXT),
                Enter.theValue(city).into(CheckoutPage.CITY_INPUT_TEXT),
                Enter.theValue(postalCode).into(CheckoutPage.POST_CODE_INPUT_TEXT),
                SelectFromOptions.byVisibleText(country).from(CheckoutPage.COUNTRY_SELECTOR),
                WaitUntil.the(CheckoutPage.REGION_STATE_SELECTOR, WebElementStateMatchers.containsSelectOption(state))
                                .forNoMoreThan(2).seconds(),
                SelectFromOptions.byVisibleText(state).from(CheckoutPage.REGION_STATE_SELECTOR),
                Click.on(CheckoutPage.CONTINUE_BILLING_BUTTON)
        );
    }

    public static Task selectDeliveryMethod() {
        return Task.where("{0} select delivery method",
                Click.on(CheckoutPage.FLAT_RATE_DELIVERY_METHOD),
                Click.on(CheckoutPage.CONTINUE_DELIVERY_METHOD)
        );
    }

    public static Task selectPaymentMethod() {
        return Task.where("{0} select payment method",
                Click.on(CheckoutPage.BANK_TRANSFER_RADIO_BUTTON),
                Click.on(CheckoutPage.TERMS_CONDITION_CHECKBOX),
                Click.on(CheckoutPage.CONTINUE_PAYMENT_METHOD)
        );
    }

    public static Task confirmOrder() {
        return Task.where("{0} confirm order",
                Click.on(CheckoutPage.CONFIRM_ORDER_BUTTON)
        );
    }
}

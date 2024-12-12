package com.prueba.tecnica.userInterfaces;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage {
    public static final Target CHECKOUT_TITLE = Target.the("Checkout title")
            .located(By.xpath("//h1[text()='Checkout']"));
    public static final Target CONTINUE_BUTTON = Target.the("Continue button step 1")
            .located(By.id("button-account"));
    public static final Target GUEST_RADIO_BUTTON = Target.the("Guest radio button")
            .located(By.xpath("//input[@value='guest']"));
    public static final Target FIRST_NAME_TEXT_INPUT = Target.the("Continue button step 1")
            .located(By.id("input-payment-firstname"));
    public static final Target LAST_NAME_TEXT_INPUT = Target.the("Continue button step 1")
            .located(By.id("input-payment-lastname"));
    public static final Target EMAIL_INPUT_TEXT = Target.the("Continue button step 1")
            .located(By.id("input-payment-email"));
    public static final Target TELEPHONE_INPUT_TEXT = Target.the("Continue button step 1")
            .located(By.id("input-payment-telephone"));
    public static final Target ADDRESS_ONE_INPUT_TEXT = Target.the("Continue button step 1")
            .located(By.id("input-payment-address-1"));
    public static final Target CITY_INPUT_TEXT = Target.the("Continue button step 1")
            .located(By.id("input-payment-city"));
    public static final Target POST_CODE_INPUT_TEXT = Target.the("Continue button step 1")
            .located(By.id("input-payment-postcode"));
    public static final Target COUNTRY_SELECTOR = Target.the("Continue button step 1")
            .located(By.id("input-payment-country"));
    public static final Target REGION_STATE_SELECTOR = Target.the("Continue button step 1")
            .located(By.id("input-payment-zone"));
    public static final Target CONTINUE_BILLING_BUTTON = Target.the("Continue button step 1")
            .located(By.id("button-guest"));
    public static final Target FLAT_RATE_DELIVERY_METHOD = Target.the("Flat Rate Delivery Method")
            .located(By.xpath("//input[@type='radio' and @value='flat.flat']"));
    public static final Target CONTINUE_DELIVERY_METHOD = Target.the("Continue delivery method")
            .located(By.id("button-shipping-method"));
    public static final Target CASH_ON_DELIVERY_RADIO_BUTTON = Target.the("Payment method radio button")
            .located(By.xpath("//input[@type='radio' and @value='cod']"));
    public static final Target BANK_TRANSFER_RADIO_BUTTON = Target.the("Payment method radio button")
            .located(By.xpath("//input[@type='radio' and @value='bank_transfer']"));
    public static final Target CONTINUE_PAYMENT_METHOD = Target.the("Continue payment method button")
            .located(By.id("button-payment-method"));
    public static final Target TERMS_CONDITION_CHECKBOX = Target.the("Terms condition checkbox")
            .located(By.name("agree"));
    public static final Target TOTAL_AMOUNT = Target.the("Total amount")
            .located(By.xpath("//*[@id=\"collapse-checkout-confirm\"]/div/div[1]/table/tfoot/tr[3]/td[2]"));
    public static final Target CONFIRM_ORDER_BUTTON = Target.the("Confirm order button")
            .located(By.id("button-confirm"));
}

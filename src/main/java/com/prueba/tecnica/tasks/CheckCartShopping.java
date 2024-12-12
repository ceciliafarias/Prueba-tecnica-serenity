package com.prueba.tecnica.tasks;

import com.prueba.tecnica.userInterfaces.CartPage;
import com.prueba.tecnica.userInterfaces.HeaderPage;
import com.prueba.tecnica.userInterfaces.SearchPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CheckCartShopping implements Task {

    public static CheckCartShopping checkCartShopping() {
        return instrumented(CheckCartShopping.class);
    }

    public static Task checkoutCartShopping() {
        WaitUntil.the(CartPage.CHECKOUT_BUTTON, WebElementStateMatchers.isClickable())
                .forNoMoreThan(10).seconds();
        return Task.where("{0} checkout shopping cart",
                Click.on(CartPage.CHECKOUT_BUTTON));
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(HeaderPage.CART_BUTTON, WebElementStateMatchers.isClickable())
                        .forNoMoreThan(10).seconds(),
                Click.on(HeaderPage.CART_BUTTON)
        );
    }
}

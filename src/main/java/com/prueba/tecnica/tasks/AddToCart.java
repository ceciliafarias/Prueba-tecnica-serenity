package com.prueba.tecnica.tasks;

import com.prueba.tecnica.userInterfaces.SearchPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddToCart implements Task {

    public static AddToCart toCart() {
        return instrumented(AddToCart.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SearchPage.ADD_TO_CART_BUTTON, WebElementStateMatchers.isClickable())
                        .forNoMoreThan(10).seconds(),
                Click.on(SearchPage.ADD_TO_CART_BUTTON)
        );
    }
}

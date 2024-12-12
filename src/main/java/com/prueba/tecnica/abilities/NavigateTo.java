package com.prueba.tecnica.abilities;

import com.prueba.tecnica.userInterfaces.ShoppingPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable theShoppingPage() {
        return Task.where("{0} opens the shopping home page",
                Open.browserOn().the(ShoppingPage.class));
    }
}

package com.prueba.tecnica.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage {
    public static final Target CHECKOUT_BUTTON = Target.the("Checkout Cart Button")
            .located(By.xpath("//strong[text()=' Checkout']"));
}

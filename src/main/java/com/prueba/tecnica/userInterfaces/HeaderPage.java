package com.prueba.tecnica.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HeaderPage {
    public static final Target SEARCH_TEXT_FIELD = Target.the("Search text field")
            .located(By.name("search"));
    public static final Target SEARCH_BUTTON = Target.the("Search button")
            .located(By.xpath("//*[@id=\"search\"]/span/button"));
    public static final Target CART_BUTTON = Target.the("Cart button")
            .located(By.id("cart"));
}

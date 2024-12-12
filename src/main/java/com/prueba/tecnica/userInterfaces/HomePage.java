package com.prueba.tecnica.userInterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class   HomePage {
    public static final Target HOME_DIV = Target.the("home div")
            .located(By.id("common-home"));
}

package com.prueba.tecnica.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SuccessPage {
    public static final Target SUCCESS_TITLE = Target.the("Success title")
            .located(By.xpath("//*[@id=\"content\"]/h1"));
}

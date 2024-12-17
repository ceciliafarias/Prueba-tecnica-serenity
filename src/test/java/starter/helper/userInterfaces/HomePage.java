package starter.helper.userInterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class HomePage extends PageObject{
    public static final Target HOME_DIV = Target.the("home div")
            .located(By.id("common-home"));
}

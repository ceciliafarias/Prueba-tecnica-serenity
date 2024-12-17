package starter.helper.abilities;

import starter.helper.userInterfaces.HomePage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable theShoppingPage() {
        return Task.where("{0} opens the shopping home page",
                Open.browserOn().the(HomePage.class));
    }
}

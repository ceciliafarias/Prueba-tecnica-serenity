package starter.helper.tasks;

import starter.helper.userInterfaces.HeaderPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchProduct implements Task {

    private final String productName;

    public SearchProduct(String productName) {
        this.productName = productName;
    }

    public static SearchProduct by(String productName) {
        return instrumented(SearchProduct.class, productName);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(productName).into(HeaderPage.SEARCH_TEXT_FIELD),
                Click.on(HeaderPage.SEARCH_BUTTON)
        );
    }
}

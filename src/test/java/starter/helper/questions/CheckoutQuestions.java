package starter.helper.questions;

import starter.helper.userInterfaces.CheckoutPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.TextContent;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class CheckoutQuestions {
    public static Question<String> checkTitle(){
        WaitUntil.the(CheckoutPage.CHECKOUT_TITLE, WebElementStateMatchers.isPresent())
                .forNoMoreThan(10).seconds();
        return actor -> TextContent.of(CheckoutPage.CHECKOUT_TITLE).answeredBy(actor);
    }

    public static Question<String> checkTotalAmount(){
        WaitUntil.the(CheckoutPage.TOTAL_AMOUNT, WebElementStateMatchers.isPresent())
                .forNoMoreThan(10).seconds();
        return actor -> TextContent.of(CheckoutPage.TOTAL_AMOUNT).answeredBy(actor).replaceAll("\\$", "");
    }
}

package com.prueba.tecnica.questions;

import com.prueba.tecnica.userInterfaces.SuccessPage;
import net.serenitybdd.screenplay.Question;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import net.serenitybdd.screenplay.questions.TextContent;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class SuccessQuestions {
    public static Question<String> checkSuccessTitle(){
        WaitUntil.the(SuccessPage.SUCCESS_TITLE, isVisible())
                .forNoMoreThan(10).seconds();
        return actor -> TextContent.of(SuccessPage.SUCCESS_TITLE).answeredBy(actor);
    }
}

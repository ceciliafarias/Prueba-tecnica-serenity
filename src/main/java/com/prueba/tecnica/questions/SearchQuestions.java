package com.prueba.tecnica.questions;

import com.prueba.tecnica.userInterfaces.SearchPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.TextContent;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class SearchQuestions {
    public static Question<String> searchResult(){
        return actor -> String.valueOf(TextContent.of(SearchPage.SEARCH_RESULT).answeredBy(actor));
    }

    public static Question<String> productNameSearchResult(){
        return actor -> TextContent.of(SearchPage.PRODUCT_NAME_SEARCH).answeredBy(actor);
    }

    public static Question<String> addToCartSuccessMessage(){
        WaitUntil.the(SearchPage.SUCCESS_MESSAGE, WebElementStateMatchers.isPresent())
                .forNoMoreThan(10).seconds();
        return actor -> TextContent.of(SearchPage.SUCCESS_MESSAGE).answeredBy(actor);
    }
}

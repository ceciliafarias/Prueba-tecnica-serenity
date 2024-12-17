package com.prueba.tecnica.questions;

import com.prueba.tecnica.userInterfaces.HomePage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class HomeQuestions implements Question<Boolean> {
    
    @Override
    public Boolean answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).find(HomePage.HOME_DIV).isDisplayed();
    }
    
    public static HomeQuestions is() {
        return new HomeQuestions();
    }
}

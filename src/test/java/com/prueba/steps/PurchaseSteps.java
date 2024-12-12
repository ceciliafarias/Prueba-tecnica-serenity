package com.prueba.steps;

import com.prueba.tecnica.abilities.NavigateTo;
import com.prueba.tecnica.questions.CheckoutQuestions;
import com.prueba.tecnica.questions.HomeQuestions;
import com.prueba.tecnica.questions.SearchQuestions;
import com.prueba.tecnica.questions.SuccessQuestions;
import com.prueba.tecnica.tasks.AddToCart;
import com.prueba.tecnica.tasks.CheckCartShopping;
import com.prueba.tecnica.tasks.Checkout;
import com.prueba.tecnica.tasks.SearchProduct;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PurchaseSteps {
    String buyerName;
    WebDriver driver = new ChromeDriver();

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) wants purchase")
    public void wantsPurchase(String name){
        this.buyerName = name;
    }

    @Given("^the browser must be open$")
    public void theBrowserMustBeOpen() {
        OnStage.theActorCalled(this.buyerName).can(BrowseTheWeb.with(this.driver));
        theActorCalled(this.buyerName).attemptsTo(NavigateTo.theShoppingPage());
    }


    @Given("^the user is in home page$")
    public void theUserIsInHomePage() {
        assert(HomeQuestions.is().answeredBy(theActorInTheSpotlight()));
    }

    @When("^the user search a (.*) item")
    public void theUserSearchAItem(String productName) {
        theActorCalled(this.buyerName).attemptsTo(
                SearchProduct.by(productName)
        );
        assertTrue(SearchQuestions.productNameSearchResult().answeredBy(theActorInTheSpotlight()).contains(productName));
    }

    @And("add to cart the product")
    public void addToCartTheProduct() {
        theActorCalled(this.buyerName).attemptsTo(
                AddToCart.toCart()
        );
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(SearchQuestions.addToCartSuccessMessage().answeredBy(theActorInTheSpotlight())
                .contains("Success: You have added"));
    }

    @And("view the shopping cart")
    public void viewTheShoppingCart() {
        theActorCalled(this.buyerName).attemptsTo(
                CheckCartShopping.checkCartShopping()
        );
    }

    @And("click in the checkout button")
    public void clickInTheCheckoutButton() {
        theActorCalled(this.buyerName).attemptsTo(
                CheckCartShopping.checkoutCartShopping()
        );
        assertTrue(CheckoutQuestions.checkTitle().answeredBy(theActorInTheSpotlight())
                .contains("Checkout"));
    }

    @And("select the guest option")
    public void selectTheGuestOption() {
        theActorCalled(this.buyerName).attemptsTo(
                Checkout.checkoutOptions()
        );

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @And("fill billing detail form")
    public void fillBillingDetailForm() {
        theActorCalled(this.buyerName).attemptsTo(
                Checkout.fillBillingForm("Ana", "Farias", "anacecilafarias@mailinator.com",
                        "0978848689", "Quito", "Quito", "170521", "Ecuador",
                        "Pichincha")
        );
    }

    @And("select the payment method")
    public void selectThePaymentMethod() {
        theActorCalled(this.buyerName).attemptsTo(
                Checkout.selectPaymentMethod()
        );
    }

    @And("select delivery method")
    public void selectDeliveryMethod() {
        theActorCalled(this.buyerName).attemptsTo(
                Checkout.selectDeliveryMethod()
        );
    }

    @And("confirm the order")
    public void confirmTheOrder() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        double totalAmount = Double.parseDouble(CheckoutQuestions.checkTotalAmount()
                .answeredBy(theActorInTheSpotlight()).replaceAll("\\$",""));
        assertTrue(totalAmount > 0);

        theActorCalled(this.buyerName).attemptsTo(
                Checkout.confirmOrder()
        );
    }

    @Then("^the message (.*) must be visible")
    public void theMessageMustBeVisible(String message) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String alertMessage = SuccessQuestions.checkSuccessTitle().answeredBy(theActorInTheSpotlight());
        assertEquals(alertMessage,message);
    }
}

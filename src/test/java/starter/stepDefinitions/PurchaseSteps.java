package starter.stepDefinitions;

import starter.helper.abilities.NavigateTo;
import starter.helper.questions.CheckoutQuestions;
import starter.helper.questions.SearchQuestions;
import starter.helper.questions.SuccessQuestions;
import starter.helper.tasks.AddToCart;
import starter.helper.tasks.CheckCartShopping;
import starter.helper.tasks.Checkout;
import starter.helper.tasks.SearchProduct;
import starter.helper.userInterfaces.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;


public class PurchaseSteps {

    @Given("{actor} open the the browser in the shopping page")
    public void theBrowserMustBeOpen(Actor actor) {
        actor.wasAbleTo(NavigateTo.theShoppingPage());
    }


    @Given("{actor} is in home page")
    public void theUserIsInHomePage(Actor actor) {
        actor.attemptsTo(
            Ensure.that(HomePage.HOME_DIV).isDisplayed()
        );
    }

    @When("{actor} search a {string} item")
    public void theUserSearchAItem(Actor actor, String productName) {
        actor.attemptsTo(
            SearchProduct.by(productName),
            Ensure.that(SearchQuestions.productNameSearchResult()).contains(productName)
        );
    }

    @And("{actor} add to cart the product")
    public void addToCartTheProduct(Actor actor) {
        actor.attemptsTo(
            AddToCart.toCart(),
            Ensure.that(SearchQuestions.addToCartSuccessMessage()).contains("Success: You have added")
        );
    }

    @And("{actor} view the shopping cart")
    public void viewTheShoppingCart(Actor actor) {
        actor.attemptsTo(
            CheckCartShopping.checkCartShopping()
        );
    }

    @And("{actor} click in the checkout button")
    public void clickInTheCheckoutButton(Actor actor) {
        actor.attemptsTo(
            CheckCartShopping.checkoutCartShopping(),
            Ensure.that(CheckoutQuestions.checkTitle()).contains("Checkout")
        );
    }

    @And("{actor} choose the guest option")
    public void selectTheGuestOption(Actor actor) {
        actor.attemptsTo(
                Checkout.checkoutOptions()
        );
    }

    @And("{actor} fill billing detail form")
    public void fillBillingDetailForm(Actor actor) {
        actor.attemptsTo(
            Checkout.fillBillingForm("Ana", "Farias", "email@mailinator.com",
                    "123456789", "Quito", "Quito", "170524", "Ecuador",
                    "Pichincha")
        );
    }

    @And("{actor} choose the payment method")
    public void chooseThePaymentMethod(Actor actor) {
        actor.attemptsTo(
            Checkout.selectPaymentMethod()
        );
    }

    @And("{actor} choose delivery method")
    public void chooseDeliveryMethod(Actor actor) {
        actor.attemptsTo(
            Checkout.selectDeliveryMethod()
        );
    }

    @And("{actor} confirm the order")
    public void confirmTheOrder(Actor actor) {
        actor.attemptsTo(
            Ensure.that(CheckoutQuestions.checkTotalAmount()).asADouble().isGreaterThan(0.00),
            Checkout.confirmOrder()
        );
    }

    @Then("{actor} see the message {string} must be visible")
    public void theMessageMustBeVisible(Actor actor, String message) {
        actor.attemptsTo(
            Ensure.that(SuccessQuestions.checkSuccessTitle()).contains(message)
        );
    }
}

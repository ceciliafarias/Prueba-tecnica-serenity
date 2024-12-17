package starter.helper.userInterfaces;

import org.openqa.selenium.By;

public class SearchPage {
    public static By SEARCH_RESULT = By.xpath("div#content >h1");
    public static By PRODUCT_NAME_SEARCH = By.cssSelector("#content > div:nth-child(8) > div > div > div:nth-child(2) > div.caption > h4 > a");
    public static By ADD_TO_CART_BUTTON = By.xpath("//button[contains(@onclick, \"cart.add\")]");
    public static By SUCCESS_MESSAGE = By.xpath("//div[contains(@class, \"success\")]");
}

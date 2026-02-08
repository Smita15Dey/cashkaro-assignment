package steps;

import base.BaseTest;
import io.cucumber.java.en.*;
import pages.*;

public class CaseKaroSteps extends BaseTest {

    HomePage home;
    ProductPage product;
    CartPage cart;

    // Steps to open CaseKaro website and initialize page objects 
    @Given("I open CaseKaro website")
    public void i_open_casekaro_website() {
        setup();
        home = new HomePage(page);
        product = new ProductPage(page);
        cart = new CartPage(page);

        home.openSite();
    }

    // Steps to navigate and interact with the site
    @When("I click on Mobile Covers")
    public void i_click_on_mobile_covers() {
        home.clickMobileCovers();
    }

    // Steps to search select iPhone 
    @When("I search for iPhone")
    public void i_search_for_iphone() {
        home.searchIphone();
    }

    // Steps to open iPhone 16 Pro from search results
    @When("I open iPhone 16 Pro from search results")
    public void i_open_iphone_16_pro() {
        home.openIphone16ProFromSearch();
    }

    // Steps to open the first product from the list
    @When("I open first product")
    public void i_open_first_product() {
        product.openFirstProduct();
    }

    // Steps to add material to cart and close the cart drawer
    @When("I add {string} material to cart")
    public void i_add_material_to_cart(String material) {
        product.selectMaterial(material);
        product.addToCartAndCloseDrawer();
    }

    // Steps to validate cart has 3 items
    @Then("I should see 3 items in the cart")
    public void i_should_see_3_items_in_cart() {
        cart.validateThreeItemsInCart();
    }

    // Steps to print cart item details and close the browser
    @Then("I print cart item details")
    public void i_print_cart_item_details() {
        cart.printCartItemDetails();
        tearDown();
    }
}

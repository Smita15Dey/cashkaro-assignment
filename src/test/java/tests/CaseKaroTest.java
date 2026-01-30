package tests;

import base.BaseTest;
import org.testng.annotations.*;
import pages.*;

/**
 * CaseKaroTest - Main test class for CaseKaro e-commerce application
 * 
 * This test suite verifies the complete shopping flow including:
 * - Navigating to mobile covers
 * - Selecting a specific product (iPhone 16 Pro)
 * - Adding multiple variations of the product to cart
 * - Validating cart contents
 */
public class CaseKaroTest extends BaseTest {

    // Page object instances
    HomePage home;
    ProductPage product;
    CartPage cart;

    /**
     * Setup method - runs before each test method
     * Initializes browser and all page objects
     */
    @BeforeMethod
    public void start() {
        setup();
        home = new HomePage(page);
        product = new ProductPage(page);
        cart = new CartPage(page);
    }

    /**
     * Main test method - verifyCartFlow
     * 
     * Test scenario:
     * 1. Navigate to CaseKaro website
     * 2. Browse to iPhone 16 Pro in mobile covers section
     * 3. Add the product with three different materials (Hard, Soft, Glass)
     * 4. Validate that all 3 items are present in the shopping cart
     */
    @Test
    public void verifyCartFlow() {
        // Step 1: Navigate to website and access mobile covers
        home.openSite();
        home.clickMobileCovers();

        // Step 2: Navigate to search type iphone then select iPhone 16 Pro
        home.searchIphone();
        home.openIphone16ProFromSearch();
        // home.searchAndOpenIphone16Pro();

        // Step 3: Open the first product available
        product.openFirstProduct();

        // Step 4: Add product with Hard material
        product.selectMaterial("Hard");
        product.addToCartAndCloseDrawer();

        // Step 5: Add product with Soft material
        product.selectMaterial("Soft");
        product.addToCartAndCloseDrawer();

        // Step 6: Add product with Glass material
        product.selectMaterial("Glass");
        product.addToCartAndCloseDrawer();

        // Step 7: Verify all 3 items are in the cart 
        cart.validateThreeItemsInCart();

        // step 8: Print cart item details
        cart.printCartItemDetails();

    }

    /**
     * Cleanup method - runs after each test method
     * Closes browser and releases resources
     */
    @AfterMethod
    public void end() {
        tearDown();
    }
}

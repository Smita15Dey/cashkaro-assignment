package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CartPage {

    private Page page;

    public CartPage(Page page) {
        this.page = page;
    }

    // VALIDATE 3 ITEMS IN CART
    public void validateThreeItemsInCart() {
        Locator cartItems = page.locator(".cart-item"); // cart items have class 'cart-item'
        int count = cartItems.count();
        System.out.println("Items in cart: " + count);
    }

    // PRINT ITEM DETAILS
     public void printCartItemDetails() {

        Locator cartItems = page.locator("tr.cart-item");
        int count = cartItems.count();

        System.out.println("\n----- CART ITEM DETAILS -----");

        // Iterate through each cart item
        for (int i = 0; i < count; i++) {

            // Single cart item
            Locator item = cartItems.nth(i);

            // Material
            String material = item
                    .locator("dt:has-text('Material') + dd") // using definition list structure to get material value
                    .textContent()
                    .trim();

            // Price
            String price = item
                    .locator("td.cart-item__details div.product-option") // price is inside product-option div in details column
                    .first()
                    .textContent()
                    .trim()
                    .replace("₹", "Rs.");

            // Product link
            String link = item
                    .locator("a.cart-item__name")
                    .getAttribute("href"); // get product link from product name anchor tag
            
            // Print details
            System.out.println("Item " + (i + 1));
            System.out.println("Material : " + material);
            System.out.println("Price    : " + price);
            System.out.println("Link     : " + link);
            System.out.println("-----------------------------");
        }
    }

}

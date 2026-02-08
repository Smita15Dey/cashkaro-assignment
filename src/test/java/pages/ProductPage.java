package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class ProductPage {

    private Page page;

    public ProductPage(Page page) {
        this.page = page;
    }

    // Open the first product from the list
    public void openFirstProduct() {
        // Wait for product cards to appear
        Locator firstProduct = page.locator("a[id^='CardLink-']").first();

        firstProduct.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));

        // Click and wait for navigation to product page
        page.waitForNavigation(() -> {
                firstProduct.click();
        });

        // Wait for Add to Cart button to confirm product page is loaded
        Locator addToCartBtn = page.locator("button[name='add']");
        addToCartBtn.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));
        }


    // Select material safely
    public void selectMaterial(String material) {

        // Wait a bit for variant section to stabilize
        page.waitForTimeout(500);

        Locator materialOption = page.locator("label")
                .filter(new Locator.FilterOptions().setHasText(material))
                .filter(new Locator.FilterOptions().setHasNotText("Black"))
                .first();

        materialOption.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));

        materialOption.scrollIntoViewIfNeeded();
        materialOption.click();

        // Small wait to let variant switch complete
        page.waitForTimeout(800);
    }

    // Add to cart and close the cart drawer
    public void addToCartAndCloseDrawer() {

        Locator addToCartBtn = page.locator("button[name='add']");

        // Wait until Add to Cart is visible & enabled
        addToCartBtn.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));

        // Sometimes button is visible but disabled for a moment
        page.waitForTimeout(500);

        addToCartBtn.scrollIntoViewIfNeeded();
        addToCartBtn.click();

        // Wait for cart drawer to open
        Locator cartDrawer = page.locator("#CartDrawer");
        cartDrawer.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));

        // Close cart drawer
        Locator closeBtn = page.locator("button.drawer__close");
        closeBtn.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));
        closeBtn.click();

        // Wait for drawer to close before next action
        cartDrawer.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.HIDDEN));
    }
}

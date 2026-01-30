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
        Locator firstProduct = page.locator("a[id^='CardLink-']").first();
        firstProduct.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));
        firstProduct.click();
    }

    // Select material
    public void selectMaterial(String material) {

        Locator materialOption = page.locator("label")
                .filter(new Locator.FilterOptions().setHasText(material))
                .filter(new Locator.FilterOptions().setHasNotText("Black"))
                .first();

        materialOption.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));

        materialOption.scrollIntoViewIfNeeded();
        materialOption.click();
    }

    // Add to cart and close the cart drawer
    public void addToCartAndCloseDrawer() {

        Locator addToCartBtn = page.locator("button[name='add']");
        addToCartBtn.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));

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

        // Wait for drawer to disappear before next action
        cartDrawer.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.HIDDEN));
    }
}

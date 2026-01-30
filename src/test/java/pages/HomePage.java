package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class HomePage {

    private Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    public void openSite() {
        page.navigate("https://casekaro.com/");
        page.waitForLoadState();
    }

    public void clickMobileCovers() {
        Locator mobileCovers = page.locator("#HeaderMenu-mobile-covers-69");
        mobileCovers.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));
        mobileCovers.scrollIntoViewIfNeeded();
        mobileCovers.click();
    }

    // Step 1: Search for iphone
    public void searchIphone() {
        Locator searchBox = page.locator("#modelSearch");

        searchBox.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));

        searchBox.scrollIntoViewIfNeeded();
        searchBox.click();
        searchBox.fill("iphone");

        // searchBox.type("iphone", new Locator.TypeOptions().setDelay(120));
    }

    // Step 2: Click iPhone 16 Pro from Real visible results
    public void openIphone16ProFromSearch() {

        // Wait until search results dropdown is visible
        Locator searchResults = page.locator("#searchResults");
        searchResults.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));

        // Find ONLY iPhone 16 Pro inside search results
        Locator iphone16Pro = searchResults
                .locator("a")
                .filter(new Locator.FilterOptions()
                        .setHasText("iPhone 16 Pro"))
                .first();

        iphone16Pro.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));

        iphone16Pro.scrollIntoViewIfNeeded();
        iphone16Pro.click();

        page.waitForLoadState();
    }
}

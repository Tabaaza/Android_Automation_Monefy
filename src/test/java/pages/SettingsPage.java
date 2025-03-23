package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class SettingsPage extends BasePage {

    private final By overflowMenu = By.id("com.monefy.app.lite:id/overflow");
    private final By settingsButton = By.id("com.monefy.app.lite:id/settings_panel");
    private final By currencyOption = By.id("com.monefy.app.lite:id/currency_selection_button");
    private final By currencySearchByText = By.id("com.monefy.app.lite:id/search_src_text");
    private final By eurOption = By.id("com.monefy.app.lite:id/relativeLayoutManageCategoriesListItem");
    private final By chosenCurrencyOption = By.id("com.monefy.app.lite:id/currency_name");

    public SettingsPage(AndroidDriver driver) {
        super(driver);
    }

    public void clickOverflowMenu() {
        clickElement(overflowMenu, "Overflow menu");
        clickElement(settingsButton, "Settings button");
    }

    public void openCurrencySelection() {
        clickElement(currencyOption, "Currency selection button");
    }

    public void searchAndSelectCurrency(String currencyName) {
        enterText(currencySearchByText, currencyName, "Currency search box");
        clickElement(eurOption, "EUR option from search results");
    }

    public String getChosenCurrency() {
        return getElementText(chosenCurrencyOption, "Chosen currency label");
    }
}

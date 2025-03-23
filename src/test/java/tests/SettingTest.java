package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.OnboardingPage;
import pages.SettingsPage;

@Epic("Monefy App Testing")
@Feature("Application Settings")
@Severity(SeverityLevel.NORMAL)
@Story("Change App Currency")
public class SettingTest extends BaseTest {

    private HomePage homePage;
    private OnboardingPage onboardingPage;
    private SettingsPage settingsPage;

    @BeforeClass
    public void classSetUp() {
        onboardingPage = new OnboardingPage(driver);
        homePage = new HomePage(driver);
        settingsPage = new SettingsPage(driver);
    }

    @BeforeMethod
    public void beforeEachTest() {
        onboardingPage.completeOnboardingFlow();
    }

    @Test(description = "Verify that user can change currency from USD to EUR in Home Page check the change")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test to validate changing the app currency from USD to EUR in settings then verifying the update on" +
            " the Home Page.")
    @Story("Change Currency to EUR")
    public void testChangeCurrencyToEUR() {

        Allure.step("Open overflow menu");
        settingsPage.clickOverflowMenu();

        Allure.step("Navigate to currency selection in settings");
        settingsPage.openCurrencySelection();

        Allure.step("Search for 'EURO' and select it");
        settingsPage.searchAndSelectCurrency("EURO");

        Allure.step("Validate that the selected currency in 'EUR'");
        String selectedCurrency = settingsPage.getChosenCurrency();
        Assert.assertTrue(selectedCurrency.contains("EUR"),
                "Currency did not update to EUR in Settings. Found: " + selectedCurrency);

        Allure.step("Close overflow menu to return to Home Page");
        settingsPage.clickOverflowMenu();

        Allure.step("Validate that Home Page displays 'EUR'");
        String homePageCurrency = homePage.getBalanceAmountCurrency();
        Assert.assertEquals(homePageCurrency, "EUR", "Home page currency symbol did not update to €.");
    }

}

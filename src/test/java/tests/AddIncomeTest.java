package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.IncomePage;
import pages.OnboardingPage;

@Epic("Monefy App Testing")
@Feature("Income Management")
@Severity(SeverityLevel.CRITICAL)
@Story("Adding Income")
public class AddIncomeTest extends BaseTest {

    private HomePage homePage;
    private IncomePage incomePage;
    private OnboardingPage onboardingPage;

    @BeforeClass
    public void classSetUp() {
        onboardingPage = new OnboardingPage(driver);
        homePage = new HomePage(driver);
        incomePage = new IncomePage(driver);
    }

    @BeforeMethod
    public void beforeEachTest() {
        onboardingPage.completeOnboardingFlow();
    }

    @Test(description = "Verify that income can added successfully using INCOME button")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Adds an income transaction using the main Income button, selects Salary, verifies updated balance.")
    @Story("Adding Income via Main Button")
    public void testAddIncomeMainButtonAndChooseCategory() {

        Allure.step("Get starting balance from Home Page");
        int startingBalance = homePage.getBalanceAmount();

        Allure.step("Click on the main Income button");
        homePage.clickIncome();

        Allure.step("Enter amount '5000' using UI keypad");
        incomePage.enterAmount("5000");

        Allure.step("Confirm the transaction");
        incomePage.confirmIncome();

        Allure.step("Select Salary category");
        incomePage.clickSalaryCategory();

        Allure.step("Get new balance and verify with startingBalance + newBalance");
        int newBalance = homePage.getBalanceAmount();

        Assert.assertEquals(newBalance, startingBalance + 5000, "Income was not added correctly!");
    }
}

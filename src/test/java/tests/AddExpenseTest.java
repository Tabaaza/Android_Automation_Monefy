package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ExpensePage;
import pages.HomePage;
import pages.OnboardingPage;

@Epic("Monefy App Testing")
@Feature("Expense Management")
@Severity(SeverityLevel.CRITICAL)
@Story("Adding Expenses")
public class AddExpenseTest extends BaseTest {

    private HomePage homePage;
    private ExpensePage expensePage;
    private OnboardingPage onboardingPage;

    @BeforeClass
    public void classSetUp() {
        onboardingPage = new OnboardingPage(driver);
        homePage = new HomePage(driver);
        expensePage = new ExpensePage(driver);
    }

    @BeforeMethod
    public void beforeEachTest() {
        onboardingPage.completeOnboardingFlow();
    }

    @Test(
            description = "Verify that an expense can be added successfully by click on the Categories icon around the" +
                    "donut chart"
    )
    @Severity(SeverityLevel.CRITICAL)
    @Description("Adds an expense by selecting the Categories icon and check that the balance is updated correctly.")
    @Story("Adding Expenses by Category Button")
    public void testAddExpenseByCatButton() {

        Allure.step("Click on Category");
        homePage.clickHouseCategory();

        Allure.step("Enter amount '1100' using UI keypad");
        expensePage.enterAmount("1100");

        Allure.step("Confirm the expense");
        expensePage.confirmExpense();

        Allure.step("Verify balance is updated");
        int balance = homePage.getBalanceAmount();
        Assert.assertEquals(balance, -1100.00, "Expense was not added correctly!");

    }

    @Test(
            description = "Verify that an expense can be added successfully using the Expense Button and choosing" +
                    " category")
    @Severity(SeverityLevel.NORMAL)
    @Description("Adds an expense using the Expense button, selects Toiletry, and verifies the updated balance.")
    @Story("Adding Expenses Then Select Category")

    public void testAddExpenseMainButtonAndChooseCategory() {
        Allure.step("Get starting balance");
        int startingBalance = homePage.getBalanceAmount();

        Allure.step("Click on Expense button");
        homePage.clickExpense();

        Allure.step("Enter amount '30' using UI keypad");
        expensePage.enterAmount("30");

        Allure.step("Confirm the expense");
        expensePage.confirmExpense();

        Allure.step("Select Toiletry");
        expensePage.clickToiletryCategory();

        Allure.step("Get new balance and verify startingBalance equals newBalance - entered Amount");
        int newBalance = homePage.getBalanceAmount();
        Assert.assertEquals(newBalance, startingBalance - 30, "Expense was not added correctly!");
    }
}

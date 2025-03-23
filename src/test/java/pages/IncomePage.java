package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class IncomePage extends BasePage {

    private final By confirmButton = By.id("com.monefy.app.lite:id/keyboard_action_button");

    private final By depositsCategory = By.xpath("//android.widget.GridView[@resource-id='com.monefy.app.lite:id/gridViewCategories']/android.widget.FrameLayout[1]");
    private final By salaryCategory = By.xpath("//android.widget.GridView[@resource-id='com.monefy.app.lite:id/gridViewCategories']/android.widget.FrameLayout[2]");
    private final By savingsCategory = By.xpath("//android.widget.GridView[@resource-id='com.monefy.app.lite:id/gridViewCategories']/android.widget.FrameLayout[3]");
    private final By addNewCategory = By.xpath("//android.widget.GridView[@resource-id='com.monefy.app.lite:id/gridViewCategories']/android.widget.FrameLayout[16]");

    public IncomePage(AndroidDriver driver) {
        super(driver);
    }

    public void confirmIncome() {
        clickElement(confirmButton, "Confirm Income button");
    }

    public void clickDepositsCategory() {
        clickElement(depositsCategory, "Deposits category");
    }

    public void clickSalaryCategory() {
        clickElement(salaryCategory, "Salary category");
    }

    public void clickSavingsCategory() {
        clickElement(savingsCategory, "Savings category");
    }

    public void clickAddNewCategory() {
        clickElement(addNewCategory, "Add New category");
    }
}

package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ExpensePage extends BasePage {

    private final By confirmButton = By.id("com.monefy.app.lite:id/keyboard_action_button");

    // Categories mapped by index (FrameLayout[1] to FrameLayout[15])
    private final By billsCategory = By.xpath("//android.widget.GridView[@resource-id='com.monefy.app.lite:id/gridViewCategories']/android.widget.FrameLayout[1]");
    private final By carCategory = By.xpath("//android.widget.GridView[@resource-id='com.monefy.app.lite:id/gridViewCategories']/android.widget.FrameLayout[2]");
    private final By clothesCategory = By.xpath("//android.widget.GridView[@resource-id='com.monefy.app.lite:id/gridViewCategories']/android.widget.FrameLayout[3]");
    private final By communicationsCategory = By.xpath("//android.widget.GridView[@resource-id='com.monefy.app.lite:id/gridViewCategories']/android.widget.FrameLayout[4]");
    private final By eatingOutCategory = By.xpath("//android.widget.GridView[@resource-id='com.monefy.app.lite:id/gridViewCategories']/android.widget.FrameLayout[5]");
    private final By entertainmentCategory = By.xpath("//android.widget.GridView[@resource-id='com.monefy.app.lite:id/gridViewCategories']/android.widget.FrameLayout[6]");
    private final By foodCategory = By.xpath("//android.widget.GridView[@resource-id='com.monefy.app.lite:id/gridViewCategories']/android.widget.FrameLayout[7]");
    private final By giftsCategory = By.xpath("//android.widget.GridView[@resource-id='com.monefy.app.lite:id/gridViewCategories']/android.widget.FrameLayout[8]");
    private final By healthCategory = By.xpath("//android.widget.GridView[@resource-id='com.monefy.app.lite:id/gridViewCategories']/android.widget.FrameLayout[9]");
    private final By houseCategory = By.xpath("//android.widget.GridView[@resource-id='com.monefy.app.lite:id/gridViewCategories']/android.widget.FrameLayout[10]");
    private final By petsCategory = By.xpath("//android.widget.GridView[@resource-id='com.monefy.app.lite:id/gridViewCategories']/android.widget.FrameLayout[11]");
    private final By sportsCategory = By.xpath("//android.widget.GridView[@resource-id='com.monefy.app.lite:id/gridViewCategories']/android.widget.FrameLayout[12]");
    private final By taxiCategory = By.xpath("//android.widget.GridView[@resource-id='com.monefy.app.lite:id/gridViewCategories']/android.widget.FrameLayout[13]");
    private final By toiletryCategory = By.xpath("//android.widget.GridView[@resource-id='com.monefy.app.lite:id/gridViewCategories']/android.widget.FrameLayout[14]");
    private final By transportCategory = By.xpath("//android.widget.GridView[@resource-id='com.monefy.app.lite:id/gridViewCategories']/android.widget.FrameLayout[15]");
    private final By addNewCategory = By.xpath("//android.widget.GridView[@resource-id='com.monefy.app.lite:id/gridViewCategories']/android.widget.FrameLayout[16]");

    public ExpensePage(AndroidDriver driver) {
        super(driver);
    }

    public void confirmExpense() {
        clickElement(confirmButton, "Confirm Expense button");
    }

    public void clickBillsCategory() {
        clickElement(billsCategory, "Bills category");
    }

    public void clickCarCategory() {
        clickElement(carCategory, "Car category");
    }

    public void clickClothesCategory() {
        clickElement(clothesCategory, "Clothes category");
    }

    public void clickCommunicationsCategory() {
        clickElement(communicationsCategory, "Communications category");
    }

    public void clickEatingOutCategory() {
        clickElement(eatingOutCategory, "Eating Out category");
    }

    public void clickEntertainmentCategory() {
        clickElement(entertainmentCategory, "Entertainment category");
    }

    public void clickFoodCategory() {
        clickElement(foodCategory, "Food category");
    }

    public void clickGiftsCategory() {
        clickElement(giftsCategory, "Gifts category");
    }

    public void clickHealthCategory() {
        clickElement(healthCategory, "Health category");
    }

    public void clickHouseCategory() {
        clickElement(houseCategory, "House category");
    }

    public void clickPetsCategory() {
        clickElement(petsCategory, "Pets category");
    }

    public void clickSportsCategory() {
        clickElement(sportsCategory, "Sports category");
    }

    public void clickTaxiCategory() {
        clickElement(taxiCategory, "Taxi category");
    }

    public void clickToiletryCategory() {
        clickElement(toiletryCategory, "Toiletry category");
    }

    public void clickTransportCategory() {
        clickElement(transportCategory, "Transport category");
    }

    public void clickAddNewCategory() {
        clickElement(addNewCategory, "Add New category");
    }
}

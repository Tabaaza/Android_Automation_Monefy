package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    // Locators
    private final By incomeButton = By.id("com.monefy.app.lite:id/income_button");
    private final By balanceAmount = By.id("com.monefy.app.lite:id/balance_amount");
    private final By incomeAmount = By.id("com.monefy.app.lite:id/income_amount_text");
    private final By expenseButton = By.id("com.monefy.app.lite:id/expense_button");


    // I figure out later that these are not fixed in the same location :/ (I don't like this app)
    private final By transportCategory = By.xpath("//android.widget.FrameLayout[@resource-id='com.monefy.app.lite:id/piegraph']/android.widget.ImageView[1]");
    private final By eatingOutCategory = By.xpath("//android.widget.FrameLayout[@resource-id='com.monefy.app.lite:id/piegraph']/android.widget.ImageView[2]");
    private final By houseCategory = By.xpath("//android.widget.FrameLayout[@resource-id='com.monefy.app.lite:id/piegraph']/android.widget.ImageView[3]");
    private final By foodCategory = By.xpath("//android.widget.FrameLayout[@resource-id='com.monefy.app.lite:id/piegraph']/android.widget.ImageView[4]");
    private final By carCategory = By.xpath("//android.widget.FrameLayout[@resource-id='com.monefy.app.lite:id/piegraph']/android.widget.ImageView[5]");
    private final By toiletryCategory = By.xpath("//android.widget.FrameLayout[@resource-id='com.monefy.app.lite:id/piegraph']/android.widget.ImageView[6]");
    private final By entertainmentCategory = By.xpath("//android.widget.FrameLayout[@resource-id='com.monefy.app.lite:id/piegraph']/android.widget.ImageView[7]");
    private final By sportCategory = By.xpath("//android.widget.FrameLayout[@resource-id='com.monefy.app.lite:id/piegraph']/android.widget.ImageView[8]");
    private final By taxiCategory = By.xpath("//android.widget.FrameLayout[@resource-id='com.monefy.app.lite:id/piegraph']/android.widget.ImageView[9]");
    private final By healthCategory = By.xpath("//android.widget.FrameLayout[@resource-id='com.monefy.app.lite:id/piegraph']/android.widget.ImageView[10]");
    private final By clothesCategory = By.xpath("//android.widget.FrameLayout[@resource-id='com.monefy.app.lite:id/piegraph']/android.widget.ImageView[11]");
    private final By communicationsCategory = By.xpath("//android.widget.FrameLayout[@resource-id='com.monefy.app.lite:id/piegraph']/android.widget.ImageView[12]");
    private final By giftsCategory = By.xpath("//android.widget.FrameLayout[@resource-id='com.monefy.app.lite:id/piegraph']/android.widget.ImageView[13]");
    private final By petsCategory = By.xpath("//android.widget.FrameLayout[@resource-id='com.monefy.app.lite:id/piegraph']/android.widget.ImageView[14]");

    // Constructor
    public HomePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickExpense() {
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(expenseButton));
            button.click();
            System.out.println("Clicked on the Expense button.");
        } catch (Exception e) {
            System.out.println("Failed to click on Expense button: " + e.getMessage());
        }
    }

    public void clickIncome() {
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(incomeButton));
            button.click();
            System.out.println("Clicked on the Income button.");
        } catch (Exception e) {
            System.out.println("Failed to click on Income button: " + e.getMessage());
        }
    }

    public int getBalanceAmount() {
        try {
            WebElement balance = wait.until(ExpectedConditions.visibilityOfElementLocated(balanceAmount));
            String balanceText = balance.getText();

            String cleanedBalance = balanceText.replaceAll("[^\\d.,\\-]", "");
            cleanedBalance = cleanedBalance.replace(",", "");

            if (cleanedBalance.contains(".")) {
                cleanedBalance = cleanedBalance.substring(0, cleanedBalance.indexOf('.'));
            }

            System.out.println("Balance Amount: " + cleanedBalance);
            return Integer.parseInt(cleanedBalance);

        } catch (Exception e) {
            System.out.println("Failed to retrieve balance amount: " + e.getMessage());
            return 0;
        }
    }

    public String getBalanceAmountCurrency() {
        try {
            WebElement balance = wait.until(ExpectedConditions.visibilityOfElementLocated(balanceAmount));
            String balanceText = balance.getText();

            // Extract the currency symbol or abbreviation
            if (balanceText.contains("€")) {
                return "EUR";
            } else if (balanceText.contains("$")) {
                return "USD";
            } else {
                // Add more logic if you want to support other currencies
                return "UNKNOWN";
            }

        } catch (Exception e) {
            System.out.println("Failed to retrieve balance currency: " + e.getMessage());
            return "";
        }
    }



    public String getIncomeAmount() {
        try {
            WebElement income = wait.until(ExpectedConditions.visibilityOfElementLocated(incomeAmount));
            String incomeText = income.getText();
            System.out.println("Income Amount: " + incomeText);
            return incomeText;
        } catch (Exception e) {
            System.out.println("Failed to retrieve income amount: " + e.getMessage());
            return "";
        }
    }

    public String getExpenseAmount() {
        try {
            WebElement expense = wait.until(ExpectedConditions.visibilityOfElementLocated(expenseButton));
            String expenseText = expense.getText();
            System.out.println("Expense Amount: " + expenseText);
            return expenseText;
        } catch (Exception e) {
            System.out.println("Failed to retrieve expense amount: " + e.getMessage());
            return "";
        }
    }

    public void clickTransportCategory() {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(transportCategory));
            element.click();
            System.out.println("Clicked on Transport category.");
        } catch (Exception e) {
            System.out.println("Failed to click on Transport category: " + e.getMessage());
        }
    }

    public void clickEatingOutCategory() {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(eatingOutCategory));
            element.click();
            System.out.println("Clicked on Eating Out category.");
        } catch (Exception e) {
            System.out.println("Failed to click on Eating Out category: " + e.getMessage());
        }
    }

    public void clickHouseCategory() {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(houseCategory));
            element.click();
            System.out.println("Clicked on House category.");
        } catch (Exception e) {
            System.out.println("Failed to click on House category: " + e.getMessage());
        }
    }

    public void clickFoodCategory() {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(foodCategory));
            element.click();
            System.out.println("Clicked on Food category.");
        } catch (Exception e) {
            System.out.println("Failed to click on Food category: " + e.getMessage());
        }
    }

    public void clickCarCategory() {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(carCategory));
            element.click();
            System.out.println("Clicked on Car category.");
        } catch (Exception e) {
            System.out.println("Failed to click on Car category: " + e.getMessage());
        }
    }

    public void clickToiletryCategory() {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(toiletryCategory));
            element.click();
            System.out.println("Clicked on Toiletry category.");
        } catch (Exception e) {
            System.out.println("Failed to click on Toiletry category: " + e.getMessage());
        }
    }

    public void clickEntertainmentCategory() {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(entertainmentCategory));
            element.click();
            System.out.println("Clicked on Entertainment category.");
        } catch (Exception e) {
            System.out.println("Failed to click on Entertainment category: " + e.getMessage());
        }
    }

    public void clickSportCategory() {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(sportCategory));
            element.click();
            System.out.println("Clicked on Sport category.");
        } catch (Exception e) {
            System.out.println("Failed to click on Sport category: " + e.getMessage());
        }
    }

    public void clickTaxiCategory() {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(taxiCategory));
            element.click();
            System.out.println("Clicked on Taxi category.");
        } catch (Exception e) {
            System.out.println("Failed to click on Taxi category: " + e.getMessage());
        }
    }

    public void clickHealthCategory() {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(healthCategory));
            element.click();
            System.out.println("Clicked on Health category.");
        } catch (Exception e) {
            System.out.println("Failed to click on Health category: " + e.getMessage());
        }
    }

    public void clickClothesCategory() {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(clothesCategory));
            element.click();
            System.out.println("Clicked on Clothes category.");
        } catch (Exception e) {
            System.out.println("Failed to click on Clothes category: " + e.getMessage());
        }
    }

    public void clickCommunicationsCategory() {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(communicationsCategory));
            element.click();
            System.out.println("Clicked on Communications category.");
        } catch (Exception e) {
            System.out.println("Failed to click on Communications category: " + e.getMessage());
        }
    }

    public void clickGiftsCategory() {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(giftsCategory));
            element.click();
            System.out.println("Clicked on Gifts category.");
        } catch (Exception e) {
            System.out.println("Failed to click on Gifts category: " + e.getMessage());
        }
    }

    public void clickPetsCategory() {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(petsCategory));
            element.click();
            System.out.println("Clicked on Pets category.");
        } catch (Exception e) {
            System.out.println("Failed to click on Pets category: " + e.getMessage());
        }
    }
}

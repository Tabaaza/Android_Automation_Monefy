package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected AndroidDriver driver;
    protected WebDriverWait wait;

    // Number keypad locators
    private final By number0KeyButton = By.id("com.monefy.app.lite:id/buttonKeyboard0");
    private final By number1KeyButton = By.id("com.monefy.app.lite:id/buttonKeyboard1");
    private final By number2KeyButton = By.id("com.monefy.app.lite:id/buttonKeyboard2");
    private final By number3KeyButton = By.id("com.monefy.app.lite:id/buttonKeyboard3");
    private final By number4KeyButton = By.id("com.monefy.app.lite:id/buttonKeyboard4");
    private final By number5KeyButton = By.id("com.monefy.app.lite:id/buttonKeyboard5");
    private final By number6KeyButton = By.id("com.monefy.app.lite:id/buttonKeyboard6");
    private final By number7KeyButton = By.id("com.monefy.app.lite:id/buttonKeyboard7");
    private final By number8KeyButton = By.id("com.monefy.app.lite:id/buttonKeyboard8");
    private final By number9KeyButton = By.id("com.monefy.app.lite:id/buttonKeyboard9");
    private final By dotKeyButton = By.id("com.monefy.app.lite:id/buttonKeyboardDot");

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickNumber(int number) {
        By locator = getNumberButtonBy(number);
        clickElement(locator, "number " + number + " key");
    }

    public void clickDot() {
        clickElement(dotKeyButton, "dot key");
    }

    public void enterAmount(String amount) {
        for (char c : amount.toCharArray()) {
            if (c == '.') {
                clickDot();
            } else {
                int number = Character.getNumericValue(c);
                clickNumber(number);
            }
        }
    }

    protected void clickElement(By locator, String description) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
            System.out.println("Clicked on " + description);
        } catch (Exception e) {
            System.out.println("Failed to click on " + description + ": " + e.getMessage());
        }
    }

    private By getNumberButtonBy(int number) {
        switch (number) {
            case 0: return number0KeyButton;
            case 1: return number1KeyButton;
            case 2: return number2KeyButton;
            case 3: return number3KeyButton;
            case 4: return number4KeyButton;
            case 5: return number5KeyButton;
            case 6: return number6KeyButton;
            case 7: return number7KeyButton;
            case 8: return number8KeyButton;
            case 9: return number9KeyButton;
            default: throw new IllegalArgumentException("Invalid number: " + number);
        }
    }

    protected void enterText(By locator, String text, String description) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
            driver.findElement(locator).sendKeys(text);
            System.out.println("Entered text '" + text + "' in " + description);
        } catch (Exception e) {
            System.out.println("Failed to enter text in " + description + ": " + e.getMessage());
        }
    }

    protected String getElementText(By locator, String description) {
        try {
            String text = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
            System.out.println("Text from " + description + ": " + text);
            return text;
        } catch (Exception e) {
            System.out.println("Failed to get text from " + description + ": " + e.getMessage());
            return "";
        }
    }

}

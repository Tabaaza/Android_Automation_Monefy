package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OnboardingPage {

    private AndroidDriver driver;
    private WebDriverWait wait;


    private final By welcomeScreenSkipButton = By.id("com.monefy.app.lite:id/buttonContinue");
    private final By subscriptionCloseButton = By.id("com.monefy.app.lite:id/buttonClose");


    public OnboardingPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean skipSingleWelcomeScreen() {
        try {
            WebElement skipButton = wait.until(
                    ExpectedConditions.elementToBeClickable(welcomeScreenSkipButton)
            );

            skipButton.click();
            System.out.println("Clicked on welcome screen skip button");

            Thread.sleep(500);

            return true;
        } catch (Exception e) {
            System.out.println("No more welcome screens to skip or element not found.");
            return false;
        }
    }


    public void skipAllWelcomeScreens() {
        int maxSkips = 3;
        int skipCount = 0;

        while (skipSingleWelcomeScreen()) {
            skipCount++;
            if (skipCount >= maxSkips) {
                System.out.println("Max skip attempts reached. Exiting welcome screen loop.");
                break;
            }
        }

        System.out.println("Finished skipping welcome screens.");
    }

    public void skipSubscriptionPage() {
        try {
            WebElement closeButton = wait.until(
                    ExpectedConditions.elementToBeClickable(subscriptionCloseButton)
            );

            closeButton.click();
            System.out.println("Closed the subscription page.");

            Thread.sleep(500);

        } catch (Exception e) {
            System.out.println("Subscription page not found or already skipped.");
        }
    }

    public void completeOnboardingFlow() {
        skipAllWelcomeScreens();
        skipSubscriptionPage();
        System.out.println("Onboarding flow completed.");
    }
}

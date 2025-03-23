package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    protected AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("Pixel");
        options.setPlatformVersion("16");
        options.setAutomationName("UiAutomator2");
        options.setApp(System.getProperty("user.dir") + "/apk/monefy.apk");
        options.setNewCommandTimeout(Duration.ofSeconds(60));

        options.setAppPackage("com.monefy.app.lite");
        options.setAppWaitActivity("com.monefy.activities.onboarding.OnboardingActivity_*");


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

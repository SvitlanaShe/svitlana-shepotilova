package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import lib.ui.*;
import org.junit.Assert;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CoreTestCase extends TestCase {
    protected AppiumDriver driver;
    private static String appiumUrl = "http://127.00.1:4723/wd/hub";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.gnucash.android");
        capabilities.setCapability("appActivity", ".ui.account.AccountsActivity");
        capabilities.setCapability("app", getClass().getResourceAsStream("/apks/GnucashAndroid_v2.4.0.apk"));

        driver = new AndroidDriver(new URL(appiumUrl), capabilities);
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        rotateScreenPortrait();
    }

    @Override
    public void tearDown() throws Exception {
        driver.quit();
        super.tearDown();
    }

    protected void rotateScreenPortrait() {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    protected void rotateScreenLandscape() {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    protected void backgroundApp(int seconds) {
        driver.runAppInBackground(seconds);
    }

    public void goToAccountsPageFromScratch() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.clickNextButton();
        DefaultCurrencyPage defaultCurrencyPage = new DefaultCurrencyPage(driver);
        defaultCurrencyPage.clickNextButton();
        AccountSetupPage accountSetupPage = new AccountSetupPage(driver);
        accountSetupPage.clickNextButton();
        FeedbackOptionsPage feedbackOptionsPage = new FeedbackOptionsPage(driver);
        feedbackOptionsPage.selectAutomaticallySendCrashReports();
        feedbackOptionsPage.clickNextButton();
        ReviewPage reviewPage = new ReviewPage(driver);
        reviewPage.clickNextButton();
        WhatsNewPage whatsNewPage = new WhatsNewPage(driver);
        whatsNewPage.clickDismissButton();
    }

}

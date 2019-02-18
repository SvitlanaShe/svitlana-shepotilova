package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ReviewPage extends MainPageObject {

    private static final By
            TITLE = By.id("title"),
            SAVE_BUTTON = By.id("btn_save"),
            HEADER_TEXT = By.className("android.widget.TextView"),
            DEFAULT_CURRENCY = By.xpath("//android.widget.LinearLayout[1]/android.widget.TextView[1][@text='Default Currency']"),
            CURRENCY_CHOICE = By.xpath("//android.widget.LinearLayout[1]/android.widget.TextView[2]"),
            ACCOUNT_SETUP = By.xpath("//android.widget.LinearLayout[2]/android.widget.TextView[1]"),
            ACCOUNT_SETUP_CHOICE = By.xpath("//android.widget.LinearLayout[2]/android.widget.TextView[2]"),
            FEEDBACK_OPTION = By.xpath("//android.widget.LinearLayout[3]/android.widget.TextView[1]"),
            FEEDBACK_OPTION_CHOICE = By.xpath("//android.widget.LinearLayout[3]/android.widget.TextView[2]");

    public ReviewPage(AppiumDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return waitForElementAndGetAttribute(
                TITLE,
                "text",
                "No title of page found",
                5);
    }

    public void clickNextButton() {
        waitForElementPresentByAndClick(
                SAVE_BUTTON,
                "Cann not find and click Next button",
                5);
    }

    public String getHeaderText() {
        return waitForElementAndGetAttribute(
                HEADER_TEXT,
                "text",
                "No header text  found",
                5);
    }

    public String getDefaultCurrency() {
        return getValueFor(DEFAULT_CURRENCY, CURRENCY_CHOICE);
    }

    public String getAccountSetupOption() {
        return getValueFor(ACCOUNT_SETUP, ACCOUNT_SETUP_CHOICE);
    }

    public String getFeedbackOptionsChoice() {
        return getValueFor(FEEDBACK_OPTION, FEEDBACK_OPTION_CHOICE);
    }

    private String getValueFor(By option, By choice) {
        waitForElementPresentBy(option, "No option's name found " , 5);
        return waitForElementAndGetAttribute(
                choice,
                "text",
                "No choice value found",
                5);
    }
}

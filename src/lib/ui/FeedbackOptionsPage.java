package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class FeedbackOptionsPage extends MainPageObject {

    private static final By
            TITLE = By.id("title"),
            SAVE_BUTTON = By.id("btn_save"),
            HEADER_TEXT = By.className("android.widget.TextView"),
            AUTOMATICALLY_SEND_CRASH_REPORT = By.className("android.widget.CheckedTextView");

    public FeedbackOptionsPage(AppiumDriver driver) {
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
                "Can not find and click Next button",
                5);
    }

    public String getHeaderText() {
        return waitForElementAndGetAttribute(
                HEADER_TEXT,
                "text",
                "No header text  found",
                5);
    }

    public void selectAutomaticallySendCrashReports() {
        waitForElementPresentByAndClick(
                AUTOMATICALLY_SEND_CRASH_REPORT,
                "Checkbox is not present",
                5);

    }
}

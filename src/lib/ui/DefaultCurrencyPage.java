package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class DefaultCurrencyPage extends MainPageObject {

    private static final By
            TITLE = By.id("title"),
            SAVE_BUTTON = By.id("btn_save"),
            HEADER_TEXT = By.className("android.widget.TextView");
    private static String CURRENCY_TPL = "//android.widget.CheckedTextView[@text='{PATTERN}']";

    public DefaultCurrencyPage(AppiumDriver driver) {
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

    public void selectCurrency(String currency) {
        waitForElementPresentByAndClick(
                getCurrencyElement(currency),
                "Not possible find and click currency " + currency,
                5);
    }

    public void swipeToLeft() {
        swipeElementToLeft(TITLE, "Can not swipe left");
    }

    private static By getCurrencyElement(String currency_name) {
        return By.xpath(CURRENCY_TPL.replace("{PATTERN}", currency_name.toUpperCase()));
    }
}

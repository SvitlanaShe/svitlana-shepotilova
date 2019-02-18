package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class WelcomePage extends MainPageObject {

    private static final By
            TITLE = By.id("title"),
            SAVE_BUTTON = By.id("btn_save");

    public WelcomePage(AppiumDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return waitForElementAndGetAttribute(
                TITLE,
                "text",
                "No title of article found",
                5);
    }

    public void swipeToLeft() {
        swipeElementToLeft(TITLE, "Can not swipe left");
    }

    public void clickNextButton() {
        waitForElementPresentByAndClick(
                SAVE_BUTTON,
                "Cann not find and click Next button",
                5);
    }
}

package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class AccountSetupPage extends MainPageObject {

    private static final By
            TITLE = By.id("title"),
            SAVE_BUTTON = By.id("btn_save"),
            BUTTON_CLOSE_X = By.id("button1");

    public AccountSetupPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickCloseButton() {
        waitForElementPresentByAndClick(
                BUTTON_CLOSE_X,
                "Button next not found",
                5);
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
                "Can not find and click Save button",
                5);
    }

}

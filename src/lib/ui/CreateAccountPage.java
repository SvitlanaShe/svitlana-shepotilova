package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class CreateAccountPage extends MainPageObject {

    private static final By
            CLOSE_BUTTON = By.className("android.widget.ImageButton"),
            SAVE_BUTTON = By.id("org.gnucash.android:id/menu_save"),
            ACCOUNT_NAME = By.id("input_account_name"),
            ACCOUNT_DESCRIPTION = By.id("input_account_description"),
            CHECKBOX_DEFAULT_TRANSFER_ACCOUNT = By.id("checkbox_default_transfer_account");

    public CreateAccountPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickSaveButton() {
        waitForElementPresentByAndClick(
                SAVE_BUTTON,
                "No Save button  found",
                5);
    }

    public void selectDefaultTransferAccount() {
        waitForElementPresentByAndClick(
                CHECKBOX_DEFAULT_TRANSFER_ACCOUNT,
                "No Checkbox default transfer account  found",
                5);
    }

    public void typeAccountName(String name) {
        waitForElementPresentByAndSendKeys(
                ACCOUNT_NAME,
                name,
                "No input account name found",
                5);
    }

    public void typeAccountDescription(String description) {
        waitForElementPresentByAndSendKeys(
                ACCOUNT_DESCRIPTION,
                description,
                "No input account description found",
                5);
    }

    public void clickCloseButton() {
        waitForElementPresentByAndClick(
                CLOSE_BUTTON,
                "No close button X found",
                5);
    }
}

package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class WhatsNewPage extends MainPageObject {

    private static final By
            DISMISS_BUTTON = By.className("android.widget.Button");

    public WhatsNewPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickDismissButton() {
        waitForElementPresentByAndClick(DISMISS_BUTTON,"No dismiss button",5);
    }
}

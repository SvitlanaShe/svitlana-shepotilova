package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

public class AccountsPage extends MainPageObject {

    private static final By
            TITLE = By.id("title"),
            ACCOUNTS = By.xpath("//android.widget.TextView[@text='Accounts']"),
            ALL = By.xpath("//android.widget.TextView[@text='All']"),
            FAVORITES = By.xpath("//android.widget.TextView[@text='Favorites']"),
            RECENT = By.xpath("//android.widget.TextView[@text='Recent']"),
            SEARCH_MENU = By.id("menu_search"),
            ADD_ACCOUNT_BUTTON = By.id("fab_create_account"),
            SEARCH_TEXT_INPUT = By.id("search_src_text");
    public static String
            ACCOUNT_NAME_TPL = "//android.widget.TextView[@text='{PATTERN}']";

    public AccountsPage(AppiumDriver driver) {
        super(driver);
    }

    private static By getAccountNameElement(String accountName) {
        return By.xpath(ACCOUNT_NAME_TPL.replace("{PATTERN}", accountName));
    }

    public void verifyTitlesAndTabsText() {
        waitForElementPresentBy(
                ACCOUNTS,
                "No Account text found",
                5);
        waitForElementPresentBy(
                ALL,
                "No All text found",
                5);
        waitForElementPresentBy(
                FAVORITES,
                "No FAVORITES tab found",
                5);
        waitForElementPresentBy(
                RECENT,
                "No Recent tab  found",
                5);
    }

    public void clickSearch() {
        waitForElementPresentBy(
                SEARCH_MENU,
                "No Account text found",
                5);
    }

    public void clickAddAccount() {
        waitForElementPresentByAndClick(
                ADD_ACCOUNT_BUTTON,
                "No add account text found",
                5);
    }

    public boolean searchAndFindAccountByName(String accountName) {
        clickSearch();
        try {
            waitForElementPresentByAndClick(getAccountNameElement(accountName),
                    "Account with name not found! Account name is " + accountName,
                    5);
        }
        catch (TimeoutException exception){
            return false;
        }
        return true;
    }
}

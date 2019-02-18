package tests;

import lib.CoreTestCase;
import lib.ui.*;
import org.junit.Assert;
import org.junit.Test;

public class InitialSetupTest extends CoreTestCase {


    @Test
    public void testGnuCashIntroduction() {
        WelcomePage welcomePage = new WelcomePage(driver);
        String actualTitle = welcomePage.getTitle();
        Assert.assertEquals("Title is not as expected", actualTitle, "Welcome to GnuCash");
        welcomePage.clickNextButton();
        DefaultCurrencyPage defaultCurrencyPage = new DefaultCurrencyPage(driver);
        actualTitle = defaultCurrencyPage.getTitle();
        Assert.assertEquals("Title is not as expected", actualTitle, "Default Currency");
        String titleTxt = defaultCurrencyPage.getHeaderText();
        Assert.assertEquals("Text setup is not as expected", titleTxt, "Setup GnuCash");

        defaultCurrencyPage.selectCurrency("EUR");
        welcomePage.clickNextButton();
        AccountSetupPage accountSetupPage = new AccountSetupPage(driver);
        actualTitle = accountSetupPage.getTitle();
        Assert.assertEquals("Text Account setup is not as expected", actualTitle, "Account Setup");

        accountSetupPage.clickNextButton();
        FeedbackOptionsPage feedbackOptionsPage = new FeedbackOptionsPage(driver);
        titleTxt = feedbackOptionsPage.getTitle();
        Assert.assertEquals("Text Account setup is not as expected", titleTxt, "Feedback Options");

        feedbackOptionsPage.selectAutomaticallySendCrashReports();
        feedbackOptionsPage.clickNextButton();
        ReviewPage reviewPage = new ReviewPage(driver);
        titleTxt = reviewPage.getTitle();
        Assert.assertEquals("Text Account setup is not as expected", titleTxt, "Review");

        String value = reviewPage.getDefaultCurrency();
        Assert.assertEquals("Text Account setup is not as expected", value, "EUR");

        value = reviewPage.getAccountSetupOption();
        Assert.assertEquals("Text Account setup is not as expected", value, "Create default accounts");

        value = reviewPage.getFeedbackOptionsChoice();
        Assert.assertEquals("Text Account setup is not as expected", value, "Automatically send crash reports");

    }
}

package tests;

import lib.CoreTestCase;
import lib.ui.AccountSetupPage;
import lib.ui.DefaultCurrencyPage;
import lib.ui.WelcomePage;
import org.junit.Assert;
import org.junit.Test;

public class AUTTest extends CoreTestCase {

    @Test
    public void testChangeScreenOrientation() {

        WelcomePage welcomePage = new WelcomePage(driver);
        String actualTitle = welcomePage.getTitle();
        Assert.assertEquals("Title is not as expected", actualTitle, "Welcome to GnuCash");
        welcomePage.clickNextButton();

        DefaultCurrencyPage defaultCurrencyPage = new DefaultCurrencyPage(driver);
        actualTitle = defaultCurrencyPage.getTitle();
        Assert.assertEquals("Title is not as expected", actualTitle, "Default Currency");

        String titleTxt = defaultCurrencyPage.getHeaderText();
        Assert.assertEquals("Text setup is not as expected", titleTxt, "Setup GnuCash");

        welcomePage.clickNextButton();

        AccountSetupPage accountSetupPage = new AccountSetupPage(driver);
        String title_before_rotation = accountSetupPage.getTitle();
        Assert.assertEquals("Text Account setup is not as expected", title_before_rotation, "Account Setup");

        rotateScreenLandscape();
        String title_after_rotation = accountSetupPage.getTitle();
        Assert.assertEquals("Title is not similar when rotated", title_before_rotation, title_after_rotation);

        rotateScreenPortrait();
        String title_after_second_rotation = accountSetupPage.getTitle();
        Assert.assertEquals("Title is not similar when rotated", title_before_rotation, title_after_second_rotation);
    }

    @Test
    public void testSwipePages() {

        WelcomePage welcomePage = new WelcomePage(driver);
        String actualTitle = welcomePage.getTitle();
        Assert.assertEquals("Title is not as expected", actualTitle, "Welcome to GnuCash");
        welcomePage.swipeToLeft();

        DefaultCurrencyPage defaultCurrencyPage = new DefaultCurrencyPage(driver);
        actualTitle = defaultCurrencyPage.getTitle();
        Assert.assertEquals("Title is not as expected", actualTitle, "Default Currency");
        String titleTxt = defaultCurrencyPage.getHeaderText();
        Assert.assertEquals("Text setup is not as expected", titleTxt, "Setup GnuCash");
        defaultCurrencyPage.swipeToLeft();

        AccountSetupPage accountSetupPage = new AccountSetupPage(driver);
        titleTxt = accountSetupPage.getTitle();
        Assert.assertEquals("Text Account setup is not as expected", titleTxt, "Account Setup");
    }

    @Test
    public void testCheckInBackground() {
        WelcomePage welcomePage = new WelcomePage(driver);
        String actualTitle = welcomePage.getTitle();
        Assert.assertEquals("Title is not as expected", actualTitle, "Welcome to GnuCash");
        welcomePage.clickNextButton();

        DefaultCurrencyPage defaultCurrencyPage = new DefaultCurrencyPage(driver);
        actualTitle = defaultCurrencyPage.getTitle();
        Assert.assertEquals("Title is not as expected", actualTitle, "Default Currency");
        String titleTxt = defaultCurrencyPage.getHeaderText();
        Assert.assertEquals("Text setup is not as expected", titleTxt, "Setup GnuCash");
        welcomePage.clickNextButton();

        AccountSetupPage accountSetupPage = new AccountSetupPage(driver);
        actualTitle = accountSetupPage.getTitle();
        Assert.assertEquals("Text Account setup is not as expected", actualTitle, "Account Setup");

        backgroundApp(2);

        actualTitle = accountSetupPage.getTitle();
        Assert.assertEquals("Text Account setup is not as expected", actualTitle, "Account Setup");
    }

}

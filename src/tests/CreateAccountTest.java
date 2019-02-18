package tests;

import lib.CoreTestCase;
import lib.ui.AccountsPage;
import lib.ui.CreateAccountPage;
import org.junit.Assert;
import org.junit.Test;

public class CreateAccountTest extends CoreTestCase {

    @Test
    public void testCreateAccount() {

        goToAccountsPageFromScratch();

        AccountsPage accountsPage = new AccountsPage(driver);
        accountsPage.verifyTitlesAndTabsText();
        accountsPage.clickAddAccount();

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        String accountName = "AccountName";
        createAccountPage.typeAccountName(accountName);
        createAccountPage.typeAccountDescription("Description test");
        createAccountPage.selectDefaultTransferAccount();

        createAccountPage.clickSaveButton();

        accountsPage = new AccountsPage(driver);
        Assert.assertTrue("Account not found during search " + accountName,
                accountsPage.searchAndFindAccountByName(accountName));

    }

    @Test
    public void testAccountCreationWithoutSaving() {

        goToAccountsPageFromScratch();

        AccountsPage accountsPage = new AccountsPage(driver);
        accountsPage.verifyTitlesAndTabsText();
        accountsPage.clickAddAccount();

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        String accountName = "AccountName";
        createAccountPage.typeAccountName(accountName);
        createAccountPage.typeAccountDescription("Description test");
        createAccountPage.selectDefaultTransferAccount();

        createAccountPage.clickCloseButton();

        accountsPage = new AccountsPage(driver);
        //Account is not created
        Assert.assertFalse("Account not found during search " + accountName,
                accountsPage.searchAndFindAccountByName(accountName));
    }

}



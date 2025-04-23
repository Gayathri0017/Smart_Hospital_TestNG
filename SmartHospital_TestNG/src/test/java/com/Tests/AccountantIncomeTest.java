package com.Tests;


import com.Pages.AccountantPageIncome;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AccountantIncomeTest extends BaseTest {

    @Test(priority = 1)
    public void testAddNewIncomeValidData() {
        AccountantPageIncome accountantPageIncome = new AccountantPageIncome(getDriver());
		accountantPageIncome.selectRole("Accountant");
        accountantPageIncome.clickSignIn();
        accountantPageIncome.navigateToFinanceSection();
        accountantPageIncome.clickIncome();
        accountantPageIncome.clickAddIncome();
        accountantPageIncome.enterIncomeDetails("Hospital charge", "Dr.S.Ramkumar", "1500.00");
        accountantPageIncome.clickSave();
        Assert.assertTrue(accountantPageIncome.verifyIncomeAdded().contains("1500.00"), "Income not added correctly");
        
    }

    @Test(priority = 2)
    public void testAddNewIncomeInvalidData() {
    	AccountantPageIncome accountantPageIncome = new AccountantPageIncome(getDriver());
		accountantPageIncome.selectRole("Accountant");
        accountantPageIncome.clickSignIn();
        accountantPageIncome.navigateToFinanceSection();
        accountantPageIncome.clickIncome();
        accountantPageIncome.clickAddIncome();
        accountantPageIncome.enterIncomeDetails("Canteen Rent", "", "100.00");
        accountantPageIncome.clickSave();
        Assert.assertEquals(accountantPageIncome.getError(), "Name field is required");
      }
}
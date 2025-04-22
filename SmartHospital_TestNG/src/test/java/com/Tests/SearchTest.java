package com.Tests;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Pages.SearchPage;
public class SearchTest extends BaseTest {
    @Test(priority=1)
    public void verifyExistingPatientSearch() {
        SearchPage searchPage=new SearchPage(getDriver());
        searchPage.login();
        searchPage.searchBar.sendKeys("Dharani");
        searchPage.searchBtn.click();
        WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(searchPage.name));
        String actual=searchPage.name.getText();
        Assert.assertTrue(actual.contains("Dharani"));
    }
    @Test(priority=2)
    public void verifyNonExistingPatientSearch() {
        SearchPage searchPage=new SearchPage(getDriver());
        searchPage.login();
        searchPage.searchBar.clear();
        searchPage.searchBar.sendKeys("testname12");
        searchPage.searchBtn.click();
        WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(searchPage.error));
        String actualError=searchPage.error.getText();
        Assert.assertTrue(actualError.contains("No data available in table"));
    }
}

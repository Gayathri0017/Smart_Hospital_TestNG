package com.Pages;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class SearchPage extends BasePage{
	public SearchPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//i[@class=\"fa fa-user-md ispace\"]")
	public WebElement doctor;
	@FindBy(xpath="//button[@class=\"btn\"]")
	public WebElement signin;
	@FindBy(xpath="//input[@class=\"form-control search-form search-form3\"]")
	public WebElement searchBar;
	@FindBy(xpath="//tr[@class=\"odd\"]//td[2]/a")
	public WebElement name;
	@FindBy(xpath="//tr[@class=\"odd\"]//td//div")
	public WebElement error;
	@FindBy(id="search-btn")
	public WebElement searchBtn;
	@FindBy(xpath="//table[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[1]/input")
	public WebElement chkBox;
	@FindBy(xpath="//table[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[2]/a")
	public WebElement delName;
	@FindBy(xpath="//button[@id=\"load\"]")
	public WebElement delBtn;
	public void login() {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(doctor)).click();
        wait.until(ExpectedConditions.elementToBeClickable(signin)).click();
    }
	public void clickDelete() {
		clickmethod(delBtn);
	}
	public void sendKeysMethod(WebElement ele,String val) {
		ele.sendKeys(val);
	}
	public void clickmethod(WebElement ele) {
		ele.click();
	}
	

}

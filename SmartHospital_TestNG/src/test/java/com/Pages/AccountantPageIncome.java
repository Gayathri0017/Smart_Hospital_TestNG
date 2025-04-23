package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountantPageIncome {
    private WebDriver driver;
    public AccountantPageIncome(WebDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Accountant')]")
    public WebElement accountantRoleButton;

    @FindBy(xpath = "//*[@class=\"btn\"]")
    public WebElement signInButton;

    @FindBy(xpath = "//section[@id='sibe-box']/ul[2]/li[14]/a/span")
    public WebElement financeSection;

    @FindBy(xpath = "//section[@id=\"sibe-box\"]/ul[2]/li[14]/ul/li[1]/a")
    public WebElement incomeButton;

    @FindBy(xpath = "//*[@class=\"box-tools pull-right\"]/child::a")
    public WebElement addIncomeButton;

    @FindBy(id = "inc_head_id")
    public WebElement incomeHeaderField;

    @FindBy(id = "name")
    public WebElement incomeNameField;

    @FindBy(id = "amount")
    public WebElement incomeAmountField;

    @FindBy(id = "add_incomebtn")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@id='toast-container']/div/div/p")
    public WebElement errorNotification;

    @FindBy(xpath = "//table[@id='DataTables_Table_0']/tbody/tr[1]/td[6]")
    public WebElement tableValue;
    
	public void selectRole(String role) {
		accountantRoleButton.click();
	}

	public void clickSignIn() {
		signInButton.click();
	}
	
	public String getError() {
		return errorNotification.getText();
	}

	public void navigateToFinanceSection() {
		financeSection.click();
		
	}
	
	public void clickIncome() {
		incomeButton.click();
	}

	public void clickAddIncome() {
		addIncomeButton.click();
	}

	public void enterIncomeDetails(String header, String name, String amount) {
		incomeHeaderField.sendKeys(header);
		incomeNameField.sendKeys(name);
		incomeAmountField.sendKeys(amount);
	}

	public void clickSave() {
		saveButton.click();
	}
	
	public String verifyIncomeAdded() {
		return tableValue.getText();
	}


}
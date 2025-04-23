package com.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DischargePage extends BasePage {
	public DischargePage(WebDriver driver) {
        super(driver);
    }
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    @FindBy(xpath = "//div[@class='slimScrollDiv']/section/ul[2]/li[1]//following-sibling::li[4]/a")
    private WebElement ipd;

    @FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr[1]/td[1]/a")
    private WebElement firstPatient;

    @FindBy(xpath = "//*[@id='overview']/div/div[1]/div[1]/h3 ")
    private WebElement dischargePatientName;

    @FindBy(xpath = "//*[@id=\"overview\"]/div/div[1]/div[1]/div/div/a[3]/i")
    private WebElement dischargeIcon;

    @FindBy(name = "discharge_date")
    private WebElement dischargeDate;

    @FindBy(xpath = "//form[@id=\"patient_discharge\"]/div[2]/div[2]/div/select")
    private WebElement dischargeStatus;

    @FindBy(id = "add_paymentbtn")
    private WebElement dischargeSaveBtn;

    @FindBy(xpath = "//*[@id=\"toast-container\"]/div/div/p")
    private WebElement error;

    @FindBy(xpath = "//div[@id='DataTables_Table_0_filter']/label/input")
    private WebElement searchField;
    
    @FindBy(xpath="//ul[@class=\"dropdown-menu inner selectpicker\"]//li[5]")
	public WebElement eng;
    @FindBy(xpath="//div[@class=\"btn-group bootstrap-select language\"]")
	public WebElement lan;
    
    @FindBy(xpath="//i[@class=\"fa fa-user-md ispace\"]")
	public WebElement doctor;
	@FindBy(xpath="//button[@class=\"btn\"]")
	public WebElement signin;
	
	@FindBy(xpath = "//tr[@class='odd']/td/div")
	public WebElement NodataAvailable ;
	
	public void login() {
		doctor.click();
		signin.click();
	}
	
	public void english() {
		lan.click();
		eng.click();
	}
    public void clickIPD() {
        ipd.click();
    }

    public void clickFirstPatient() {
//    	wait.until(ExpectedConditions.visibilityOf(firstPatient));
    	wait.until(ExpectedConditions.elementToBeClickable(firstPatient));
        firstPatient.click();
    }

    public void clickDischargeBtn() {
        dischargeIcon.click();
    }

    public void setDischargeDate() {
        dischargeDate.click();
        }
        

    public void setDischargeStatus(String status) {
//        new Select(dischargeStatus).selectByVisibleText(status);
    	dischargeStatus.sendKeys(status);
    }
    
    public String getpatientID() {
    	return dischargePatientName.getText();
    }
    public void clickDischargeSaveBtn() {
        dischargeSaveBtn.click();
    }

    public String getError() {
        return error.getText();
    }

    public void setCaseId(String caseId) {
        searchField.sendKeys(caseId+Keys.CONTROL.ENTER);
    }
    
    public String getNoDataAvail() {
    	return NodataAvailable.getText();
    }
}
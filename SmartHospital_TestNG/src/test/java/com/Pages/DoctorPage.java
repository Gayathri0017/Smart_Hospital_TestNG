package com.Pages;
import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class DoctorPage extends BasePage{
	public DoctorPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//i[@class=\"fa fa-user-md ispace\"]")
	public WebElement doctor;
	@FindBy(xpath="//button[@class=\"btn\"]")
	public WebElement signin;
	@FindBy(xpath="(//li[@class=\"treeview \"]//span)[2]")
	public WebElement appointment;
	@FindBy(xpath="//a[@class=\"btn btn-primary btn-sm addappointment\"]")
	public WebElement addAppointment;
	@FindBy(xpath="//a[@id=\"add\"]")
	public WebElement addpatient;
	@FindBy(xpath="//input[@id=\"name\"]")
	public WebElement pName;
	@FindBy(xpath="//input[@id=\"age_year\"]")
	public WebElement year;
	@FindBy(xpath="//input[@id=\"age_month\"]")
	public WebElement month;
	@FindBy(xpath="//input[@id=\"age_day\"]")
	public WebElement day;
	@FindBy(id="addformgender")
	public WebElement gender;
	@FindBy(xpath="//select[@name=\"blood_group\"]")
	public WebElement bloodGroup;
	@FindBy(xpath="//input[@id=\"file\"]")
	public WebElement uploadPhoto;
	@FindBy(xpath="//button[@id=\"formaddpabtn\"]")
	public WebElement saveBtn;
	
	@FindBy(xpath="//span[@id=\"select2-addpatient_id-container\"]")
	public WebElement nameAfterAdd;
	@FindBy(id="select2-doctorid-container")
	public WebElement document;
	@FindBy(xpath="//select[@id=\"global_shift\"]")
	public WebElement shift;
	@FindBy(id="appointment_status")
	public WebElement status;
	@FindBy(id="discount_percentage")
	public WebElement discount;
	@FindBy(xpath="//input[@id=\"datetimepicker\"]")
	public WebElement date;
	@FindBy(id="slot")
	public WebElement slot;
//	@FindBy(xpath="//button[@id=\"formaddbtn\"]")
//	public WebElement save;
	@FindBy(xpath="//button[@id=\"formaddbtn\"]")
	public WebElement savebtn;
	@FindBy(xpath="//select[@id=\"doctorid\"]")
	public WebElement doc;
	
	@FindBy(xpath="(//tr[@class=\"odd\"])[1]//a")
	public WebElement patient;
	@FindBy(xpath="//div[@class=\"toast-message\"]/p")
	public WebElement nameError;

	@FindBy(xpath="//div[@class=\"btn-group bootstrap-select language\"]")
	public WebElement lan;
	@FindBy(xpath="//ul[@class=\"dropdown-menu inner selectpicker\"]//li[5]")
	public WebElement eng;
	
	@FindBy(xpath="//input[@id=\"custom_fields[patient][11]\"]")
	public WebElement uhid;
	
	 public void login() {
	        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(doctor)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(signin)).click();
	    }
	    //switch the language to English
	    public void english() {
	        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//	        log.info("Switching language to English");
	        wait.until(ExpectedConditions.elementToBeClickable(lan)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(eng)).click();
	    }
	    public void appointment() {
	        clickMethod(appointment);
//	        log.info("Navigated to Appointment section");
	    }
	    public void addAppointment() {
	        clickMethod(addAppointment);
//	        log.info("Clicked on Add Appointment");
	    }
	    //Add Patient Details
	    public void addPatient() {
	        clickMethod(addpatient);
//	        log.info("Clicked on Add Patient");
	    }
	    public void save() {
	        clickMethod(saveBtn);
//	        log.info("Clicked Save Patient button");
	    }
	public void addPatientDetailsFromData(String patientName, String genderValue, String yearValue, String monthValue, String dayValue, String bloodGroupValue) {
	    sendKeysMethod(pName, patientName);
	    new Select(gender).selectByVisibleText(genderValue);
	    sendKeysMethod(year, yearValue);
	    sendKeysMethod(month, monthValue);
	    sendKeysMethod(day, dayValue);

	    if (bloodGroupValue != null && !bloodGroupValue.isEmpty()) {
	        new Select(bloodGroup).selectByVisibleText(bloodGroupValue);
	    }
	    File file = new File("src//test//resources//patient.jpg");
	    uploadPhoto.sendKeys(file.getAbsolutePath());
	}
	private void sendKeysMethod(WebElement element, String value) {
	    element.clear();
	    element.sendKeys(value);
	}
	public void clickMethod(WebElement ele) {
		ele.click();
	}
	public void nameRequired(String ex) {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement=wait.until(ExpectedConditions.visibilityOf(nameError));
        String ac=errorElement.getText();
        //log.info("Checking name required validation. Expected: {}, Actual: {}", ex, ac);
        Assert.assertEquals(ac, ex);
    }

}

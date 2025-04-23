package com.Tests;
import org.testng.annotations.Test;
import com.Pages.DoctorPage;
import com.Utils.DoctorDataProvider;
public class DoctorTest extends BaseTest{
    @Test(dataProvider = "patientData", dataProviderClass = DoctorDataProvider.class)
    public void testAddPatient(String name, String gender, String year, String month, String day, String bloodGroup,String test) throws InterruptedException {
    	DoctorPage doctor = new DoctorPage(getDriver());
        doctor.login();
        doctor.english();
        doctor.appointment();
        doctor.addAppointment();
        doctor.addPatient();
        doctor.addPatientDetailsFromData(name, gender, year, month, day, bloodGroup);
        doctor.save();
        if(test.equals("TestCase2")) {
        	doctor.nameRequired("Name field is required");
        }
        else if(test.equals("TestCase3")) {
        	doctor.nameRequired("Year field is required");
        }
        else if(test.equals("TestCase4")) {
        	doctor.nameRequired("Month field is required");
        }
        else if(test.equals("TestCase5")) {
        	doctor.nameRequired("Day field is required");
        }
    }
}


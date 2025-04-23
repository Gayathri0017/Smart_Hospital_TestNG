package com.Tests;

import com.Pages.DischargePage;
import com.Utilities.DataProviding;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DischargeTest extends BaseTest {
    


    @Test(priority = 1)
    public void DischargeWithoutDate() {
    	DischargePage dischargePage = new DischargePage(getDriver());
    	dischargePage.login();
    	dischargePage.english();
        dischargePage.clickIPD();
        dischargePage.clickFirstPatient();
        dischargePage.clickDischargeBtn();
        dischargePage.setDischargeStatus("Normal");
        dischargePage.clickDischargeSaveBtn();
        Assert.assertTrue(dischargePage.getError().contains("Discharge Date field is required"));
    }

    @Test(priority = 2)
    public void DischargeWithoutStatus() {
    	DischargePage dischargePage = new DischargePage(getDriver());
    	dischargePage.login();
    	dischargePage.english();
        dischargePage.clickIPD();
        dischargePage.clickFirstPatient();
        dischargePage.clickDischargeBtn();
        dischargePage.setDischargeDate();
        dischargePage.clickDischargeSaveBtn();
        Assert.assertTrue(dischargePage.getError().contains("Discharge Status field is required"));
    }


    @Test(priority = 3, dataProvider="caseIdData", dataProviderClass = DataProviding.class)
    public void DischargeWithCaseId(String caseId) throws InterruptedException {
    	DischargePage dischargePage = new DischargePage(getDriver());
    	dischargePage.login();
    	dischargePage.english();
        dischargePage.clickIPD();
        dischargePage.setCaseId(caseId);
        Thread.sleep(3000);
        if(dischargePage.NodataAvailable.isDisplayed()) {
        	System.out.println(dischargePage.getNoDataAvail());
        }
        else {
        	dischargePage.clickFirstPatient();
            dischargePage.clickDischargeBtn();
            dischargePage.setDischargeDate();
            dischargePage.setDischargeStatus("Normal");
            dischargePage.clickDischargeSaveBtn();
            System.out.println(dischargePage.getpatientID());
        }
        
    }
}
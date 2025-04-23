package com.Utils;
import org.testng.annotations.DataProvider;
public class DoctorDataProvider {
    @DataProvider(name = "patientData")
    public Object[][] patientData() {
        return new Object[][] {
            {"Arav", "Female", "28", "5", "12", "A+","TestCase1"},
            //{"Bob Johnson", "Male", "35", "10", "20", "O-"},
            {"", "Male", "25", "6", "15", "B+","TestCase2"},
            {"Charlie", "Male", "", "7", "21", "AB-","TestCase3"},
            {"Dharu", "Female", "30", "", "10", "A-","TestCase4"},
            {"Elan", "Male", "40", "8", "", "B+","TestCase5"},   
            //{"Frank", "Male", "45", "9", "13", "O+"}
        };
    }

}

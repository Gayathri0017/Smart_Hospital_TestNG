package com.Utilities;

import org.testng.annotations.DataProvider;

public class DataProviding {
	@DataProvider(name = "caseIdData")
    public Object[][] provideCaseIdData() {
        return new Object[][] {  {"5891"},{"5456"} };
    }
}

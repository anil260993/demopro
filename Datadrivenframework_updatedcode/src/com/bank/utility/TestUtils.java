package com.bank.utility;
import java.io.File;
import java.lang.reflect.Method;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.bank.base.*;
import com.bank.properties.Constant_info;

public class TestUtils extends Baseclass{
	
	
	//to fill data from excel code
	
	@DataProvider(name="dp")
	public static Object[][] getData(Method m) {
		
		String sheetName= m.getName();
		int rows=excel.getRowCount(sheetName);
		int cols=excel.getColumnCount(sheetName);
		 
	Object [][] data=new Object[rows-1][cols];
	for(int rowNum=2;rowNum<=rows;rowNum++) {
		for(int colNum=0;colNum<cols;colNum++) {
			
			data[rowNum-2][colNum]=excel.getCellData(sheetName,colNum,rowNum);
			
		}
	}
return data;
	
	}
	
	
	//to run classes by passing class names in excel
	
	public static boolean isTestRunnable(String testName,ExcelReader excel) {
		String SheetName="Testsuit";
		int row=excel.getRowCount(SheetName);
		for(int rNum=2;rNum<=row;rNum++) {
			String testcase=excel.getCellData(SheetName,"TCID", rNum);
			if(testcase.equalsIgnoreCase(testName)) {
				String runmode=excel.getCellData(SheetName,"Runmode", rNum);
				if(runmode.equalsIgnoreCase("Y")) 
					return true;
				else
					return false;
				
			}
			
		}
		return false;
		
	}
	
	
	

}

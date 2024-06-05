package Magento_Testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Magento_PageObject.Magento_SigninPage;
import Magento_Utilities.ExcelReading;

public class Magento_Datadriven {
	@Test(dataProvider="SampleExcel")
	public void datadriventest(String email,String Password) {
		
		WebDriver driver = null;
		Magento_SigninPage lp=new Magento_SigninPage(driver);
		
		lp.setEmail(email);
		lp.setPassword(Password);
		lp.ClickSignin();
	}
	@DataProvider(name="SampleExcel")
	String [][] getData() throws IOException{
		
		String path="E:\\Maven\\Excel Book.xlsx";
		
		//it is identify the rowcount
		int rownum=ExcelReading.getRowCount(path, "Sheet1");
		//identify the colcount
		int colcount=ExcelReading.getCellcount(path, "Sheet1", 1);
		
		String Signindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {//it is represents rows
			
			for(int j=0;j<colcount;j++) {//it is represents the columns
				
				Signindata[i-1][j]=ExcelReading.getcelldata(path, "Sheet1", i, j);//1,0
			}
			
		}
		return Signindata;
	}


}

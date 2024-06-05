package Magento_Testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Magento_BaseClass {
	Magento_Utilities.ReadingData rd=new Magento_Utilities.ReadingData();

	public String AppURL=rd.getAppURL();
	public String Email=rd.getEmail1();
	public String Password=rd.getPassword();

	public static WebDriver driver;
	public static Logger log;
	@BeforeClass
	public void openApp() {

		driver=new ChromeDriver();

		driver.get(AppURL);
		driver.manage().window().maximize();

		log=Logger.getLogger(driver.getClass());
		PropertyConfigurator.configure("log4j.properties");
	}


	@AfterClass
	public void closeApp() {

		driver.close();
	}

	//create capture screenshot method in baseclass

	public String captureScreen(String Email1) throws IOException {
		String timeStamp=new SimpleDateFormat("dd.MM.yyyy.hh.mm.ss").format(new Date());

		TakesScreenshot ts=(TakesScreenshot)driver;

		File src=ts.getScreenshotAs(OutputType.FILE);

		//system.getProperty("user.dir")
		String target=(System.getProperty("user.dir")+"\\Screenshots\\"+Email1+"_"+timeStamp+".png");

		try {
			FileUtils.copyFile(src, new File(target));
		}catch(Exception e) {
			e.printStackTrace();
		}

		log.info("screenshot is taken");
		return target;
	}



}

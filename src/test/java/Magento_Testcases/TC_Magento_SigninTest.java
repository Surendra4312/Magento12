package Magento_Testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import Magento_PageObject.Magento_SigninPage;
import junit.framework.Assert;



public class TC_Magento_SigninTest extends Magento_BaseClass{
		@Test
		public void SigninTest() throws IOException {
			
			Magento_SigninPage MB=new Magento_SigninPage(driver);
			
			MB.setEmail("Email");
			log.info("Email is entered");
			
			MB.setPassword(Password);
			log.info("password is entered");
			MB.ClickSignin();
			log.info("signin btn clicking activity is completed");
		
		String  Act_title=driver.getTitle();
		String Exp_title="Magento.com";
		
		if(Act_title.equals(Exp_title)) {
			
			Assert.assertTrue(true);
			log.info("testcase is passed");
		}else {
			
			captureScreen("SigninTest");
			Assert.assertTrue(false);
			log.info("testcase is failed");
		}
	}

}

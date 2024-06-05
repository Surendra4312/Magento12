package Magento_Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadingData {
	Properties pro;
	public  ReadingData() {
		
		File f=new File("E:\\FrameWorks\\Magento\\Configuration\\Data.Properties");
	
		try {
			//it is converted into reading mode
			FileInputStream fis=new FileInputStream(f);
			pro=new Properties();
			pro.load(fis);//load the file input stream
		}catch(Exception e) {
			e.printStackTrace();//it is provide the proper information about exception,which line of code getting error 
		}
	
		
	
	}
	
	public String getAppURL() { //get the application url
		
		String url=pro.getProperty("appURL");
		return url;
	}
	
	public String getEmail1() {//get the username
		
		String Email=pro.getProperty("Email");
		return Email;
	}
	
	public String getPassword() {
		
		String pword=pro.getProperty("password");
		return pword;
				
	}

	
	

}

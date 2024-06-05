package Magento_PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Magento_SigninPage {
	WebDriver driver;
	public Magento_SigninPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@name='login[password]']")
	WebElement txtPassword;
	
	@FindBy(xpath="//button[@class='action login primary']")
	WebElement btnsignin;
	
	
	//create the corresponding actions
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void ClickSignin() {
		btnsignin.click();
	}


}

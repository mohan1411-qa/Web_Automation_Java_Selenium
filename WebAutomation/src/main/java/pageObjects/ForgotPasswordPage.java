package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import resource.Base;


public class ForgotPasswordPage {
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	By forgotpassworbuttonlink = By.xpath("//a[contains(text(),'Forgot your password?')]");
	By resetPasswordButton = By.id("btnSearchValues");
	
	public ForgotPasswordPage(WebDriver driver) {
		
		this.driver = driver;
	}

	public void click_on_forgot_password_link() {
		
		log.info("Clicking on forgot password link button");
		driver.findElement(forgotpassworbuttonlink).click();
	}
	
	public boolean verify_forgot_password_page() {
		
		log.info("Verifying forgot password page");
		return driver.findElement(resetPasswordButton).isDisplayed();
		
	}
	
	
}

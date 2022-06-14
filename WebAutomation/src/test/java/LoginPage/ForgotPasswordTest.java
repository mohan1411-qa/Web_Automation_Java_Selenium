package LoginPage;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.ForgotPasswordPage;
import resource.Base;

public class ForgotPasswordTest extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	
	@BeforeTest
	public void setup() throws IOException {
		
		driver = initializeDriver();
		log.info("Driver Initialised");
		
	}
	
	@AfterTest
	public void teardown() {
		log.info("Closing the browser");
		driver.close();
	}
	

	@Test
	public void forgotpasswordValidation() throws IOException{
		ForgotPasswordPage fp = new ForgotPasswordPage(driver);
		
		fp.click_on_forgot_password_link();
		fp.verify_forgot_password_page();
		
		boolean actualResult = fp.verify_forgot_password_page();
		System.out.println(actualResult);
		log.info(actualResult);
		Assert.assertEquals(actualResult, false);
		driver.close();
		
	}
	
	
	
}

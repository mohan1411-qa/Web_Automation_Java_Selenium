package LoginPage;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resource.Base;

public class LoginPageTest extends Base {
	public WebDriver driver;
	//public static Logger log = LogManager.getLogger(Base.class.getName());
	
	
	@BeforeTest
	public void setup() throws IOException {
		
		driver = initializeDriver();
		
		//log.info("Driver Initialised");
		
	}
	
	@AfterTest
	public void teardown() {
		
		driver.close();
	}
	
	@Test(dataProvider="get_invalid_credentials")
	public void InvalidLoginCredentials(String username, String password) throws IOException{
			
			LoginPage lp = new LoginPage(driver);
			lp.enter_user_name(username);
			//log.info("Entered Username");
			
			lp.enter_password(password);
			//log.info("Entered Password");
			
			lp.click_on_login();
			
			boolean actualResult = lp.verify_invalid_error_mssg();
			System.out.println(actualResult);
			Assert.assertEquals(actualResult, true);
			//log.info("Login Successfully");
			
			
		}
	
	@Test
	public void LoginPageValidation() throws IOException{
		LoginPage lp = new LoginPage(driver);
		
		lp.enter_user_name("Admin");
		//log.info("Entered Username");
		
		lp.enter_password("admin123");
		//log.info("Entered Password");
		
		
		lp.click_on_login();
		//log.info("Login Successfully");
		
		boolean actualResult = lp.verify_login_navigation();
		System.out.println(actualResult);
		Assert.assertEquals(actualResult, true);
		driver.close();
		
		
	}
	
	@DataProvider
	public Object[][] get_invalid_credentials()
	{
		Object[][] data = new Object[3][2];
		data[0][0]  = "abc@gmail.com";
		data[0][1]  = "pass";
		
		data[1][0]  = "dsdas";
		data[1][1]  = "212sasa";

		data[2][0]  = " ";
		data[2][1]  = "admin123";
		
		return data;
	}
	
	
}

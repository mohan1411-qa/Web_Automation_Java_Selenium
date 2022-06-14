package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	public WebDriver driver;
	
	
	By UserNameTextField = By.id("txtUsername");
	By PasswordTextField = By.id("txtPassword");
	By LoginButton = By.id("btnLogin");
	By PageTitle = By.xpath("//a[@href='http://www.orangehrm.com/']");
	By errorMssg = By.id("spanMessage");
	
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
	}

	public void enter_user_name(String username) {
		
		driver.findElement(UserNameTextField).sendKeys(username);
		
	}
	
	public void enter_password(String password) {
		
		driver.findElement(PasswordTextField).sendKeys(password);
		
	}
	
	public void click_on_login() {
		
		driver.findElement(LoginButton).click();
		
	}
	
	public boolean verify_login_navigation() {
		
		return driver.findElement(PageTitle).isDisplayed();
		
	}
	
public boolean verify_invalid_error_mssg() {
		
		return driver.findElement(errorMssg).isDisplayed();
		
	}
}

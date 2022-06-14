package resource;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Base {

	public WebDriver driver;
	
	@SuppressWarnings("deprecation")
	public WebDriver initializeDriver() throws IOException {
		
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("E:\\Projects\\Java Projects\\JavaSeleniumWebAutomation\\WebAutomation\\src\\main\\java\\resource\\data.properties");
		
		prop.load(fis);
		String browser_name= prop.getProperty("browser");
		String web_url= prop.getProperty("url");
		
		if (browser_name.equals("chrome")){
			
			System.out.println("Chrome Driver Invoked");
			System.setProperty("webdriver.chrome.driver","E:\\Projects\\Java Projects\\Drivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();

		}
		
		else if (browser_name.equals("firefox")){
			
			System.out.println("FireFox Driver Invoked");
			
			driver = new FirefoxDriver();
			
			
	}
		else if (browser_name.equals("safari")){
			System.out.println("Safari Driver Invoked");
			
			driver = new SafariDriver();
			
		}
		else if (browser_name.equals("IE")){
			System.out.println("IE Driver Invoked");
			
			driver = new InternetExplorerDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(web_url);
		return driver;
		
	}
	
	public String getScreenshot(String TestCaseName, WebDriver driver) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination =System.getProperty("user.dir")+"\\reports\\"+TestCaseName+".png";
		System.out.println(destination);
		FileUtils.copyFile(source, new File(destination));
	

		return	destination;
		
	}
	}

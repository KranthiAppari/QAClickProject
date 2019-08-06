package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	
	public static WebDriver driver;
	public static Properties prop;

	//Define a method to initialize the properties file
	public WebDriver initializeProperties() throws IOException {
		System.out.println("Inside base class");
		//prop = new Properties();
		//FileInputStream fis=new FileInputStream("QAClickAcademyAutomation/src/main/java/Resources/dataProperties.properties");
		//prop.load(fis);
		
		
		prop= new Properties();
		FileInputStream fis=new FileInputStream("/E2EProject/src/main/java/Resources/data.properties");
		prop.load(fis);
	
		String browser=prop.getProperty("browser");
		String url=prop.getProperty("url");
		
		if(browser.equals("chrome")) {
			//WebDriver uses native browser approach. Selenium offers inbuilt driver for Firefox but not for other browsers. All drivers (Chrome Driver, IE driver, etc.) are built based on the systemproperty 
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			driver= new ChromeDriver();
			
		}else if(browser.contentEquals("firefox")) {
			
			driver=new FirefoxDriver(); //WebDriver is an interface, driver is a reference variable, FirefoxDriver() is a Constructor, new is a keyword, and new FirefoxDriver() is an Object
			
		}
		
				
		return driver;
		
	}
}

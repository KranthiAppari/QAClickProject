package PageObjectFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class landingHomePage{
	
	WebDriver driver;
	
	
	//By Register=By.xpath("//span[text()='Register']");
	
	public landingHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement Register() {
		return driver.findElement(By.xpath("//span[text()='Register']"));
	}
	
	public WebElement Login() {
		return driver.findElement(By.xpath("//span[text()='Login']"));
	}
	public WebElement Courses() {
		return driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']//a[text()='Courses']"));
	}
	public WebElement Videos() {
		return driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']//a[text()='Videos']"));
	}
	public WebElement Interviewguide() {
		return driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']//a[text()='Interview guide']"));
	}
	public WebElement Practice() {
		return driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']//a[text()='Practice']"));
	}
	public WebElement Contact() {
		return driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']//a[text()='Contact']"));
	}
	public WebElement FeaturedCourses() {
		return driver.findElement(By.xpath("//div[@class='text-center']//h2[text()='Featured Courses']"));
	}
	public int PopupSize() {
		return driver.findElements(By.xpath("//button[text()='NO THANKS']")).size();
	}
	public WebElement Popup() {
		return driver.findElement(By.xpath("//button[text()='NO THANKS']"));
	}
}

package PageObjectFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	WebDriver driver;
	
	public loginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public WebElement EmailAddress() {
		return driver.findElement(By.id("user_email"));
	}
	public WebElement Password() {
		return driver.findElement(By.id("user_password"));
	}
	public WebElement Login() {
		return driver.findElement(By.xpath("//input[@type='submit']"));
	}
	public WebElement ForgotPassword() {
		return driver.findElement(By.xpath("//a[@class='link-below-button']"));
	}
	public WebElement CreateAccount() {
		return driver.findElement(By.xpath("//div[@class='box-footer']//a[text()='Create an Account']"));
	}
	public WebElement InvalidLogin() {
		return driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
	}
	
}

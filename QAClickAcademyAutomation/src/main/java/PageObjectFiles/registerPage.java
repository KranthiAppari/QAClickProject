package PageObjectFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class registerPage {
	
	WebDriver driver;
	
	public registerPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public WebElement SignupText() {
		return driver.findElement(By.xpath("//div[@class='content-box content-box-school-signup']//h1[text()='Sign Up to QaClickAcademy']"));
	}
	public WebElement Name() {
		return driver.findElement(By.id("user_name"));
	}
	public WebElement Email() {
		return driver.findElement(By.id("user_email"));
	}
	public WebElement Password() {
		return driver.findElement(By.id("user_password"));
	}
	public WebElement ConfirmPassword() {
		return driver.findElement(By.id("user_password_confirmation"));
	}
	public WebElement Checkbox1() {
		return driver.findElement(By.id("user_unsubscribe_from_marketing_emails"));
	}
	public WebElement Checkbox2() {
		return driver.findElement(By.id("user_agreed_to_terms"));
	}
	public WebElement Submit() {
		return driver.findElement(By.name("commit"));
	}
	
}

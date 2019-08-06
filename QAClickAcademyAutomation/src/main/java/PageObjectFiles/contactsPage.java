package PageObjectFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class contactsPage {
	
	WebDriver driver;
	
	public contactsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public WebElement contactForm() {
		return driver.findElement(By.xpath("//div[@class='text-center']//h1[text()='Contact Form']"));
	}
	public WebElement Name() {
		return driver.findElement(By.id("contact-input-name"));
	}
	public WebElement MobileNumber() {
		return driver.findElement(By.id("contact-input-mobile"));
	}
	public WebElement Country() {
		return driver.findElement(By.id("contact-input-country"));
	}
	public WebElement Email() {
		return driver.findElement(By.id("contact-input-email"));
	}
	public WebElement Subject() {
		return driver.findElement(By.id("contact-input-subject"));
	}
	public WebElement Description() {
		return driver.findElement(By.id("contact-input-message"));
	}
	public WebElement Submit() {
		return driver.findElement(By.cssSelector("button[class='btn btn-primary']"));
	}
}

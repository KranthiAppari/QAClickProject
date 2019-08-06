package QAClickAcademy.QAClickAcademyAutomation;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.base;
import PageObjectFiles.landingHomePage;

public class landingHomePage_Test extends base{
	
	@BeforeTest
	public void initialization() throws IOException {
		driver=initializeProperties();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void landingHomePage_Test() throws IOException, InterruptedException{
		
		landingHomePage lhp=new landingHomePage(driver);
		if(lhp.PopupSize()>0) {
			lhp.Popup().click();
			assertEquals(lhp.FeaturedCourses().getText(), "FEATURED COURSES");
			assertTrue(lhp.Courses().isDisplayed());
		}
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}

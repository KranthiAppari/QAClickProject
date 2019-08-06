package StepDefinitionPackage;

import PageObjectFiles.contactsPage;
import PageObjectFiles.landingHomePage;
import Resources.base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitionContacts extends base {
	
	
	@Given("^Navigate to the Contacts Page$")
	public void navigate_to_the_Contacts_Page() throws Throwable {
		 	driver=initializeProperties();
			driver.get(prop.getProperty("url"));
			
			landingHomePage lhp=new landingHomePage(driver);
			if(lhp.PopupSize()>0) {
				lhp.Popup().click();
			}
			lhp.Contact().click();
	    
	}

	@When("^Enter Name, MobileNumber, Country, Email,Subjet, Description$")
	public void enter_Name_MobileNumber_Country_Email_Subjet_Description() throws Throwable {
		
		contactsPage cp=new contactsPage(driver);
		cp.Name().sendKeys("Namee");
		cp.MobileNumber().sendKeys("98765432");
		cp.Country().sendKeys("India");
		cp.Email().sendKeys("abc@yahoo.com");
		cp.Subject().sendKeys("Enquiry");
		cp.Description().sendKeys("Enquiry about the course");
	   
	}

	@Then("^Enter Submit$")
	public void enter_Submit() throws Throwable {
		contactsPage cp=new contactsPage(driver);
	   cp.Submit().click();
	}



}

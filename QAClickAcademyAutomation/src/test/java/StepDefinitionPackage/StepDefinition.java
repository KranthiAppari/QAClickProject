package StepDefinitionPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import PageObjectFiles.landingHomePage;
import PageObjectFiles.loginPage;
import Resources.SQLConnection;
import Resources.base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition extends base{
	
	
	@Given("^Navigate to the Login Page$")
	public void navigate_to_the_Login_Page() throws Throwable {
	   System.out.println("Given");
	   driver=initializeProperties();
		driver.get(prop.getProperty("url"));
		
		landingHomePage lhp=new landingHomePage(driver);
		if(lhp.PopupSize()>0) {
			lhp.Popup().click();
		}
		lhp.Login().click();
	}

	@When("^Enter Email and Password from the Database$")
	public void enter_Email_and_Password_from_the_Database() throws Throwable {
		landingHomePage lhp=new landingHomePage(driver);
		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QAClickAcademyDB;user=sa123;password=sa123";
		Connection connection = DriverManager.getConnection(connectionUrl);
		String SQL="select * from Register";
		Statement stmt=connection.createStatement();
		ResultSet rs=stmt.executeQuery(SQL);
		rs.next();
			String Email=rs.getString("Email");
			String password=rs.getString("Password");
		//	lhp.Login().click();
			
			loginPage lp=new loginPage(driver);
			lp.EmailAddress().sendKeys(rs.getString("Email"));
			lp.Password().sendKeys(rs.getString("Password"));
	}

	@Then("^Enter Login$")
	public void enter_Login() throws Throwable {
		loginPage lp=new loginPage(driver);
		lp.Login().click();
	}

	@Then("^Navigate to the successful page$")
	public void navigate_to_the_successful_page() throws Throwable {
		
		landingHomePage lhp=new landingHomePage(driver);
		
		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QAClickAcademyDB;user=sa123;password=sa123";
		Connection connection = DriverManager.getConnection(connectionUrl);
		String SQL="select * from Register";
		Statement stmt=connection.createStatement();
		ResultSet rs=stmt.executeQuery(SQL);
		rs.next();
			String Email=rs.getString("Email");
			String password=rs.getString("Password");
			
			
		String SQL1="Select count(*) as count from Register where Email='"+Email+"' and Password='"+password+"' ";
		System.out.println("SQL: "+SQL1);
		Statement stmt1=connection.createStatement();
		ResultSet rs1=stmt1.executeQuery(SQL1);
		rs1.next();
		int count=rs1.getRow();
		if(count>0) {
			System.out.println("Count: "+count);
			driver.get("https://qaclickacademy.usefedora.com/");
		}
	   
	}
	
	@Then("^close the Browser$")
	public void close_the_Browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.quit();
	}


	
}


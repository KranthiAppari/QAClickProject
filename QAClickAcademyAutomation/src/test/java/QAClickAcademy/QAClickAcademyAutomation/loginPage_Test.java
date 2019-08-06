package QAClickAcademy.QAClickAcademyAutomation;


import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjectFiles.landingHomePage;
import PageObjectFiles.loginPage;
import Resources.base;

public class loginPage_Test extends base{
	
	//@BeforeTest
	public void initialization() throws IOException {
		driver=initializeProperties();
		//driver.get(prop.getProperty("url"));
	}
	
	@Test (dataProvider="getData")
	public void loginPage(String username, String password) throws IOException {
		driver=initializeProperties();
		driver.get(prop.getProperty("url"));
		
		landingHomePage lhp=new landingHomePage(driver);
		if(lhp.PopupSize()>0) {
			lhp.Popup().click();
		}
		lhp.Login().click();
		
		loginPage lp=new loginPage(driver);
		lp.EmailAddress().sendKeys(username);
		lp.Password().sendKeys(password);
		lp.Login().click();

		//System.out.println(lp.InvalidLogin().getText());
		
	}
	
	//@Test
	public void loginPagefromDB() throws IOException, SQLException {
		driver=initializeProperties();
		driver.get(prop.getProperty("url"));
		
		landingHomePage lhp=new landingHomePage(driver);
		if(lhp.PopupSize()>0) {
			lhp.Popup().click();
		}
		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QAClickAcademyDB;user=sa123;password=sa123";
		Connection connection = DriverManager.getConnection(connectionUrl);
		String SQL="select * from Register";
		Statement stmt=connection.createStatement();
		ResultSet rs=stmt.executeQuery(SQL);
		rs.next();
			String Email=rs.getString("Email");
			String password=rs.getString("Password");
			lhp.Login().click();
			
			loginPage lp=new loginPage(driver);
			lp.EmailAddress().sendKeys(rs.getString("Email"));
			lp.Password().sendKeys(rs.getString("Password"));
			lp.Login().click();
	
			System.out.println(lp.InvalidLogin().getText());
			
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
	
	//@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[1][2]; //for 2 sets of data with 2 columns
		
		data[0][0]="kranthi_j@yahoo.com";
		data[0][1]="kranthi";
		
		return data;
	
	}

}

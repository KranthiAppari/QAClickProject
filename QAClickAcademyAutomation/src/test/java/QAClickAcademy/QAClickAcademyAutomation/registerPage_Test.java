package QAClickAcademy.QAClickAcademyAutomation;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import PageObjectFiles.landingHomePage;
import PageObjectFiles.registerPage;

public class registerPage_Test extends base{
	
	@BeforeTest
	public void initialization() throws IOException {
		driver=initializeProperties();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void registerPage_Test() throws SQLException {
				
		landingHomePage lhp=new landingHomePage(driver);
		if(lhp.PopupSize()>0) {
			lhp.Popup().click();
		}
		lhp.Register().click();
		registerPage rp=new registerPage(driver);
		
		rp.Name().sendKeys("KKKKKKK");
		rp.Email().sendKeys("kk@yahoo.com");
		rp.Password().sendKeys("passs");
		rp.ConfirmPassword().sendKeys("passs");
		assertEquals(rp.Password().getText(),rp.ConfirmPassword().getText());
		rp.Checkbox2().click();
		
		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QAClickAcademyDB;user=sa123;password=sa123";
		Connection connection = DriverManager.getConnection(connectionUrl);
		
		String SQL="insert into Register(Name,Email,Password) values (?,?,?)";
		//Statement stmt=connection.createStatement();
		PreparedStatement pst=connection.prepareStatement(SQL);
		pst.setString(1, "KKKKKKK");
		pst.setString(2, "kk@yahoo.com");
		pst.setString(3, "passs");
		
		//ResultSet rs=stmt.executeQuery(SQL);
		pst.execute();
		
		
		
		}
	
	
	//@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[1][1]; //for 2 sets of data with 2 columns
		
		data[0][0]="appari@gmail.com";
		data[0][1]="apparipassword";
		
		data[1][0]="krans@yahoo.com";
		data[1][1]="kransy";
		
		return data;
	
	}
	
	
	

}

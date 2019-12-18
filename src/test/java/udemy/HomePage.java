package udemy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {

		dr = initializeDriver();
		dr.get(prop.getProperty("url"));
		LandingPage lp = new LandingPage(dr);
		lp.getLoginBtn().click();

	}

	@Test(dataProvider = "getData")
	public void loginPageTest(String userName, String password) throws IOException {
		/* two ways of calling methods from another class */

//		one is inheritance
//		dr = initializeDriver();
//		dr.get(prop.getProperty("url"));

//		two is creating object to that class and invoke methods of it
//		LandingPage lp = new LandingPage(dr);
//		lp.getLoginBtn().click();

		LoginPage lgn = new LoginPage(dr);
		lgn.getEmail().sendKeys(userName);
		lgn.getPassword().sendKeys(password);
		log.info("password keys sent");

		lgn.getLogin().click();
		lgn.getEmail().clear();
		lgn.getPassword().clear();
	}

	@DataProvider
	public Object[][] getData() {
		// row stand for how many diff data types
		// column stands for how many values per each test

		// Array size 5 - means 0,1,2,3,4
		Object[][] data = new Object[2][2];
		data[0][0] = "nonerestricteduser@qw.com";
		data[0][1] = "123456";

		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "456789";

		return data;
	}

	@AfterTest
	public void tearDown() {
		dr.close();
		dr = null;
	}

}

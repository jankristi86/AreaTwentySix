package udemy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import resources.Base;

public class ValidateNavBar extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		dr = initializeDriver();
		dr.get(prop.getProperty("url"));
	}

	@Test
	public void validateNavBarTest() throws IOException {

		LandingPage lp = new LandingPage(dr);
		Assert.assertTrue(lp.getNavBar().isDisplayed());
		log.info("Navigation bar is displayed");

	}

	@AfterTest
	public void tearDown() {
		dr.close();
		dr=null;
	}

}

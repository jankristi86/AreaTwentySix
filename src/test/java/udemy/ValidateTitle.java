package udemy;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import resources.Base;
import org.apache.logging.log4j.*;

public class ValidateTitle extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	LandingPage lp;

	@BeforeTest
	public void initialize() throws IOException {
		dr = initializeDriver();
		log.info("driver is initialized");
		dr.get(prop.getProperty("url"));
		log.info("navigated to Home Page");

	}

	@Test
	public void validateTitleTest() throws IOException {

		lp = new LandingPage(dr);

		// compare text from the webpage is with actual text
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");
		log.info("successfully validated featured courses text");

	}

	@Test
	public void validateHeader() throws IOException {

		lp = new LandingPage(dr);

		// compare text from the webpage is with actual text
		Assert.assertEquals(lp.getHeaderText().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("successfully validated header text");

	}

	@AfterTest
	public void tearDown() {
		dr.close();
		dr = null;
	}
}

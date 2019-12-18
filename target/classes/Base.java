package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

public class Base {

	public WebDriver dr;
	public Properties prop;

	// method to initializeDriver on different browsers
	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		// section 27 - 212.generating paths dynamically -//
		// System.getProperty("user.dir") -getting path of the project, on any other
		// machine
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);

		// section 27 - 209. good practise optimization
		// mvn test -D (d means we are sending parameter and value
		// mvn test -Dbrowser=chrome
		// instead from data.properties we take from maven (system.getproperty)

		//String browserName = System.getProperty("browser");
		String browserName = prop.getProperty("browser");

		// if we are extracting value(chrome) from property(browser) we cannot write ==,
		// but equals()
		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");

			// section27-213.chromeheadless
			ChromeOptions options = new ChromeOptions();
			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}
		dr = new ChromeDriver(options);

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\geckodriver.exe");
			dr = new FirefoxDriver();

		} else if (browserName.equals("ie")) {
			dr = new InternetExplorerDriver();
		}
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return dr;
	}

	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);

		FileHandler.copy(src, new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\failureScreenshot\\" + result + "screenshot.png"));

	}

}

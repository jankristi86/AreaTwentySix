package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver dr;
	private By signIn = By.cssSelector("a[href*='sign_in']");
	private By title = By.cssSelector(".text-center>h2");
	private By navBar = By.cssSelector(".nav.navbar-nav.navbar-right");
	private By headerText = By.cssSelector("div[class*='video-banner'] h3");

	// creating constructor and assigning life to dr object.
	public LandingPage(WebDriver dr) {
		this.dr = dr;
	}

	public WebElement getLoginBtn() {
		return dr.findElement(signIn);
	}

	public WebElement getTitle() {
		return dr.findElement(title);
	}

	public WebElement getNavBar() {
		return dr.findElement(navBar);
	}

	public WebElement getHeaderText() {
		return dr.findElement(headerText);
	}

}

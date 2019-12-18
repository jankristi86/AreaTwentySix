package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver dr;
	private By email = By.cssSelector("[id='user_email']");
	private By password = By.cssSelector("[type='password']");
	private By submit = By.cssSelector("[type='submit']");

	// creating constructor and assigning life to dr object.
	public LoginPage(WebDriver dr) {
		this.dr = dr;
	}

	public WebElement getEmail() {
		return dr.findElement(email);
	}

	public WebElement getPassword() {
		return dr.findElement(password);
	}

	public WebElement getLogin() {
		return dr.findElement(submit);
	}

}

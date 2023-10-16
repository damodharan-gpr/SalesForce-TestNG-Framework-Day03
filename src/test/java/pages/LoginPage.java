package pages;

import org.openqa.selenium.By;

import Base.BaseClass;

public class LoginPage extends BaseClass {

	private By userName = By.id("username");
	private By password = By.id("password");
	private By click = By.id("Login");
	
	public boolean verifyElementInLogInPage() {
		if (driver.findElement(userName).isDisplayed() &&
			driver.findElement(password).isDisplayed() &&
			driver.findElement(click).isDisplayed()) {
		return true;
		}else {
			return false;
		}
	}
	
	public LoginPage userName() {
		driver.findElement(userName).sendKeys("damo@tcs.sandbox");
		return this;
	}
	
	public LoginPage userPassword() {
		driver.findElement(password).sendKeys("Kity@1517");
		return this;
	}
	
	public HomePage submitButton() {
		driver.findElement(click).click();
		return new HomePage();
	}
}

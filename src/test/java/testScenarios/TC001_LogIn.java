package testScenarios;

import org.testng.annotations.Test;
import org.testng.Assert;

import Base.BaseClass;
import pages.HomePage;
import pages.LoginPage;

public class TC001_LogIn extends BaseClass {
	
	@Test(priority = 1)
	public void loginVerify() {
		boolean verifyLogInPage = new LoginPage().verifyElementInLogInPage();
		Assert.assertTrue(verifyLogInPage);
	}
	
	@Test(priority = 2)
	public void userLogin() {
		boolean verifyHomePage = new LoginPage()
		.userName()
		.userPassword()
		.submitButton()
		.verifyElementsInHomePage();
		Assert.assertTrue(verifyHomePage);
	}
	
	@Test(priority = 3)
	public void userLogOut() throws Exception {
		boolean verifyElementInLogInPage = new HomePage()
		.clickLogOutIcon()
		.clickLogOut()
		.verifyElementInLogInPage();
		Assert.assertTrue(verifyElementInLogInPage);
	}
}

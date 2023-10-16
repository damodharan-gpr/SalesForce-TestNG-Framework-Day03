package testScenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
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

}

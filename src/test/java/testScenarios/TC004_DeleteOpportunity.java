package testScenarios;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseClass;

import org.testng.Assert;

import pages.HomePage;
import pages.LoginPage;

public class TC004_DeleteOpportunity extends BaseClass {
	
	@BeforeTest
	public void testingSetup() {
		excelFileName = "TC004";
	}
	
	@Test(priority = 1)
	public void userLogin() throws Exception {
		boolean verifyHomePage = new LoginPage()
		.userName()
		.userPassword()
		.submitButton()
		.selectAppLauncher()
		.clickViewAll()
		.clickScales()
		.clickOpportunityTab()
		.verifyElementsInHomePage();
		Assert.assertTrue(verifyHomePage);
	}
	
	@Test(priority = 2, dataProvider = "SearchName")
	public void toDeleteOpporunity(String searchOpporunityName) throws Exception {
		new HomePage()
		.selectDeleteOpporunity(searchOpporunityName)
		.selectDeleteDropDown()
		.selectDelete()
		.selectConfirmDelete();
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

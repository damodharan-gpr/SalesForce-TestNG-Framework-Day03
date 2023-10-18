package testScenarios;

import org.testng.annotations.Test;

import Base.BaseClass;

import org.testng.Assert;

import pages.HomePage;
import pages.LoginPage;

public class TC002_CreateOpportunity extends BaseClass {
	
	@Test(priority = 1)
	public void userLogin() {
		boolean verifyHomePage = new LoginPage()
		.userName()
		.userPassword()
		.submitButton()
		.verifyElementsInHomePage();
		Assert.assertTrue(verifyHomePage);
	}
	
	@Test(priority = 2)
	public void toCreateOpporunity() {
		new HomePage()
		.selectAppLauncher()
		.clickViewAll()
		.clickScales()
		.clickOpportunityTab();
	}
	
	@Test(priority = 3)
	public void toCreateNewOpporunity() throws Exception {
		boolean verifyElementInLogInPage = new HomePage()
		.clickNewButton()
		.opportunityName("Sales Force Automation By Damo128")
		.closeDate("17/10/2023")
		.clickStage()
		.clickSave()
		.clickLogOutIcon()
		.clickLogOut()
		.verifyElementInLogInPage();
		
		Assert.assertTrue(verifyElementInLogInPage);
	}
}

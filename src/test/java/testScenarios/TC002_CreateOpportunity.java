package testScenarios;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseClass;

import org.testng.Assert;

import pages.HomePage;
import pages.LoginPage;

public class TC002_CreateOpportunity extends BaseClass {
	
	@BeforeTest
	public void testingSetup() {
		excelFileName = "TC002";
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
	public void toCreateNewOpporunity(String searchOpporunityName, String opporunityDate) throws Exception {
		HomePage creatOpporunity = new HomePage();
				creatOpporunity.clickNewButton()
				.opportunityName(searchOpporunityName)
				.closeDate(opporunityDate)
				.clickStage()
				.clickSave()
				.clickOpportunityTab();
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

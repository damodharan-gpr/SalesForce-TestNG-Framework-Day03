package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import Base.BaseClass;

public class HomePage extends BaseClass {
	
	private By clickAppLauncher = By.xpath("//button[@data-aura-class='forceHeaderButton salesforceIdentityAppLauncherHeader']");
	private By clickViewAll = By.xpath("//button[text()='View All']");
	private By clickScales = By.xpath("//p[text()='Sales']");
	private By clickOpportunityTab = By.xpath("//span[text()='Opportunities']");
	private By clickNewButton = By.xpath("//div[text()='New']");
	private By opportunityName = By.xpath("//input[@name='Name']");
	private By closeDate = By.xpath("//input[@name='CloseDate']");
	private By clickStageDropBox = By.xpath("(//button[@aria-haspopup='listbox'])[1]");
	private By clickStage = By.xpath("(//div[@role='listbox']/lightning-base-combobox-item)[4]");
	private By clickSave = By.xpath("//button[@name='SaveEdit']");
	private By clickLogOut = By.xpath("//div/span/div/span/img[@title='User']");
	
	public boolean verifyElementsInHomePage() {
		if (driver.findElement(clickAppLauncher).isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
	
	public HomePage selectAppLauncher() {
		WebElement clickAppLauncherApp = driver.findElement(clickAppLauncher);
		clickAppLauncherApp.click();
		return this;
	}
	
	public HomePage clickViewAll() {
		WebElement selectViewAll = driver.findElement(clickViewAll);
		selectViewAll.click();
		return this;
	}
	
	public HomePage clickScales() {
		WebElement selectScales = driver.findElement(clickScales);
		selectScales.click();
		return this;
	}
	
	public HomePage clickOpportunityTab() {
		WebElement selectOpportunityTab = driver.findElement(clickOpportunityTab);
		Actions opportunityAction = new Actions(driver);
		opportunityAction.moveToElement(selectOpportunityTab).perform();
		opportunityAction.click().perform();
		return this;
	}
	
	public HomePage clickNewButton() {
		WebElement selectNewButton = driver.findElement(clickNewButton);
		Actions newButtonAction = new Actions(driver);
		newButtonAction.moveToElement(selectNewButton).perform();
		newButtonAction.click().perform();
		return this;
	}
	
	public HomePage opportunityName(String serach) {
		WebElement selectOpportunityName = driver.findElement(opportunityName);
		selectOpportunityName.sendKeys(serach);
		return this;
	}
	
	public HomePage closeDate(String date) {
		WebElement selectCloseDate = driver.findElement(closeDate);
		selectCloseDate.sendKeys(date);
		return this;
	}
		
	public HomePage clickStage() {
		WebElement selectStageDropBox = driver.findElement(clickStageDropBox);
		selectStageDropBox.click();
		WebElement selectStage = driver.findElement(clickStage);
		Actions stageAction = new Actions(driver);
		stageAction.moveToElement(selectStage).perform();
		stageAction.click().perform();
		return this;
	}
	
	public HomePage clickSave() {
		WebElement selectSave = driver.findElement(clickSave);
		Actions saveAction = new Actions(driver);
		saveAction.moveToElement(selectSave).perform();
		saveAction.click().perform();
		return this;
	}
	
	public LoginPage clickLogOut() {
		WebElement selectImage = driver.findElement(clickLogOut);
		Actions logoutAction = new Actions(driver);
		logoutAction.click(selectImage).perform();
		WebElement clickLogout = driver.findElement(By.xpath("//div/a[contains(text(),'Log Out')]"));
		clickLogout.click();
		return new LoginPage();
	}
}

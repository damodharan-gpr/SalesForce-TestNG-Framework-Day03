package pages;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	private By clickLogOutIcon = By.xpath("(//button[@type='button'])[7]");
	private By clickLogOut = By.xpath("//div/a[contains(text(),'Log Out')]");
	
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
	public HomePage clickLogOutIcon() throws Exception {
		Actions clickLogOutAction = new Actions(driver);
		WebElement clickLogOutImage = driver.findElement(clickLogOutIcon);
		clickLogOutAction.moveToElement(clickLogOutImage).click().perform();
		return this;
	}
	public LoginPage clickLogOut() {
		WebDriverWait oWait = new WebDriverWait(driver, Duration.ofSeconds(3000));
		oWait.until(ExpectedConditions.elementToBeClickable(clickLogOut));
		driver.findElement(clickLogOut).click();
		return new LoginPage();
	}
}

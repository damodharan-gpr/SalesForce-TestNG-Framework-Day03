package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseClass;

public class HomePage extends BaseClass {
	
	private By clickAppLauncher = By.xpath("//button[@data-aura-class='forceHeaderButton salesforceIdentityAppLauncherHeader']");
	private By clickViewAll = By.xpath("//button[text()='View All']");
	private By clickScales = By.xpath("//p[text()='Sales']");
	private By clickOpportunityTab = By.xpath("//a/span[text()='Opportunities']");
	private By clickNewButton = By.xpath("//div[text()='New']/../..");
	private By opportunityName = By.xpath("//input[@name='Name']");
	private By closeDate = By.xpath("//input[@name='CloseDate']");
	private By clickStageDropBox = By.xpath("(//button[@aria-haspopup='listbox'])[1]");
	private By clickStage = By.xpath("(//div[@role='listbox']/lightning-base-combobox-item)[4]");
	private By clickSave = By.xpath("//button[@name='SaveEdit']");
	private By searchOpporunitiesText = By.xpath("//table//tbody/tr/th//a");
	private By clickDropdownForDelete = By.xpath("//button[@class='slds-button slds-button_icon-border-filled']");
	private By selectDelete = By.xpath("//div/slot//a/span[text()='Delete']");
	private By confirmDelete = By.xpath("//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']");	
	//private By editDropdownForDelete = By.xpath("//table//tbody/tr//td/span/div[@class='forceVirtualActionMarker forceVirtualAction']");
	//private By clickLogOutIcon = By.xpath("(//button[@type='button'])[7]");
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
	
	public HomePage clickScales() throws Exception {
		WebElement selectScales = driver.findElement(clickScales);
		selectScales.click();
		Thread.sleep(300);
		return this;
	}
	
	public HomePage clickOpportunityTab() throws Exception {
		WebElement selectOpportunityTab = driver.findElement(clickOpportunityTab);
		Actions opportunityAction = new Actions(driver);
		opportunityAction.moveToElement(selectOpportunityTab).perform();
		opportunityAction.click().perform();
		return this;
	}
	
	public HomePage clickNewButton() throws Exception {
		WebElement selectNewButton = driver.findElement(clickNewButton);
		/**Actions newButtonAction = new Actions(driver);
		newButtonAction.moveToElement(selectNewButton).perform();
		newButtonAction.click().perform();*/
		selectNewButton.click();
		return this;
	}
	
	public HomePage opportunityName(String serach) {
		WebDriverWait oWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		oWait.until(ExpectedConditions.presenceOfElementLocated(opportunityName));
		WebElement selectOpportunityName = driver.findElement(opportunityName);
		selectOpportunityName.sendKeys(serach);
		System.out.println(serach);
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
	
	public HomePage selectDeleteOpporunity(String SearchOpportunityToDelete) throws Exception {
		List<WebElement> findOpportunityNames = driver.findElements(searchOpporunitiesText);
		
		for (WebElement findOpportunityName : findOpportunityNames) {
			System.out.println(findOpportunityName.getText());
			if (findOpportunityName.getText().equalsIgnoreCase(SearchOpportunityToDelete)) {
				/**Actions findopportunityAction = new Actions(driver);
				findopportunityAction.moveToElement(findOpportunityName).perform();
				findopportunityAction.click().perform();*/
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", findOpportunityName);
				System.out.println("The Opportunity Name Matched and Selected the Opporunity");
				Thread.sleep(3000);
			}
		}
		return this;
	}
	
	public HomePage selectDeleteDropDown() throws Exception {
		driver.findElement(clickDropdownForDelete).click();
		Thread.sleep(3000);
		return this;
	}
	
	public HomePage selectDelete() {
		driver.findElement(selectDelete).click();
		return this;
	}
	
	public HomePage selectConfirmDelete() {
		driver.findElement(confirmDelete).click();
		return this;
	}
	
	public HomePage clickLogOutIcon() throws Exception {
		//WebElement clickLogOutImage = driver.findElement(clickLogOutIcon);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		js.executeScript("document.querySelector('li>span>button[type=\"button\"]').click();");
		return this;
	}
	
	public LoginPage clickLogOut() throws Exception {
		Thread.sleep(3000);
		WebDriverWait oWait = new WebDriverWait(driver, Duration.ofSeconds(3000));
		oWait.until(ExpectedConditions.elementToBeClickable(clickLogOut));
		driver.findElement(clickLogOut).click();
		return new LoginPage();
	}
}

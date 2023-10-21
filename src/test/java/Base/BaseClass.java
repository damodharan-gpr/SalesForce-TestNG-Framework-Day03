package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import utilities.ExcelReader;
import utilities.PropertyReader;

public class BaseClass {
	
	public static WebDriver driver;
	public String browser = PropertyReader.readDataFromProperty("environment", "Browser");
	public String url = PropertyReader.readDataFromProperty("environment", "ScalesForceURL");
	public String excelFileName ="";
	
  @BeforeClass
  public void invokeBrowser() {
	  switch (browser) {
	case "chrome":
		driver = new ChromeDriver();
		System.out.println("Invoking Chrome Browser");
		break;
		
	case "edge":
		driver = new EdgeDriver();
		System.out.println("Invoking Edge Browser");
		break;
		
	case "firefox":
		driver = new FirefoxDriver();
		System.out.println("Invoking Firefox Browser");
		break;

	default:
		System.out.println("Due to invalid Selection Invoking Chrome Browser");
		break;
	}
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  
	  driver.navigate().to(url);
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  }
  
  @AfterClass
  public void closeBrowser() {
	  driver.quit();
  }

  @DataProvider(name = "SearchName")
  public Object[][] getExcelData() throws Exception {
	  Object texts[][] = ExcelReader.getValue(excelFileName);
	  return texts;
  }
}

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazon_Dell {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		// Add chrome driver property
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vishal\\eclipse-workspace\\chromedriver.exe");
		// Define chrome web driver
		WebDriver driver = new ChromeDriver();
		//Implicit Timeout
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Create a workbook class to access data
		FileInputStream fis = new FileInputStream("C:\\Users\\Vishal\\OneDrive\\Documents\\DemoData.xlsx"); 
		// Create Workbook object
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		// Create Sheet object of index 0
		XSSFSheet sh1 = workbook.getSheetAt(0);
		String d0 = sh1.getRow(0).getCell(1).getStringCellValue();
		
		//For sheet 2
		XSSFSheet sh2 = workbook.getSheetAt(1);
		String d1 = sh2.getRow(0).getCell(1).getStringCellValue();
		// Hit Amazon.in website
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//*[@id=\'nav-signin-tooltip\']/a")).click();  // Click on Sign in Tooltip button
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys(d0);
		//Click on Continue to provide password
		driver.findElement(By.xpath("//div[contains(@class, 'section')]/span/span/input")).click();
		driver.findElement(By.xpath("//div[contains(@class, 'section')]/div/following-sibling::input[1]")).sendKeys(d1);
		driver.findElement(By.xpath("//input[@id = 'signInSubmit']")).click(); // Log in Completed
		WebDriverWait xW = new WebDriverWait(driver,10);
		//xW.until(ExpectedConditions.)
		//Static Drop down web element creation
		WebElement Staticdrop = driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]"));
		Select dropdown = new Select(Staticdrop);
		dropdown.selectByVisibleText("Electronics");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Dell Laptop");
		driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
		 //Create web element for checkbox
		

	}

}

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddToCart {

	public static void main(String[] args) throws InterruptedException {
		// Defining chrome webdriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vishal\\eclipse-workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//FileInputStream fis = new FileInputStream("C:\\Users\\Vishal\\OneDrive\\Documents\\DemoData.xlsx");
		//XSSFWorkbook workbook = new XSSFWorkbook(fis);
		//XSSFSheet sh1 = workbook.getSheetAt(0);
		
		
		String[] itemsNeeded = {"Brocolli","Cucumber","Beetroot"};
		
		// Hit the main webpage
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		//Thread.sleep(3000L);
		//Get the list of items to be added into cart
		AddItems(driver,itemsNeeded);
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		
		WebElement countrySelect = driver.findElement(By.xpath("//div/select"));
		Select countryDrop = new Select(countrySelect);
		countryDrop.selectByVisibleText("India");
		driver.findElement(By.cssSelector("input.chkAgree")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
	}
	
	public static void AddItems(WebDriver driver, String[] itemsNeeded) {
		List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		
		//iteration for matching item
		for (int i=0; i<products.size(); i++) {
			String[] name = products.get(i).getText().split("-");
			String formatName = name[0].trim();
			//Convert array into Arraylist for easy search
			List itemsNeededList = Arrays.asList(itemsNeeded);
			//System.out.println(itemsNeeded[2]);
			System.out.println(itemsNeededList);
			//System.out.println(name[0].trim());
			if(itemsNeededList.contains(formatName)) {
				//Click to add to cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (i==itemsNeeded.length) {
					break;
				}
			}
		}
		driver.findElement(By.cssSelector("a.cart-icon")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		////span[text()='Code applied ..!']
		
	}

}

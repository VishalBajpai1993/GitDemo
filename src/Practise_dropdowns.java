import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Practise_dropdowns {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vishal\\eclipse-workspace\\chromedriver.exe");
		WebDriver chdriver = new ChromeDriver();
		chdriver.get("https://spicejet.com");
		// chdriver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//Assert.assertFalse(false);
		//System.out.println(chdriver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		//Assert.assertFalse(chdriver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		//chdriver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		//Assert.assertTrue(chdriver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		//Assert.assertEquals(chdriver.findElements(By.cssSelector("input[type = 'checkbox']")).size(), 6);
		//System.out.println(chdriver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
		
		//System.out.println(chdriver.findElements(By.cssSelector("input[type = 'checkbox']")).size());
		
		/*
		Assert.assertFalse(chdriver.findElement(By.cssSelector("input[name='checkBoxOption1']")).isSelected());
		chdriver.findElement(By.cssSelector("input[name='checkBoxOption1']")).click();
		Assert.assertTrue(chdriver.findElement(By.cssSelector("input[name='checkBoxOption1']")).isSelected());
		Thread.sleep(2000L);
		
		chdriver.findElement(By.cssSelector("input[name='checkBoxOption1']")).click();
		Assert.assertFalse(chdriver.findElement(By.cssSelector("input[name='checkBoxOption1']")).isSelected());
		Assert.assertEquals(chdriver.findElements(By.cssSelector("input[type='checkbox']")).size(), 3);
		System.out.println("All Good");
		*/
		chdriver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		chdriver.findElement(By.xpath("//div[@id=\"ctl00_mainContent_ddl_originStation1_CTNR\"] //a[@value=\"LKO\"]")).click();
		Thread.sleep(2000L);
		chdriver.findElement(By.xpath("//div[@id=\"glsctl00_mainContent_ddl_destinationStation1_CTNR\"] //a[@value=\"GOI\"]")).click();
		chdriver.findElement(By.partialLinkText("10")).click();
		
		//System.out.println(chdriver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style"));
		//chdriver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		//System.out.println(chdriver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style"));
		
		Assert.assertFalse(chdriver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style").contains("1"));
		
		//chdriver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state.hover")).click();
		Thread.sleep(2000L);
		chdriver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		Thread.sleep(2000L);
		chdriver.findElement(By.id("divpaxinfo")).click();
		
		WebElement staticDropdown = chdriver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
		Select addpsg = new Select(staticDropdown);
		addpsg.selectByValue("7");
		
		chdriver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000L);
		WebElement Dropdown = chdriver.findElement(By.xpath("//*[@id=\'ctl00_mainContent_DropDownListCurrency\']"));
		Select dropdown = new Select(Dropdown);
		dropdown.selectByVisibleText("USD");
		
		Thread.sleep(200L);
		chdriver.findElement(By.xpath("//*[@id='ctl00_mainContent_btn_FindFlights']")).click();
		
		
		/*
		chdriver.findElement(By.xpath("//div[@id=\"select-class-example\"] //input[@id=\"autosuggest\"]")).sendKeys("ind");
		Thread.sleep(200L);
		List<WebElement> option_values = chdriver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		
		for (WebElement option : option_values) {
			if (option.getText().equalsIgnoreCase("India"))
			{
				option.click();
				break;
			}
		}
		*/
		
		
		
	}

}

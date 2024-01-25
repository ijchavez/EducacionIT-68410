package clase6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions;

public class CapabilitiesExample {
	WebDriver driver;
	String url = "http://www.automationpractice.pl/";
	
	@BeforeTest
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("start-maximized");
		//options.addArguments("incognito");
		//no inicializa el navegador de forma visual.
		options.addArguments("headless");
		driver = new ChromeDriver(options);
    	driver.get(url);
		
	}
	@Test
	public void searchTshirtItem() {
		WebElement searchInput = driver.findElement(By.id("search_query_top"));
		searchInput.sendKeys("T-shirt");
		searchInput.sendKeys(Keys.ENTER);
		
	}
	@Test
	public void searchDressItem() {
		WebElement searchInput = driver.findElement(By.id("search_query_top"));
		searchInput.sendKeys("dress");
		searchInput.sendKeys(Keys.ENTER);
		
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}

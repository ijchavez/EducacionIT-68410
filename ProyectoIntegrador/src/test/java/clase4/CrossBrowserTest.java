package clase4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {
	WebDriver driver;
	String url = "http://www.automationpractice.pl/";
	
	@BeforeTest
	@Parameters("navegador")
	public void setUp(@Optional("chrome")String navegador) {
		if(navegador.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			
		}
		if(navegador.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			
		}
		driver.get(url);
		
	}
	@Test
	public void searchItem() {
		WebElement searchInput = driver.findElement(By.id("search_query_top"));
		searchInput.sendKeys("T-shirt");
		searchInput.sendKeys(Keys.ENTER);
		
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}

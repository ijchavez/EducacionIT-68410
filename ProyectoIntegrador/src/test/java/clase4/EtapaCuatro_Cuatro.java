package clase4;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EtapaCuatro_Cuatro {
	String url = "http://www.automationpractice.pl/";
	@Test
	public void Ej1_2() throws InterruptedException {
		WebDriver driver;
		driver = new ChromeDriver();
		
		driver.get(url);
		System.out.println(driver.getTitle());
		
		driver.close();
		
	}
}

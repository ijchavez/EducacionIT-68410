package Clase5;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ManejoTablas {
	WebDriver driver;
	String url = "https://demo.guru99.com/test/table.html";
	@BeforeMethod
	public void init() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
	}
	@Test
	public void tablaTest() {
		List<WebElement> tableValues = driver.findElements(By.xpath("//table[@cellspacing=1]//tr//td"));
		int i = 0;
		for (WebElement el: tableValues){
			String elValue = el.getText();
			if(elValue.equals("6")) {
				System.out.println(el.getText());
				i++;
			}

		}
		Assert.assertEquals(i, 3);
		System.out.println("cantidad de elementos : " + i);
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}

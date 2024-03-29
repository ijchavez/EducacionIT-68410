package Clase5;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ManejoDeAlertas {
	WebDriver driver;
	String url = "https://demoqa.com/alerts";
	@BeforeMethod
	public void init() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
	}
	@Test
	public void alertasTest() {
		WebElement alertButton = driver.findElement(By.id("alertButton"));
		alertButton.click();
		
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		
		System.out.println(alertText);
		Assert.assertEquals(alertText, "You clicked a button");
		
		alert.accept();
		
	}
	@Test
	public void alertasConEsperaTest() {
		
		WebElement alertButton = driver.findElement(By.id("timerAlertButton"));
		alertButton.click();
		
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());		
		
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		
		System.out.println(alertText);
		Assert.assertEquals(alertText, "This alert appeared after 5 seconds");
		
		alert.accept();
		
	}
	@Test
	public void alertasConfirmacionTest() {
		WebElement confirmButton = driver.findElement(By.id("confirmButton"));
		confirmButton.click();
		
		Alert confirmAlert = driver.switchTo().alert();
		String confirmAlertText = confirmAlert.getText();
		
		System.out.println(confirmAlertText);
		Assert.assertEquals(confirmAlertText, "Do you confirm action?");
		
		confirmAlert.accept();
		
		WebElement result = driver.findElement(By.id("confirmResult"));
		String resultText = result.getText();
		
		Assert.assertEquals(resultText, "You selected Ok");
		
	}
	@Test
	public void alertasCancelarTest() {
		WebElement confirmButton = driver.findElement(By.id("confirmButton"));
		confirmButton.click();
		
		Alert confirmAlert = driver.switchTo().alert();
		String confirmAlertText = confirmAlert.getText();
		
		System.out.println(confirmAlertText);
		Assert.assertEquals(confirmAlertText, "Do you confirm action?");
		
		confirmAlert.dismiss();
		
		WebElement result = driver.findElement(By.id("confirmResult"));
		String resultText = result.getText();
		
		Assert.assertEquals(resultText, "You selected Cancel");
		
	}
	@Test
	public void alertarIngresarDatoTest() {
		String input = "Nombre";
		WebElement promptButton = driver.findElement(By.id("promtButton"));
		promptButton.click();
		
		Alert promptAlert = driver.switchTo().alert();
		promptAlert.sendKeys(input);
		promptAlert.accept();
		
		WebElement promptResult = driver.findElement(By.id("promptResult"));
		String promptResultText = promptResult.getText();
		
		Assert.assertEquals(promptResultText, "You entered " + input);
		
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}

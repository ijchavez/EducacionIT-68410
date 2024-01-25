package Clase5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UploadFiles {
	WebDriver driver;
	String url = "https://demo.guru99.com/test/upload/";
	@BeforeMethod
	public void init() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
	}
	@Test
	public void downloadFileTest() throws InterruptedException {
		WebElement uploadFile = driver.findElement(By.id("uploadfile_0"));
		uploadFile.sendKeys("D:\\EducacionIT-68410\\ProyectoIntegrador\\src\\test\\resources\\inicioSesionValido.xlsx");
		
		WebElement submitButton = driver.findElement(By.id("submitbutton"));
		submitButton.click();
		
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement result = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("res"))));
		System.out.println(result.getText());
		
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}

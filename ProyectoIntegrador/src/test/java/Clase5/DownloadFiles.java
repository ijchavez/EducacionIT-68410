package Clase5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DownloadFiles {
	WebDriver driver;
	String url = "https://demo.guru99.com/test/yahoo.html";
	@BeforeMethod
	public void init() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
	}
	@Test
	public void downloadFileTest() {
		WebElement messengerDownload = driver.findElement(By.id("messenger-download"));
		String sourceDownload = messengerDownload.getAttribute("href");
		String wget_command = 
        		"cmd /c D:\\EducacionIT-68410\\ProyectoIntegrador\\src\\test\\resources\\wget.exe -P D:\\EducacionIT-68410\\ProyectoIntegrador\\src\\test\\resources\\downloads\\ --no-check-certificate " + sourceDownload;
		
        try {
        @SuppressWarnings("deprecation")
			Process exec = Runtime.getRuntime().exec(wget_command);
        	int exitVal = exec.waitFor();
        	System.out.println("Exit value: " + exitVal);
        
        } catch (Exception ex) {
        	System.out.println(ex.toString());
        
        }
		
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}

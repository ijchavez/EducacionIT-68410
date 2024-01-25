package clase6;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v120.emulation.Emulation;
import org.openqa.selenium.devtools.v120.network.Network;
import org.openqa.selenium.mobile.NetworkConnection;
import org.openqa.selenium.mobile.NetworkConnection.ConnectionType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class CambiosSelenium4 {
	WebDriver driver;
	String url = "https://seleniumjavalocators.neocities.org/";
	
	@BeforeTest
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		//options.addArguments("incognito");
		//no inicializa el navegador de forma visual.
		//options.addArguments("headless");
		driver = new ChromeDriver(options);
    	driver.get(url);
		
	}
	@Test
	public void locatorRelativo() throws InterruptedException {
		WebElement h2Subtitulo = driver.findElement(By.xpath("//h2[@data-test-id='subtitulo']"));
		WebElement primerParrafoDebajoH2 = driver.findElement(with(By.tagName("p")).below(h2Subtitulo));
		System.out.print(primerParrafoDebajoH2.getText());
		
		//ventanas
		//driver.switchTo().newWindow(WindowType.WINDOW);
		//tabs
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(url + "/pages/fechas");
		Thread.sleep(3000);
	}
	@Test
	public void geoLocTest() {
		Number latitude = 35.8235;
		Number longitude = -78.8256;
		Number geo = 100;
		DevTools devTools = ((HasDevTools) driver).getDevTools();
		devTools.createSession();
		devTools.send(Emulation.setGeolocationOverride(
		Optional.of(latitude),
		Optional.of(longitude),
		Optional.of(geo)));
		driver.get(url);
	}
	
	@Test
	public void screenshotImage() throws IOException {
		WebElement logo= driver.findElement(By.xpath("//img[@alt='blacklorem']"));
				File file=logo.getScreenshotAs(OutputType.FILE);
				File destFile = new File("blacklorem.png");
				FileUtils.copyFile(file,destFile);
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
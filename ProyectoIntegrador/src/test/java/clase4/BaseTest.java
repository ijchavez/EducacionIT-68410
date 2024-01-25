package clase4;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.github.javafaker.Faker;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;

public class BaseTest {
	String url = "http://www.automationpractice.pl/";
	public WebDriver driver;
	Faker faker;

	@BeforeSuite
	public void initSuite() {
		System.out.println("inicio de la suite de pruebas");
	}
	@BeforeMethod
	@Parameters("navegador") 
	//el parametro option nos permite que por defecto utilice un navegador
	//util para ejecutar un test desde una clase en particular.
	public void setUp(@Optional("chrome")String navegador) {
		faker = new Faker();
		if(navegador.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		if(navegador.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		if(navegador.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}		
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().deleteAllCookies();

	}
	@AfterMethod
	public void screenshot(ITestContext context) throws IOException {
		//el context sirve para tomar informacion del contexto del test que se esta ejecutando.
		LocalDateTime datetime = LocalDateTime.now();
		File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("..\\ProyectoIntegrador\\Evidencias\\" + context.getName() + " " + datetime.getNano() +".png"));
	    //TODO crear una carpeta con la fecha, la imagen con el nombre del test
		//esto es valido simplemente para el ejercicio 4.1 punto 16
		driver.navigate().to(url);
		
		driver.close();
	}
	@AfterSuite
	public void finSuitePruebas() {
		System.out.println("finalizó la suite de pruebas.");
		
	}
	
	
}
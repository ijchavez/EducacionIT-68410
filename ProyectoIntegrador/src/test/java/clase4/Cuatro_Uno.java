package clase4;
import org.testng.Assert;
import org.testng.annotations.*;

import clase4.pages.LandingPage;
import clase4.pages.LoginPage;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;




public class Cuatro_Uno extends BaseTest{
	@Test
	public void  irRegistroLogin(){
		LandingPage landingPage = new LandingPage(driver);
		//Landing Page 
		WebElement loginLink = landingPage.getLoginLink();
		loginLink.click();
		
		LoginPage loginPage = new LoginPage(driver);
		//LoginPage
		
		WebElement titleTextForm = loginPage.getTextTitleForm();
		String titleTextFormText = titleTextForm.getText();
		
		Assert.assertEquals(titleTextFormText, "AUTHENTICATION", "El texto no es el esperado");
		
		
	}
	@Test
	public void  crearCuentaInvalida(){
		LandingPage landingPage = new LandingPage(driver);
		//Landing Page 
		WebElement loginLink = landingPage.getLoginLink();
		loginLink.click();
		
		LoginPage loginPage = new LoginPage(driver);
		//LoginPage
		WebElement emailCreateInput = loginPage.getEmailCreateInput();
		emailCreateInput.sendKeys(faker.internet().emailAddress());
		
		WebElement submitCreateAccountBtn = loginPage.getSubmitCreateAccountBtn();
		submitCreateAccountBtn.click();
		
		WebElement titleTextForm = loginPage.getTextTitleForm();
		String titleTextFormText = titleTextForm.getText();
		
		Assert.assertEquals(titleTextFormText, "AUTHENTICATION", "El texto no es el esperado");
		
	}
	//Variante de Ejercicio 4.2 que es valido
	//verificar en el futuro si no se borra el usuario en cuestion
	@Test
	public void inicioSesionValido() {
		LandingPage landingPage = new LandingPage(driver);
		//Landing Page 
		WebElement loginLink = landingPage.getLoginLink();
		loginLink.click();
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.sendKeysToEmailLoginInput("juansotoarias@gmail.com", 12);
		
		loginPage.sendKeysToPasswordLoginInput("qwer159", 0);
		
		loginPage.clickOnSubmitLoginBtn(10);
		
		WebElement titleTextForm = loginPage.getTextTitleForm();
		String titleTextFormText = titleTextForm.getText();
		
		Assert.assertEquals(titleTextFormText, "MY ACCOUNT", "El texto no es el esperado");
		
	}
	//Ejercicio 4.2
	@Test
	public void inicioSesionInValido() {
		LandingPage landingPage = new LandingPage(driver);
		//Landing Page 
		WebElement loginLink = landingPage.getLoginLink();
		loginLink.click();
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.sendKeysToEmailLoginInput(faker.internet().emailAddress(), 12);
		
		loginPage.sendKeysToPasswordLoginInput("qwer159", 0);
		
		loginPage.clickOnSubmitLoginBtn(10);
		
		WebElement titleTextForm = loginPage.getTextTitleForm();
		String titleTextFormText = titleTextForm.getText();
		
		Assert.assertEquals(titleTextFormText, "AUTHENTICATION", "El texto no es el esperado");
		
	}
	//test que abre automation practice
	@Test
	public void Ej1_2() throws InterruptedException {
		WebDriver driver;
		driver = new ChromeDriver();
		
		driver.get(url);
		System.out.println(driver.getTitle());
		
		driver.close();
		
	}
}

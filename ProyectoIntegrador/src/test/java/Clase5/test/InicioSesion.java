package Clase5.test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import clase4.BaseTest;
import clase4.pages.LandingPage;
import clase4.pages.LoginPage;

public class InicioSesion extends BaseTest{
	@Test(dataProvider = "validLogin", dataProviderClass = Clase5.dataProvider.dataProviderExample.class)
	public void inicioSesionValido(String email, String password) {
		LandingPage landingPage = new LandingPage(driver);
		//Landing Page 
		WebElement loginLink = landingPage.getLoginLink();
		loginLink.click();
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.sendKeysToEmailLoginInput(email, 12);
		
		loginPage.sendKeysToPasswordLoginInput(password, 0);
		
		loginPage.clickOnSubmitLoginBtn(10);
		
		WebElement titleTextForm = loginPage.getTextTitleForm();
		String titleTextFormText = titleTextForm.getText();
		
		Assert.assertEquals(titleTextFormText, "MY ACCOUNT", "El texto no es el esperado");
		
	}
	@Test(dataProvider = "validLoginExcel", dataProviderClass = Clase5.dataProvider.dataProviderExample.class)
	public void inicioSesionValidoExcel(String email, String password) {
		LandingPage landingPage = new LandingPage(driver);
		//Landing Page 
		WebElement loginLink = landingPage.getLoginLink();
		loginLink.click();
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.sendKeysToEmailLoginInput(email, 12);
		
		loginPage.sendKeysToPasswordLoginInput(password, 0);
		
		loginPage.clickOnSubmitLoginBtn(10);
		
		WebElement titleTextForm = loginPage.getTextTitleForm();
		String titleTextFormText = titleTextForm.getText();
		
		Assert.assertEquals(titleTextFormText, "MY ACCOUNT", "El texto no es el esperado");
		
	}
	@Test(dataProvider = "invalidLoginExcel", dataProviderClass = Clase5.dataProvider.dataProviderExample.class)
	public void inicioSesionInValido(String mail, String password) {
		LandingPage landingPage = new LandingPage(driver);
		//Landing Page 
		WebElement loginLink = landingPage.getLoginLink();
		loginLink.click();
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.sendKeysToEmailLoginInput(mail, 12);
		
		loginPage.sendKeysToPasswordLoginInput(password, 0);
		
		loginPage.clickOnSubmitLoginBtn(10);
		
		WebElement titleTextForm = loginPage.getTextTitleForm();
		String titleTextFormText = titleTextForm.getText();
		
		Assert.assertEquals(titleTextFormText, "AUTHENTICATION", "El texto no es el esperado");
		
	}
}
package clase4.pages;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import clase4.BaseTest;

public class LoginPage extends BaseTest {
	public LoginPage(WebDriver driver){
		 this.driver = driver;
		 PageFactory.initElements(new AjaxElementLocatorFactory (driver,20), this);
	
	}
	//localizador = valor
	@FindBy(id = "email_create")
	WebElement emailCreateInput;
	public WebElement getEmailCreateInput() {
		return emailCreateInput;
		
	}
	@FindBy(name = "SubmitCreate")
	WebElement submitCreateAccountBtn;
	public WebElement getSubmitCreateAccountBtn() {
		return submitCreateAccountBtn;
		
	}
	@FindBy(css = "h1.page-heading")
	WebElement textTitleFrom;
	public WebElement getTextTitleForm() {
		return textTitleFrom;
	}
	//email
	//password
	//sign in
	@FindBy(id = "email")
	WebElement emailLoginInput;
	public WebElement getEmailLoginInput(long secondsTowait) {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(secondsTowait));
		return wait.until(ExpectedConditions.visibilityOf(emailLoginInput));
		
	}
	public void sendKeysToEmailLoginInput(String email, long secondsTowait) {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(secondsTowait));
		WebElement emailInput = wait.until(ExpectedConditions.visibilityOf(emailLoginInput));
		emailInput.sendKeys(email);
		
	}
	@FindBy(id = "passwd")
	WebElement passwordLoginInput;
	public WebElement getPasswordLoginInput(long secondsTowait) {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(secondsTowait));
		return wait.until(ExpectedConditions.visibilityOf(passwordLoginInput));
		
	}
	public void sendKeysToPasswordLoginInput(String password, long secondsTowait) {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(secondsTowait));
		WebElement passwordInput = wait.until(ExpectedConditions.visibilityOf(passwordLoginInput));
		passwordInput.sendKeys(password);
	}
	@FindBy(id = "SubmitLogin")
	WebElement submitLoginBtn;
	public WebElement getSubmitLoginBtn(long secondsTowait) {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(secondsTowait));
		return wait.until(ExpectedConditions.elementToBeClickable(submitLoginBtn));
		
	}
	public void clickOnSubmitLoginBtn(long secondsTowait) {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(secondsTowait));
		wait.until(ExpectedConditions.elementToBeClickable(submitLoginBtn)).click();
		
	}
}

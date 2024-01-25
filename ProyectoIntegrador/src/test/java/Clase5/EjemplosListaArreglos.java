package Clase5;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EjemplosListaArreglos {
	@Test
	public void arreglosUniBiDimensionales() {
		String[] array = {"a", "b"};
		System.out.println(array[0]);
		System.out.println(array[1]);
		
		String[][] arrayOfArray = {
				{"501", "alfa"},
				{"x", "h"}
		};
		System.out.println(arrayOfArray[0][0]);
		System.out.println(arrayOfArray[0][1]);
		System.out.println(arrayOfArray[1][0]);
		System.out.println(arrayOfArray[1][1]);
				
	}
	@Test
	public void listas() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://seleniumjavalocators.neocities.org/");
		
		List<WebElement> parrafos = driver.findElements(By.tagName("p"));
		//primer webelement parrafo
		//WebElement primerParrafoElement = parrafos.get(0);
		//string del primer parrafo
		String primerParrafo = parrafos.get(0).getText();
		System.out.println(primerParrafo);
		
		System.out.println("Todos los parrafos");
		for(WebElement parrafoEl : parrafos) {
			System.out.println(parrafoEl.getText());
		}

		driver.close();
	}
}
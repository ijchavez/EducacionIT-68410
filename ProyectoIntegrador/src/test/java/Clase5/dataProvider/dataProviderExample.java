package Clase5.dataProvider;

import org.testng.annotations.DataProvider;

import Clase5.Utilidades.Utilidades;

public class dataProviderExample {
    @DataProvider (name="validLogin")
    public Object[][] personas() {
        return new Object[][]{
        	    //{"email", "password"}
                {"franperez@gmail.com", "franperez2010"},
                {"fabianasuarez@gmail.com", "fabi3310"},
                {"juansotoarias@gmail.com", "qwer159"}

        };
    }
    @DataProvider(name="validLoginExcel")
    public Object[][] personasExcel() throws Exception {
       	return Utilidades.readFromExcelFile("D:\\EducacionIT-68410\\ProyectoIntegrador\\src\\test\\resources\\inicioSesionValido.xlsx", "Hoja1");

       
    }
    @DataProvider(name="invalidLoginExcel")
    public Object[][] invalidpersonasExcel() throws Exception {
       	return Utilidades.readFromExcelFile("D:\\EducacionIT-68410\\ProyectoIntegrador\\src\\test\\resources\\inicioSesionInvalido.xlsx", "Hoja1");

       
    }
}

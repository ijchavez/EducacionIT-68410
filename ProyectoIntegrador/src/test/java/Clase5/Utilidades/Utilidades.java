package Clase5.Utilidades;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Utilidades {
	public static Object[][] readFromExcelFile(String ruta, String nombreHoja) throws Exception {
		FileInputStream file = new FileInputStream(new File(ruta));
		//instancio archivo excel desde el archivo situado en la ruta indicada
		XSSFWorkbook excelFile = new XSSFWorkbook(file);
		//instancio una hoja en base al archivo excel y asignando el nombre de la hoja
		XSSFSheet sheet = excelFile.getSheet(nombreHoja);
		
		//instanciamos una fila
		XSSFRow row;
		
		//tomamos el numero total de filas
		int rows = sheet.getPhysicalNumberOfRows();
		//instanciamos las columnas
		int column = sheet.getRow(0).getPhysicalNumberOfCells();
		
		//instanciamos el objeto bidimensional que nos va a devolver esta funcion
		Object cellValue[][]=new Object[rows][column];
		
		
		for (int r = 0; r < rows; r++) {
			row = sheet.getRow(r);

			if (row == null){ 
				break; 
			}else{ 
				for (int c = 0; c < column; c++) {
					DataFormatter dataFormatter = new DataFormatter();
					cellValue[r][c] = dataFormatter.formatCellValue(sheet.getRow(r).getCell(c));
					
				} 
				
			}
			
	   }
	   excelFile.close();
	   return cellValue; 
	
    }
}

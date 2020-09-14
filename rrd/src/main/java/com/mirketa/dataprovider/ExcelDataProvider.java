
package com.mirketa.dataprovider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

/**
 * Data provider will read data from XLS.
 *  
 * @author ManasJena
 *
 */

public class ExcelDataProvider {
	XSSFWorkbook wb;
	public static String Testdata_sheet_path=System.getProperty("user.dir") +File.separator+"AppData"+File.separator+"AppData.xlsx";

	public ExcelDataProvider() {
		File src = new File(Testdata_sheet_path);
		try {
			FileInputStream fis = new FileInputStream(src);

			wb = new XSSFWorkbook(fis);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is "+e.getMessage());;
		}

	}
	
	public String getData(int sheetIndex,int row, int column)
	{
		String data=wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
		return data;	
	}
	
	
	public String getData(String sheetName,int row, int column)
	{
		String data=wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		return data;	
	}
	
	public void closeBrowser(WebDriver ldriver)
	{
		ldriver.quit();
	}
	
	
	

}






package com.mirketa.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelsheetDataprovidertest{
	static Workbook book;
	static Sheet sheet;
	public static String Testdata_sheet_path=System.getProperty("user.dir") +File.separator+"AppData"+File.separator+"AppData.xlsx";
	//public static String Testdata_sheet_path="E:\\Excelsheettest\\rrd\\AppData\\TestDATA.xlsx";
	
	public static Object[][] gettestdata(String sheetName)
	{
		
		FileInputStream file=null;
		try {
			file=new FileInputStream(Testdata_sheet_path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			book=WorkbookFactory.create(file);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet=book.getSheet(sheetName);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
			{
				System.out.println("value"+sheet.getRow(i + 1).getCell(k));
				data[i][k]=sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		System.out.println("retrieving null"+data);
		
		return data;
		
	}


}

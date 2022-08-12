package com.Vtiger.Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility 
{
	/**
	 * This method is used for fetching the data from the excel sheet
	 * @author nikita
	 */
	public String getDataFromExcel(String sheetName,int RowNum,int cellNum) throws Throwable 
	{
	    FileInputStream fis1=new FileInputStream("./Book.xlsx"); 
		Workbook wb = WorkbookFactory.create(fis1);
		//Sheet sh = wb.getSheet(sheetName);
			
		//Row r= sh.getRow(RowNum);
		//Cell cel = r.getCell(cellNum);
		//String data = cel.getStringCellValue();
		//return data;
			
		
		DataFormatter format=new DataFormatter();
		return format.formatCellValue(wb.getSheet(sheetName).getRow(RowNum).getCell(cellNum));
		
	}

}

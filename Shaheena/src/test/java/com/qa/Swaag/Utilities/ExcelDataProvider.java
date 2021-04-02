package com.qa.Swaag.Utilities;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	
	public ExcelDataProvider(){
				
		File src = new File(System.getProperty("user.dir")+"/TestData/Data.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			wb= new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to load Excel File >>>  "+e.getMessage());
		} 
	}
	
	public String getDataFromExcel(String sheetName, int row, int column){
		
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getDataFromExcel(int sheetIndex, int row, int column){
		
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getNumericDataFromExcel(int sheetIndex, int row, int column){
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getNumericCellValue();
	}
}

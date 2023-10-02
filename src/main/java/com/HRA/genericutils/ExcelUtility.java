package com.HRA.genericutils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This Class consists of all the ExcelUtilities
 * @author Nixon
 * @return 
 */
public class ExcelUtility {
	/**
	 * This method is used to fetch the data from Excel 
	 * @param SheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromExcel(String SheetName, int rowNum, int cellNum) throws Throwable {
		Workbook wb = WorkbookFactory.create(new FileInputStream(IPathconstants.excelPath));
		Sheet sheet = wb.getSheet(SheetName);
		Row row = sheet.getRow(rowNum);
		String data = row.getCell(cellNum).getStringCellValue();
		return data;
		
	}
	
	/**
	 * This method is write a data in the Excel Doc
	 * @param SheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws Throwable 
	 * @throws FileNotFoundException 
	 * @throws EncryptedDocumentException 
	 */
	public void writeDataIntoExcel(String SheetName, int rowNum,int cellNum, String data ) throws  Throwable {
		Workbook wb = WorkbookFactory.create(new FileInputStream(IPathconstants.excelPath));
	    Sheet sheet = wb.getSheet(SheetName);
	    Row row = sheet.createRow(rowNum);
	    Cell cell = row.createCell(cellNum);
	    cell.setCellValue(data);
	    
	   FileOutputStream fos = new FileOutputStream(IPathconstants.excelPath);
	   wb.write(fos);
	   wb.close();
	
	}
	
	/**
	 * This method is used to fetch the count of rows created in Excel
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable
	{
		Workbook wb = WorkbookFactory.create(new FileInputStream(IPathconstants.excelPath));
		Sheet sheet = wb.getSheet(sheetName);
		int row = sheet.getLastRowNum();
		wb.close();
		return row;
		
	}

	public HashMap<String, String> getmultipleDataFromExcelWithRandomNum(String sheetName, int keycolum, int valuecolum, WebDriver driver,JavaUtility jLib ) throws Throwable {
		
		 FileInputStream fileinputStream = new FileInputStream(IPathconstants.excelPath);
		 Workbook wb= WorkbookFactory.create(fileinputStream);
		 Sheet sheet = wb.getSheet(sheetName);
		 int count = sheet.getLastRowNum();
		 
		 HashMap<String, String>map = new HashMap<String, String>(); //empty map
		 
		 for(int i= 1; i<count; i++)
		 {
			 String key =sheet.getRow(i).getCell(keycolum).getStringCellValue();
			 String value = sheet.getRow(i).getCell(valuecolum).getStringCellValue();
			 map.put(key, value);
		 }
	for(Entry<String, String> s:map.entrySet())
	{
		if(s.getKey().contains("Name"))
             {
            	 driver.findElement(By.name(s.getKey())).sendKeys(s.getValue()+jLib.getRandomeNumer());
             }else{
            	 driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
             }
                
	}
	return map;
}	
	public HashMap<String, String> getmultipleDataFromExcel(String sheetName, int keycolum, int valuecolum, WebDriver driver ) throws Throwable {
		
		 FileInputStream fileinputStream = new FileInputStream(IPathconstants.excelPath);
		 Workbook wb= WorkbookFactory.create(fileinputStream);
		 Sheet sheet = wb.getSheet(sheetName);
		 int count = sheet.getLastRowNum();
		 
		 HashMap<String, String>map = new HashMap<String, String>(); //empty map
		 
		 for(int i= 1; i<=count; i++)
		 {
			 String key =sheet.getRow(i).getCell(keycolum).getStringCellValue();
			 String value = sheet.getRow(i).getCell(valuecolum).getStringCellValue();
			 map.put(key, value);
		 }
	
	return map;
        
	}
	/**
	 * This method is used fetch set of data from Excel Using DataProvider
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public Object[][]getMultipleSetofDatas(String sheetName) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathconstants.excelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int lastrow = sh.getLastRowNum();
		int lastcell = sh.getRow(0).getLastCellNum();
		 
		   Object[][] obj = new Object[lastrow+1][lastcell];
		    
		   for (int i = 0; i <= lastrow; i++) {
			
			   for (int j = 0; j < lastcell; j++) {
				obj[i][j] =sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		    return obj;
	}
	
}





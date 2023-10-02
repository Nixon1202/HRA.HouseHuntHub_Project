package com.Practies;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExceTest {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("NewUserInfo");
		
		int count= sh.getLastRowNum();
		
		for(int i=1;i <=count;i++){
			int lastcell=sh.getRow(1).getLastCellNum();
			for(int j=0; j<lastcell;j++) {
				String value =sh.getRow(i).getCell(j).getStringCellValue();
				System.out.print(value+ " ");
			}
			System.out.println();
		}
	
	
	
	}

}

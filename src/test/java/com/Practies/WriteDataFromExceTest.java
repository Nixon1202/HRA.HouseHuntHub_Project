package com.Practies;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataFromExceTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Org");
		sh.createRow(9).createCell(0).setCellValue("NTTData");
		sh.getRow(9).createCell(1).setCellValue("Bengauru");
		
				
		
		FileOutputStream fout = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		wb.write(fout);
		wb.close();

	}

}

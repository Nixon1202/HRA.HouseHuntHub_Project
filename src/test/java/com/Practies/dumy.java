package com.Practies;

import java.io.FileInputStream;
import java.util.Date;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.HRA.genericutils.ExcelUtility;
import com.HRA.genericutils.IPathconstants;

public class dumy 
{
	public static String main(String[] args) throws Throwable 
	{
		
				Date dateTime = new Date();
				String[] d = dateTime.toString().split(" ");
				
				String day = d[0];
				String month =d[1];
				Object date =d[2];
				String year = d[5];
				
				String finalFormat= day+" "+month+" "+date+" "+year;
				return finalFormat;
			
	}
}
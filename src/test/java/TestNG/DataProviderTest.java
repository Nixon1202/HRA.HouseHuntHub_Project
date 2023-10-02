package TestNG;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HRA.genericutils.ExcelUtility;
import com.HRA.genericutils.IPathconstants;

  public class DataProviderTest {
//
//	@DataProvider
//	public Object[][] mobile(){
//		Object[][] obj = new Object[2][2];
//		
//		obj[0][0]= "Samsung";
//		obj[0][1]="50000";
//		
//		obj[0][0]= "iphone";
//		obj[0][1]="80000";
//		
//		return obj;
//	}
//	
//	@DataProvider
//	public Object[][] tv(){
//		Object[][] obj = new Object[2][3];t
//		
//		obj[0][0]= "LG";
//		obj[0][1]=500000;
//		obj[0][2]= "45 inch";
//
//		obj[1][0]= "Sony";
//		obj[1][1]=1000000;
//		obj[1][2]= "70 inch";
//
//		return obj;
//	}
//	
//	@Test(dataProvider = "tv")
//	public void getDate(String BrandNAme, int Price, String Size) {
//		System.out.println(BrandNAme+"-----"+Price+"-----"+Size);
//		
//	}
	  
	  @DataProvider
		public Object[][]dataFromExcel() throws Throwable
		{
			FileInputStream fi = new FileInputStream(IPathconstants.excelPath);
			Workbook wb = WorkbookFactory.create(fi);
			Sheet sh = wb.getSheet("DB");
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
	  
	  @DataProvider
	  public Object[][] getdatafromExcel() throws Throwable {
	 	 ExcelUtility eLib = new ExcelUtility();
	 	Object[][] obj = eLib.getMultipleSetofDatas("DB");
	 	
	 	return obj;
	   }
}

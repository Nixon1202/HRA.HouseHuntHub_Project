package TestNG;

import org.testng.annotations.Test;

public class dbExcelTest  {
	
	@Test(dataProviderClass = DataProviderTest.class,dataProvider = "dataFromExcel", invocationCount = 1)
	public void getExcelData(String Name, String Amt, String Color) {
		
		System.out.println(Name+"----"+Amt+"-----"+Color);
	}
	
	
   @Test(dataProviderClass = DataProviderTest.class,dataProvider = "getdatafromExcel")
   public void getDataFromDataProvider(String Name, String Amt, String Color) {
	  
	   System.out.println(Name+"----"+Amt+"-----"+Color); 
   }
    
    
  
}

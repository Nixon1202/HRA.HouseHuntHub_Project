package com.HRA.genericutils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.model.Report.ReportBuilder;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImpClass implements ITestListener {

	ExtentReports reports;
	ExtentTest test ;
	@Override
	public void onTestStart(ITestResult result) {
		
		//actual testscripr execution starts from here
		String MethodName = result.getMethod().getMethodName();
    	test = reports.createTest(MethodName);
		Reporter.log(MethodName+" ---->Execution Starts");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
	String MethodName = result.getMethod().getMethodName();	
	test.log(Status.PASS, MethodName+"-----Passed");
	Reporter.log(MethodName+"------Testscript executed successfully");
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName();
//		try {
//		String FailedScript = WebDriverUtils.takeScreenShot(Baseclass.Sdriver, MethodName);
//		test.addScreenCaptureFromPath(FailedScript);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL ,MethodName+"----Failed"); // to print in extent Report
		Reporter.log(MethodName+"-------->Failed",true); // to print in testng report & console
		
		String FailedScript = MethodName+JavaUtility.getSystemDateInFormat();
     TakesScreenshot ts = (TakesScreenshot)Baseclass.Sdriver;
     File src = ts.getScreenshotAs(OutputType.FILE);
     File dst = new File("./ScreenShot/"+FailedScript+".png");
     try {
		FileUtils.copyFile(src, dst);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	 String MethodName = result.getMethod().getMethodName();
	 test.log(Status.SKIP , result.getThrowable());
	 test.log(Status.SKIP , MethodName+"------->Skipped");
	 Reporter.log(MethodName+"------>Skipped");
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		// Create report
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./Extentreport/report.html");
		htmlReport.config().setDocumentTitle("SDET-51");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setReportName("HRA");
		
		reports = new ExtentReports();
		reports.attachReporter(htmlReport);
		reports.setSystemInfo("OS", "Windows-10");
		reports.setSystemInfo("Base-Browser", "chrome");
		reports.setSystemInfo("Base-URL", "http://rmgtestingserver/domain/House_Rental_Application/");
		reports.setSystemInfo("Reporter_Name", "Nixon");
	}

	@Override
	public void onFinish(ITestContext context) {
		
		reports.flush();
		
	}
	
	

}

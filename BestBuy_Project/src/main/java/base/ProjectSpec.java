package base;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utility.UtilityClass;

public class ProjectSpec extends UtilityClass implements ITestListener{
	
	
	String res;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		 res = result.getClass().getName();
		System.out.println(res);
	}


	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	}


	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	}


	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}


	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}


	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	@BeforeTest()
	public void propertiesLoad() throws IOException {
		
		 file = new File("src/main/java/property/data.properties");
		 prop = new Properties();
		 fis = new FileInputStream(file);
		 prop.load(fis);
		 System.out.println("Property Loaded");
	}
	
	@DataProvider(name="getSingleArrayData")
	public String[] getSingleData() throws IOException {
	return ReadSingle(excelFile) ;
	
	}

	@DataProvider(name="getData")
	public String[][] getData() throws IOException {

		return  ReadExcel(excelFile);
		
		
	}
	
	
	
	
	
	
	
	
	@Parameters({"browser","url"})
	@BeforeMethod()
	public void launchBrowser(String browser,String url) {
		 
		launch(browser, url);
		System.out.println("browser Launched - before Method");
		
	}
	
	
	
	
	
	
	
	@AfterMethod()
	public void tear(){
	quit();	
	}
	
	

	
}

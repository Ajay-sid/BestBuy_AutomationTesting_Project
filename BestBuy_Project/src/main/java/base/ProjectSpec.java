package base;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
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
	

	@Parameters({"browser","url"})
	@BeforeMethod()
	public void launchBrowser(String browser,String url) {
		 
		launch(browser, url);
		System.out.println("from 1");
		
	}
	@BeforeMethod(groups= {"invalidUrl"})
	public void skip() {
		
	}
	
	
	
	

	
}

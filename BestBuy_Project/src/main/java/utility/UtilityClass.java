package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.FooterPage;
import pages.HeaderPage;

//BestBuy
public class UtilityClass {
	public WebDriver driver;
	public HeaderPage header;
	public FooterPage footer;
	public File file;
	public Properties prop;
	public FileInputStream fis;
	public String excelFile;
	
	

	// Launching URL
	public void launch(String browser, String url) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver(options);
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;	
		default:
			System.err.println("Invalid browser name");
			break;
		}
		
		driver.manage().window().maximize();
		try {
		driver.get(url);
		//WebElement us = driver.findElement(By.xpath("//div[@lang='en']/div[@class='country-selection']/a[@class='us-link']"));
		//elementClick(us);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//driver.switchTo().defaultContent();
		
		}catch(Exception e) {
			
		}
		
	}
	
	public String urlCheck(String link) throws IOException {
		
		String msg;
		try {
			HttpURLConnection huc =(HttpURLConnection)(new URL(link).openConnection());
			huc.connect();
			int code =huc.getResponseCode();
			if(code>=400) {
				return "Invalid";
			}else {
				return "valid";
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return e.getMessage();
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return e.getMessage();
		}
		
		
		
	}
	
	public String [] ReadSingle(String excelname) throws IOException {
			
		XSSFWorkbook book = new XSSFWorkbook("allData\\"+excelname+".xlsx");
			XSSFSheet sheet = book.getSheetAt(0);

			int rowCount = sheet.getLastRowNum();
			String[] data =new String[rowCount];
			for (int i=1;i<=rowCount;i++) {
				XSSFRow row = sheet.getRow(i);
				XSSFCell cell = row.getCell(0);
				data[i-1]=cell.getStringCellValue();
				
			}
			return data;
			
		
	}
	
	
		
	// Excel data to array - Appache POI
	public static String[][] ReadExcel(String excelname) throws IOException {

		XSSFWorkbook book = new XSSFWorkbook("/data/" + excelname + ".xlsx");

		XSSFSheet sheet = book.getSheetAt(0);

		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
//		System.out.println(rowCount);
//		System.out.println(colCount);

		String[][] data = new String[rowCount][colCount];

		for (int i = 1; i <= rowCount; i++) {

			XSSFRow row = sheet.getRow(i);

			for (int j = 0; j < colCount; j++) {

				XSSFCell cell = row.getCell(j);

				data[i - 1][j] = cell.getStringCellValue();
			}
		}
		book.close();
		return data;

	}
	
	
	
	//close active window
	public void close() {

		driver.close();

	}
	
	
	//close entire browser
	public void quit() {
		driver.quit();
	}
	
	//Click an element
	public void elementClick(WebElement element) {
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		}catch(WebDriverException e){
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			
		}
		
	}
	
	
	//SendKeys
	public void sendKeys(WebElement element,String string) {
		element.clear();
		element.sendKeys(string);
		
		
	}
	
	
	//Getting page Title
	public String getPageTitle() {
        return driver.getTitle();
    }
	
	public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
	

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void goBack() {
        driver.navigate().back();
    }

    public void goForward() {
        driver.navigate().forward();
    }
	

}

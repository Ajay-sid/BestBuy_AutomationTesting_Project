package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//BestBuy
public class UtilityClass {
	public WebDriver driver;
	public File file;
	public Properties prop;
	public FileInputStream fis;
	public String excelFile;
	public Actions action;
	
	
	

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
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//driver.switchTo().defaultContent();
		
		}catch(Exception e) {
			
		}
		
	}
	
	public String urlCheck(String link) throws IOException {
		
		
		try {
			HttpURLConnection huc =(HttpURLConnection)(new URL(link).openConnection());
			huc.connect();
			int code =huc.getResponseCode();
			System.out.println(code);
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

		XSSFWorkbook book = new XSSFWorkbook("allData\\" + excelname + ".xlsx");

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
	public WebElement getElementFormList(List<WebElement> elements,String str) {
//		
		return  elements.stream().filter(m->m.getText().equalsIgnoreCase(str)).findAny().get();
		
		
		
		//WebElement elem=null;
//		for(WebElement element :elements) {
//			if(element.getText().equalsIgnoreCase(str)){
//				elem=element;
//				break;
//			}
//		}
//		return elem;
	}
	
	
	//SendKeys
	public void sendKeys(WebElement element,String string) {
		element.clear();
		element.sendKeys(string);
		
		
	}
	//------------------------------------switch to--------------------------------//
	public void switchWindow(String window) {
		driver.switchTo().window(window);
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
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }
    
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }
    
    //-----------------------------Actions--------------------------------//
    
    public void actionElementClick(WebElement element) {
    	action = new Actions(driver);
    	action.moveToElement(element).click().build().perform();	
    }
    
    public void scrollElement(WebElement element) {
    	action = new Actions(driver);
    	action.scrollToElement(element).perform();
    }
    
}

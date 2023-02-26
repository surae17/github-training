package org.sam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static WebDriver driver;
	
	public static void LaunchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	public static void LaunchUrl(String url) {
		driver.get(url);	
	}
	public static  String pageTitle() {
		String title = driver.getTitle();
		return title;	
	}
	public static void WindowMaximize() {
		String Maximize = driver.getWindowHandle();
		System.out.println(Maximize);
	}
	public static String pageUrl() {
		String Url = driver.getCurrentUrl();
		return  Url;
	}
	public static void passText(WebElement ele, String txt) {
		ele.sendKeys(txt);
	}
	public static void closeEntireBrowser() {
		driver.quit();	
	}
	public static void clickBtn(WebElement ele) {
		ele.click();
	}
	public static void screenShot(String imgName) throws IOException {
		TakesScreenshot ts  = (TakesScreenshot) driver;
		File Image  = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("location+imgName.png");
		FileUtils.copyFile(Image, f);	
	}
	public static Actions a;
	
	public static void moveTheCursor(WebElement tagetWebElement) {
		a = new Actions(driver);
		a.moveToElement(tagetWebElement).perform();
	}
	public static void dragDrop(WebElement dragWebElement, WebElement dropElement) {
		a = new Actions(driver);
		a.dragAndDrop(dragWebElement, dropElement).perform();		
	}
	public static JavascriptExecutor js;
	
	public static void scroll(WebElement element) {
		js = (JavascriptExecutor)driver;
		js.executeScript("argument[0].scrollIntoView(false)", element);		
	}
	public static void excelRead(String sheetName, int rowNum, int cellNum) throws IOException {
		File f = new File("excellocation.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb  = new XSSFWorkbook(fis);
		Sheet mySheet = wb.getSheet("Data");
		Row r = mySheet.getRow(rowNum);
		Cell c =r.getCell(cellNum);
		int cellType = c.getCellType();
		
		String value = "";
		if (cellType==1) {
			String value2 = c.getStringCellValue();
		}
		else if (DateUtil.isCellDateFormatted(c)) {
			Date dd = (Date) c.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat(value);
			String value1 = s.format(dd);
		}
		
		else {
			double d = c.getNumericCellValue();
			long l = (long) d;
			String valueOf = String.valueOf(l);
		}
	}
	
	
	private static void createNewExcelFile(int rowNum, int cellNum,String writeData)throws IOException {
	File f = new  File("Excel location.xlsx");
	Workbook w = new XSSFWorkbook();
	Sheet newSheet = w.createSheet("Datas");
	Row newRow = newSheet.createRow(rowNum);
	Cell newCell = newRow.createCell(cellNum);
	newCell.setCellValue(writeData);
	FileOutputStream fos = new FileOutputStream(f);	
		
	}
	public static void createCell(int getRow, int creCell, String newData )throws IOException {
		File f = new File("Excel location.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("Datas");
		Row r = s.createRow(getRow);
		Cell c = r.createCell(creCell);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);		
	}
	public static void updateDAtaparticularCell(int getTheRow, int getTheCell, String exisitingData, String writeNewData  ) throws IOException {
		File f = new File("Excel Location.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("Datas");
		Row r = s.getRow(getTheRow);
		Cell c = r.getCell(getTheCell);
		String str = c.getStringCellValue();
		if (str.equals(exisitingData)) {
			c.setCellValue(writeNewData);
	}
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);	
			
	}
	

}

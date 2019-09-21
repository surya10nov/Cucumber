package org.test.Maven1;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {
	static String window;
public static void main(String[] args) throws Throwable {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Surya\\eclipse-workspace\\DayTask\\driv\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	try {
		WebElement but=driver.findElement(By.xpath("//button[text()='✕']"));
		but.isDisplayed();
		but.click();
		
	} catch (Exception e) {
		System.out.println("pop up is not displayed");
	}
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mobiles",Keys.ENTER);
	File loc=new File("C:\\Users\\Surya\\eclipse-workspace\\DayTask\\Data\\New.xlsx");
	FileOutputStream stream=new FileOutputStream(loc);
	Workbook w=new XSSFWorkbook();
	Sheet s=w.createSheet("Flipkart task");
	Thread.sleep(3000);
	List<WebElement> name=driver.findElements(By.xpath("//div[@id='container']/div/div[3]/div[2]/div/div[2]/div//a//div[contains(text(),'GB')]"));
	for (int i = 0; i < name.size(); i++) {
		String name1=name.get(i).getText();
		System.out.println(name1);
		Row row=s.createRow(i);
		Cell c1=row.createCell(0);
		c1.setCellValue(name1);
		
	}
	w.write(stream);
	name.get(4).click();
	String par=driver.getWindowHandle();
	Set<String> child=driver.getWindowHandles();
	for (String x : child) {
		if(!par.equals(x)) {
			driver.switchTo().window(x);
			
			WebElement newname = driver.findElement(By.xpath("//div[@id='container']//span[contains(text(),'GB')]"));
			window=newname.getText();			
			System.out.println("new window mobile name is :" +window);
						
		}
		
	}
	
FileInputStream f1=new FileInputStream(loc);
Cell c1=s.getRow(4).getCell(0);
String excel=c1.getStringCellValue();
System.out.println("value" +excel);
if(excel.equals(window)) {
	System.out.println("done");
}
else
{
	System.out.println("uahoo");
}
 	
driver.quit();	
}
}
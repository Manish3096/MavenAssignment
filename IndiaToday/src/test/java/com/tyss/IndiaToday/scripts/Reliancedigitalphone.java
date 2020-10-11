package com.tyss.IndiaToday.scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Reliancedigitalphone {

	static 
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws IOException, InvalidFormatException {
       
		ChromeOptions options = new ChromeOptions();
		 options.addArguments("--disable-notifications");
		 WebDriver d = new ChromeDriver(options);
		/*Maximize window*/
		d.manage().window().maximize();
		/*Wait condition*/
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*Navigate to the url*/
		d.get("https://www.reliancedigital.in/smart-phones/c/S101711?searchQuery=:relevance:availability:Exclude%20out%20of%20Stock&page=0");
		
		/*WebElement mobile = d.findElement(By.xpath("//div[@class='nav__title']"));
		Actions a = new Actions(d);
		a.moveToElement(mobile);
		
		d.findElement(By.xpath("//a[.='Smartphones']")).click();*/
		/*phone name*/
		List<WebElement> phonename = d.findElements(By.xpath("//p[@class='sp__name']"));
		/*Phone price*/
		List<WebElement> pprice = d.findElements(By.xpath("//p[@class='sp__name']/../../../../a/div/div/div/div/div/span[@class='sc-bxivhb cHwYJ']"));
		/*discounted phone price*/
		List<WebElement> pdiscountprice = d.findElements(By.xpath("//p[@class='sp__name']/../../../../a/div/div/div/div/div/span[2]"));
		/*discount percentage*/
		List<WebElement> ppriceper = d.findElements(By.xpath("//p[@class='sp__name']/../../../../a/div/div/div/div/div/span[3]"));
		int si = phonename.size();
		
		
		FileInputStream fis = new FileInputStream("./data/SmartphoneData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(0);
		sh.createRow(0);
		sh.createRow(0).createCell(0).setCellValue("Smartphone name");
		sh.createRow(0).createCell(1).setCellValue("Actual price");
		sh.createRow(0).createCell(2).setCellValue("Strike off Price");
		sh.createRow(0).createCell(3).setCellValue("Discount value");
		for(int i=0;i<si;i++) 
		{
			sh.createRow(i+1);
			String pna = phonename.get(i).getText();
			String[] splitname = pna.split(",");
			String price = pprice.get(i).getText();
			 String dis = pdiscountprice.get(i).getText();
			 String disper = ppriceper.get(i).getText();
			
			for(int k=0;k<splitname.length;k++)
			{
				sh.getRow(i+1).createCell(k).setCellValue(splitname[k]);
				if(k==splitname.length-1)
				{
					sh.getRow(i+1).createCell(4).setCellValue(price);
					sh.getRow(i+1).createCell(5).setCellValue(dis);
					sh.getRow(i+1).createCell(6).setCellValue(disper);
				}
				try {
					FileOutputStream fos = new FileOutputStream("./data/SmartphoneData.xlsx");
					 wb.write(fos);
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
			}
			
			 
			 System.out.println("Name of the phone : "+pna+" price : "+price+" discounted price : "+dis+" % of discount :"+disper);
		}
		
		d.close();
		
	
	
	
	
	
	}
	
}

package com.tyss.GreenKart.scripts;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class GreenKart2 {
	static 
	   {
		   System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	   }
	   
	public static void main(String[] args) {
		   
		   WebDriver d = new ChromeDriver();
		   /*Maximize window*/
		   d.manage().window().maximize();
		   /*Wait condition*/
		   d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   /*Navigate to the url*/
		   d.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		   /*click on top deals*/
		   d.findElement(By.xpath("//a[.='Top Deals']")).click();
		   
		   /*get window address*/
		   Set<String> allwh = d.getWindowHandles();
		   Iterator<String> i = allwh.iterator();
		   String pid = i.next();
		   String cid = i.next();
		   
		   /*switch control from parent window to child window*/
		   d.switchTo().window(cid);
		   
		   /*select the pagesize as 10*/
		   WebElement Pagesize = d.findElement(By.xpath("//select[@id='page-menu']"));
		   Select sc = new Select(Pagesize);
		   sc.selectByIndex(1);
		   
		   /*sort it into Ascending order*/
		   d.findElement(By.xpath("//span[@class='sort-icon sort-descending']")).click();
		   
		   /*fetch the table data*/
		   List<WebElement> ascend = d.findElements(By.xpath("//tr[contains(.,'')]"));
		   for(WebElement a:ascend)
		   {
			   String ascendorder = a.getText();
			   System.out.println(ascendorder);
		   }
		  
		   d.quit();
}
}
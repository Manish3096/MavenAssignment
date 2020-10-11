package com.tyss.IndiaToday.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class VerifyAd {
	static 
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) {
       
		ChromeOptions options = new ChromeOptions();
		 options.addArguments("--disable-notifications");
		 WebDriver d = new ChromeDriver(options);
		/*Maximize window*/
		d.manage().window().maximize();
		/*Wait condition*/
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*Navigate to the url*/
		d.get("https://www.indiatoday.in/");
	    
		/*Click on hamburger icon */
		d.findElement(By.xpath("//li[@class='all-menu']")).click();
		
		/*Click on Education*/
		d.findElement(By.xpath("(//a[.='Education'])[2]")).click();
		
		/*ad is visible*/
		WebElement ads = d.findElement(By.xpath("//div[.='advertisement']"));
		String ad1 = ads.getText();
		boolean ad = ads.isDisplayed();
		if(ad)
		{
			System.out.println(ad1+" is displayed");
		}
		else {
			System.out.println("Ad is not displayed");
		}
		
		d.close();
	}
	
}

package com.tyss.IndiaToday.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class IndiaTodayVerify {
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
		
		/*close the Covid-19 popup*/
		d.findElement(By.cssSelector("div#twister>button.crosscloseif")).click();
		
		/*Verify text*/
		WebElement text = d.findElement(By.xpath("//ul[@class='itg-listing']/../../div/ul/li[1]"));
		text.click();
		WebElement t = d.findElement(By.xpath("//h1[@itemprop='headline']"));
		boolean textmsg = t.isDisplayed();
		
		if( textmsg ){
             String topstory = text.getText(); 
             String actual = t.getText();
             JavascriptExecutor js = (JavascriptExecutor) d;
             js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", t);
			System.out.println(topstory+" is displayed");
			Assert.assertEquals(actual, topstory);
			System.out.println(topstory+" is displayed");

			}else{

			System.out.println("Text is not Present");

			}
		  
		
		
		
	}

}

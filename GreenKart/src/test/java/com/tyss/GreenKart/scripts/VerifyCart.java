package com.tyss.GreenKart.scripts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.sql.rowset.WebRowSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyCart {
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

		/*Enter ca in Search textfield*/
		d.findElement(By.xpath("//input[@type='search']")).sendKeys("ca");

		
		List<WebElement> pname = d.findElements(By.xpath("//h4[@class='product-name']"));
		
		for(int i=0;i<3;i++) {
			String veg = pname.get(i).getText();
			System.out.println(veg);
		}
		/*Fetch all the Add to cart button*/
		List<WebElement> addto = d.findElements(By.xpath("//h4[contains(.,'Ca')]/../div/following-sibling::div/button"));
		
		for(int i=0;i<3;i++)
		{
			WebElement add1 = addto.get(i);
			
			add1.click();
			
		}
 
		

        /* Click on Cart*/
		d.findElement(By.xpath("//img[@class=' ']")).click();

		/* Click on Procced to Checkout button*/
		d.findElement(By.xpath("//button[.='PROCEED TO CHECKOUT']")).click();

		/*Fetch the Quantity of each vegetable*/
		
		String ExpectedTotalAmount = d.findElement(By.xpath("//span[@class='totAmt']")).getText();
		String ActualTotalAmount = "176";
		if(ExpectedTotalAmount==ActualTotalAmount)
		{
			System.out.println("Total Amount added is :"+ExpectedTotalAmount);
		}

		/* Enter Promo code*/
		d.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");

		/* Click on Apply Promo code*/
		d.findElement(By.xpath("//button[@class='promoBtn']")).click();

		/* Click on Place Order button*/
		d.findElement(By.xpath("//button[.='Place Order']")).click();

		/* Select India as Country*/
		WebElement selectcountry = d.findElement(By.xpath("//select[@style='width: 200px;']"));
		Select sc = new Select(selectcountry);
		sc.selectByVisibleText("India");

		/* Click on Agree Terms and Conditions*/
		d.findElement(By.xpath("//input[@class='chkAgree']")).click();

		/* Click on Procced button*/
		d.findElement(By.xpath("//button[.='Proceed']")).click();

		d.close();


	}
}

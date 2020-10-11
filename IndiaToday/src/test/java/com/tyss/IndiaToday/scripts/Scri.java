package com.tyss.IndiaToday.scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Scri {
	public static void main(String[] args) throws IOException {



		File file = new File("./src/main/resources/data/Data.xlsx");
		XSSFWorkbook wb=null;
		XSSFSheet sh=null;

		try {
			FileInputStream fis =new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			sh = wb.getSheet("Smartphone");

			sh.createRow(0).createCell(0).setCellValue("SmartPhone Brand");
			sh.createRow(0).createCell(1).setCellValue("SmartPhone Price");
			sh.createRow(0).createCell(2).setCellValue("SmartPhone Discount Price");
			sh.createRow(0).createCell(3).setCellValue("SmartPhone Discounted percentage");

			FileOutputStream fos = new FileOutputStream(file);
			wb.write(fos);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}
}


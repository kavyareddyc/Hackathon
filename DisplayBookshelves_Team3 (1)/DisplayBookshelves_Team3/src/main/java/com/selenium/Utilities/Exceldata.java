package com.selenium.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldata {
	
	// variables declaration
		public static FileInputStream fis;
		public static FileOutputStream fos;
		public static XSSFWorkbook workbook;
		public static XSSFSheet sheet;
		public static XSSFRow row;
		Properties prop;
		public static String userDir = System.getProperty("user.dir");

		// Setting properties file for input
		public Properties inputSetup() {
			File file = new File(userDir + "\\driver\\config.properties");

			try {
				fis = new FileInputStream(file);
				prop = new Properties();
				prop.load(fis);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return prop;
		}

		public static void output(String[] prodname) throws Exception {
			workbook = new XSSFWorkbook();
			sheet = workbook.createSheet("Collection");
			// iterating rows and printing the headphones with price
			for (int i = 0; i < 15; i++) {
				row = sheet.createRow(i);
				row.createCell(0).setCellValue(prodname[i]);

			}

			sheet.autoSizeColumn(0);
			// Writing the output to Excel file using FileOutputStream
			try {
				fos = new FileOutputStream("Collection.xlsx");
				workbook.write(fos);
				fos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		public static void output1(String[] name, String[] price) {
			workbook = new XSSFWorkbook();
			sheet = workbook.createSheet("BookShelves");
			for (int i = 0; i < 3; i++) {
				row = sheet.createRow(i);
				row.createCell(0).setCellValue(name[i]);
				row.createCell(1).setCellValue(price[i]);
			}

			sheet.autoSizeColumn(0);
			// Writing the output to Excel file using FileOutputStream
			try {
				fos = new FileOutputStream("BookShelves.xlsx");
				workbook.write(fos);
				fos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public static String readData(int a, int b)throws Exception{
			
			//locating the path of credentials file 
			String location = System.getProperty("user.dir") + "\\ExcelInput\\Input.xlsx";
			
			//new file with location
			File file = new File(location);
			FileInputStream fileInputStream = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			String data = sheet.getRow(a).getCell(b).getStringCellValue();
			workbook.close();
			
			return data;

		}
		
       	
}
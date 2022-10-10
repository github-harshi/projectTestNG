package com.framework.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	//This class will have methods to read excel
	
	public static String [][] readData(String Workbook, String Sheet){
		String [][] data = null;
		
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\"+Workbook); //reading the file (java class)
			XSSFWorkbook wb = new XSSFWorkbook(fis); // reading workbook (apache poi)
			XSSFSheet sh = wb.getSheet(Sheet);// read sheet
			int totalrows = sh.getPhysicalNumberOfRows(); //total rows with test data
			int totalcolumns = sh.getRow(0).getPhysicalNumberOfCells(); // total columns with data in row 1
			data = new String [totalrows-1][totalcolumns]; //specify length of array
			for(int r=1; r<totalrows;r++) { 
				for(int c=0;c<totalcolumns;c++) {
					data[r-1][c] = sh.getRow(r).getCell(c).getStringCellValue();  //store data in 2d array
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return data;		
	}

}

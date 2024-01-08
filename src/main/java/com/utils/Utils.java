package com.utils;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class Utils {

	static String filepath = "./src/main/java/com/testdata/Ecommerce (1).xlsx";
	public static Robot rb;
	
	
	// Store all commonly used methods for method reusablity purpose

	public static String[][] setdata(String sheetname) throws Throwable {

		File file = new File(filepath);
		FileInputStream stream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(stream);
		XSSFSheet sheet = workbook.getSheet(sheetname);

		int rows = sheet.getPhysicalNumberOfRows();
		int columns = sheet.getRow(1).getLastCellNum();
		String[][] data = new String[rows - 1][columns];

		for (int i = 0; i < rows - 1; i++) {
			for (int j = 0; j < columns; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
			}
		}

		workbook.close();
		stream.close();
		return data;

	}
	
	public static void keysRobot() throws Throwable {
		rb=new Robot();
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
	}
	
	public static void enterRobot() throws Throwable {
		rb=new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static boolean isElementEnable(WebElement w) {
		
			boolean element_enable=w.isEnabled();
			return element_enable;

		
	}
	
	public static boolean isElementSelected(WebElement w) {
		boolean element_select=w.isSelected();
		return element_select;
	}
	
	public static boolean containsString(String s1,String s2) {
		s1=s1.replaceAll("[^a-zA-Z0-9]", "");
		s2=s2.replaceAll("[^a-zA-Z0-9]", "");
		if(s1.contains(s2)) {
			return true;
		}
		
		return false;
	}

}
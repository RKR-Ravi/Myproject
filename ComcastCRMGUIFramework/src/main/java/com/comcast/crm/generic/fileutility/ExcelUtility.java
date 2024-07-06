package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;

public class ExcelUtility {
	
	public String getDataFromExcel(String sheetName,int rowNum,int celNum) throws Throwable {
		
		FileInputStream fis=new FileInputStream("./testdata/Sample.XLSX");
		Workbook wb=WorkbookFactory.create(fis);
		String data =wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		wb.close();

		return data;
	}
	
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis=new FileInputStream("./testdata/Sample.XLSX");
		Workbook wb=WorkbookFactory.create(fis);
		int rowCount=wb.getSheet(sheetName).getLastRowNum();
		wb.close();

		return rowCount;
	}
	
	public void setDataIntoExcel(String sheetName,int rowNum,int celNum,List<WebElement> pname,List<WebElement> Pprice) throws Throwable {
		
		FileInputStream fis=new FileInputStream("./testdata/Sample.XLSX");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(celNum);
		
		FileOutputStream fos=new FileOutputStream("./testdata/Sample.XLSX");
		wb.write(fos);
		wb.close();
		
	}
public void setDataIntoExcel(String sheetName,int rowNum,int celNum,String data) throws Throwable {
		
		FileInputStream fis=new FileInputStream("./testdata/Sample.XLSX");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(celNum);
		
		FileOutputStream fos=new FileOutputStream("./testdata/Sample.XLSX");
		wb.write(fos);
		wb.close();
		
	}

}

package com.test.automation.uiAutomationNew.excelReader;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reader {
	
	public String path;
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	



	public Excel_Reader(String path)
	{
		this.path = path ;
		//Here path is the local variable as well as global variable
		//that's why to differentiate between local variable and global variable we use (this) key word
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e)
		{
			e.printStackTrace();
			
		}
		
		
	}
	
	@SuppressWarnings({ "deprecation", "unused" })
	public String[][] getDataFromSheet(String sheetName, String ExcelName)
	{ 
		
		String dataSets[][] = null;
try {	//get sheet from excel workbook
		XSSFSheet sheet = workbook.getSheet(sheetName);
		//count number of active row
		int totalRow = sheet.getLastRowNum()+1;
		//count number of active columns in row
		int totalColumn = sheet.getRow(0).getLastCellNum();
		//create array of rows and column
		dataSets = new String [totalRow - 1][totalColumn];
		
		//run for loop to store the data in 2D array
		//this for loop will run on rows
		
		for(int i = 1; i<totalRow; i++)
		{
			XSSFRow rows = sheet.getRow(i);
			
			for (int j = 0; j<totalColumn; j++)
			{
				XSSFCell cell = rows.getCell(j);
			
			//if cell of type string then this if condition will work
			
			if(cell.getCellType()== Cell.CELL_TYPE_STRING)
				dataSets[i-1][j]=  cell.getStringCellValue();
			//if cell of type number 
			
			else if (cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
				
			{
				String cellText = String.valueOf(cell.getNumericCellValue());
				dataSets[i-1][j] = cellText;
				
			} //if cell type of boolean
			
			else 
				dataSets[i-1][j] = String.valueOf(cell.getBooleanCellValue());
			}
		
		}	
			return dataSets;
		
		 }
		catch (Exception e) {
			System.out.println("Exception in reading Xlsx file "+ e.getMessage());
			e.printStackTrace();
		}
			
		
		return dataSets;
			
		}
		
	
	@SuppressWarnings("deprecation")
	public String getCellData(String sheetName, String colName, int rowNum)
	{
		
		
		try {
			int col_Num = 0;
			
			int index = workbook.getSheetIndex(sheetName);
			sheet = workbook.getSheetAt(index);
			XSSFRow row = sheet.getRow(0);
			for(int i =0; i<row.getLastCellNum(); i++)
			{
				if (row.getCell(i).getStringCellValue().equals(colName))
				{
					col_Num = i;
					
					break;
				}
			}
			
			row = sheet.getRow(rowNum - 1);
			
			XSSFCell cell = row.getCell(col_Num);
			if(cell.getCellType()==Cell.CELL_TYPE_STRING)
			{
				return cell.getStringCellValue();
			} else if (cell.getCellType()==Cell.CELL_TYPE_BLANK)
			{
				return "";
			}
		}		
			
		
		 catch (Exception e )
		{
			 e.printStackTrace();
		}
		
		return null;
		
		
		
	}
		
}

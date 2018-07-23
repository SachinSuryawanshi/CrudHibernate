package com.scp.Util;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {
	public static void main(String[] args){
		readTestData();
	}
	
	
	public static Object[][] readTestData(){
		//Object [][] testData = new Object[row][coln];
		Object [][] testData = new Object[4][3];
		//4 -- No of records
		//3 -- No of values in each record
		
		int rowCount = 0;
		int cellCount = 0;
		
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook("C:\\Users\\Sachin\\Desktop\\Book1.xlsx");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		try{
			XSSFSheet sheet = workbook.getSheet("data");
			Iterator<Row> rows = sheet.iterator();
			
			boolean flag = true;
			
			while(rows.hasNext()){
									Row singleRow = rows.next();
									if(flag){
										flag=false; //just to skip thead
										continue;
									}
									
									System.out.println("\n");
									Iterator<Cell> cells = singleRow.iterator();
											while(cells.hasNext()){
													Cell singleCell = cells.next();
													
													if(singleCell.getCellType()==0){
													System.out.print((int)singleCell.getNumericCellValue() +" | ");
													}else if(singleCell.getCellType()==1){
														String cellValue = singleCell.getStringCellValue().equals("NA") ? null : singleCell.getStringCellValue();
													
													/*	if("S.No".equals(cellValue))
															continue;*/
														testData[rowCount][cellCount] = cellValue;
														cellCount++;
														System.out.print(cellValue +" | ");
													}else{
														System.out.println("Invalid cell type -- "+singleCell.getCellType());
													}
											}
											rowCount++;
											cellCount=0;
			}	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(workbook!=null)
					workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return testData;
	}
	
	
}

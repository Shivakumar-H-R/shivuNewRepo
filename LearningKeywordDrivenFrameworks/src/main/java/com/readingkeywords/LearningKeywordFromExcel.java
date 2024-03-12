package com.readingkeywords;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import actions.KeywordActions;

public class LearningKeywordFromExcel {
   @Test
	public static ArrayList readingKeywords() throws EncryptedDocumentException, IOException, InterruptedException {
		File file=new File("./src/test/resources/ExcelFile/Testcases.xlsx");
		FileInputStream fis=new FileInputStream(file);
		
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet=workbook.getSheet("Sheet1");
		
		int rowNum=sheet.getPhysicalNumberOfRows();
		int colNum=sheet.getRow(0).getPhysicalNumberOfCells();
		
		
		ArrayList keywords=new ArrayList();
		for(int i=1;i<rowNum;i++) {
			//reading data from excel sheet
			String data=sheet.getRow(i).getCell(colNum-1).toString();
			keywords.add(data);
			System.out.println(data);
		}
        
	 return keywords;
	}
}

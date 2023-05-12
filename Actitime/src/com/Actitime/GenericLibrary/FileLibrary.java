package com.Actitime.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this is generic class used read data from generic method
 * @author dellb
 *
 */
public class FileLibrary {
	
	
	/**
	 * this is a generic method which is used to read data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String readDataFromProperty(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./Testdata/commondata.property");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
		}
	/**
	 * this is a generic method which is used to read data from excel file
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String readDataFromExcel(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis1=new FileInputStream("./Testdata/TESTDATA.xlsx");
		Workbook wb= WorkbookFactory.create(fis1);
		String data = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return data; 
		
	}

}

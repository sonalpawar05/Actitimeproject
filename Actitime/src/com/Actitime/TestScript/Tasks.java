package com.Actitime.TestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Actitime.GenericLibrary.Baseclass;
import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.ObjectRepository.Homepage;
import com.Actitime.ObjectRepository.Taskpage;

public class Tasks extends Baseclass{
	@Test
	public void createcustomer() throws EncryptedDocumentException, IOException, InterruptedException {
		Homepage hp=new Homepage(driver);
		hp.getTasktab().click();
		
		Taskpage tp=new Taskpage(driver);
		tp.getAddnewbt().click();
		tp.getNewcustomer().click();
		
		FileLibrary f=new FileLibrary();
		Thread.sleep(3000);
		String name = f.readDataFromExcel("Sheet1", 1, 1);
        tp.getCustomername().sendKeys(name);
		Thread.sleep(3000);
		String des = f.readDataFromExcel("Sheet1", 1, 2);
		tp.getDescrip().sendKeys(des);
		tp.getCreatecus().click();
		String expectedresult = name;
		String actualresult = driver.findElement(By.xpath(("(//div[.='"+name+"'])[2]"))).getText();
		SoftAssert s=new SoftAssert();
		s.assertEquals(actualresult, expectedresult);
		s.assertAll();
		
		
		
		
		
		
	}

}

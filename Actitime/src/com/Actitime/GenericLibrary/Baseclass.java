package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.Actitime.ObjectRepository.Homepage;
import com.Actitime.ObjectRepository.Loginpage;

public class Baseclass {
	FileLibrary f=new FileLibrary();
	public static WebDriver driver;
	@BeforeSuite
	public void databaseconnection() {
		Reporter.log("database connected successfully",true);
	}
	@BeforeTest
	public void launch() throws IOException {
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String URL = f.readDataFromProperty("url");
		driver.get(URL);
		Reporter.log("browser launch",true);
	}
	@BeforeMethod
	public void login() throws IOException {
		Loginpage l=new Loginpage(driver);
		String un = f.readDataFromProperty("username");
		l.getUntbx().sendKeys(un);
		String pwd = f.readDataFromProperty("password");
		l.getPwdbx().sendKeys(pwd);
		l.getLb().click();
		Reporter.log("login successfully",true);
		
        //		driver.findElement(By.id("username")).sendKeys(un);
		//		driver.findElement(By.name("pwd")).sendKeys(pwd);
       //		driver.findElement(By.xpath("//div[text()='login ']")).click();
		
		
	}
	@AfterMethod
	public void logout() throws InterruptedException {
		Thread.sleep(3000);
		Homepage hp=new Homepage(driver);
		hp.getLogouttab().click();
		Reporter.log("logout successfully",true);
		
	}
	@AfterTest 
	public void close() {
		driver.close();
		Reporter.log("browser close",true);
	}
	
	
	@AfterSuite
	public void databasedisconnection() {
		Reporter.log("database disconnected successfully",true);
	}
	

}

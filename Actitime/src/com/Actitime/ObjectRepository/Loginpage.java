package com.Actitime.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	//declaration
	@FindBy(id="username")
	private WebElement untbx;
	
	@FindBy(name="pwd")
	private WebElement pwdbx;
	
	@FindBy(xpath="//div[text()='Login ']")
	private WebElement lb;
	
	//initilization
	 public Loginpage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
		 
	 }
	 //utilization

	public WebElement getUntbx() {
		return untbx;
	}

	public WebElement getPwdbx() {
		return pwdbx;
	}

	public WebElement getLb() {
		return lb;
	}
	 
	

}

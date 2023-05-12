package com.Actitime.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Taskpage {
	@FindBy(xpath="//div[.='Add New']")
	private WebElement addnewbt;
	
	@FindBy(xpath="//div[.='+ New Customer']")
	private WebElement newcustomer;
	
	@FindBy(xpath="(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement customername;
	
	@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
	private WebElement descrip;
	
	@FindBy(xpath="//div[.='Create Customer']")
	private WebElement createcus;
	
	@FindBy(xpath="//div[@class='greyButton cancelBtn']")
	private WebElement cancel;
	
	public Taskpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddnewbt() {
		return addnewbt;
	}

	public WebElement getNewcustomer() {
		return newcustomer;
	}

	public WebElement getCustomername() {
		return customername;
	}

	public WebElement getDescrip() {
		return descrip;
	}

	public WebElement getCreatecus() {
		return createcus;
	}

	public WebElement getCancel() {
		return cancel;
	}
	
	
	
	

}

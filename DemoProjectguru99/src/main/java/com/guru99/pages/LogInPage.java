package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

WebDriver driver;
	
	@FindBy (name = "uid")
	WebElement userId;
	
	@FindBy (name = "password")
	WebElement pwd;
	
	@FindBy (name = "btnLogin")
	WebElement logIn;
	
	@FindBy (name = "btnReset")
	WebElement resetBtn;
	
	
	public LogInPage (WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName (String userName) {
		
		userId.sendKeys(userName);
	}
	
	public void setPassword (String password) {
		
		pwd.sendKeys(password);
	}
	
	public void clickLogin () {
		
		logIn.click();
	}
	
	public String getTitle () {
		
		return driver.getTitle();
	}
	public void Login (String uname, String pwd) {
		
		this.setUserName(uname);
		this.setPassword(pwd);
		this.clickLogin();
	}
	
	
}

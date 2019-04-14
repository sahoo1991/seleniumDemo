package com.guru99.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.guru99.pages.LogInPage;

public class TestGuru99Login {
	
	WebDriver driver;
	LogInPage logPage;
	
  @Test
  public void testLogIn() {
	  
	  logPage = new LogInPage (driver);
	  logPage.Login("mngr189401", "apajUpY");
  }
  @BeforeTest
  public void setUp () {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\sahoo\\Downloads\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver ();
	  driver.get("http://www.demo.guru99.com/V4/");
  }

  @AfterTest
  public void afterTest() {
	  
	  driver.close();
  }


}

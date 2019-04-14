package com.guru99.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99.pages.LogInPage;

public class TestGuru99Login {
	
	WebDriver driver;
	LogInPage logPage;
	
  @Test (dataProvider = "excelData")
  public void testLogIn(String uname, String pwd) {
	  
	  logPage = new LogInPage (driver);
	  logPage.Login(uname, pwd);
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

  @DataProvider (name = "excelData")
  public static Object [][] readDataFromExcel () throws IOException {
	  
	  Object ob [][] = new Object [4][2];
	  FileInputStream fis = new FileInputStream("./utils/login.xlsx");
	  
	  XSSFWorkbook xsf = new XSSFWorkbook(fis);
	  
	  XSSFSheet xsh = xsf.getSheet("login");
	  
	  int rowCount = (xsh.getLastRowNum() - xsh.getFirstRowNum()) +1;
	  
	  int counter = 0;

	  for (int i = 1; i< rowCount; i++) {
		  
		  Row row = xsh.getRow(i);
		  
		  ob [counter][0] = row.getCell(0).getStringCellValue();
		  ob [counter][1] = row.getCell(1).getStringCellValue();
		  
		  counter ++;
	  }

	  
	  
	return ob;
	  
  }

}

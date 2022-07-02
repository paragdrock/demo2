package utility;

import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import pages.LoginPage;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class NewTest {
	WebDriver driver = null;
	LoginPage lp = null;

	@BeforeClass
	public void driverOpener() throws Exception {
		driver = DriverOpener.chromeDriverOpener();
		lp = new LoginPage(driver);
	}

	@Test(dataProvider = "dp")
	public void credentialsTest(String email, String pass, String emailErr, String passErr) {
		if (driver.getTitle().equals("JavaByKiran | Dashboard"))
			driver.findElement(By.partialLinkText("LOGOUT")).click();
		lp.clearingTextboxes();
		lp.usname.sendKeys(email);
		lp.password.sendKeys(pass);
		lp.signinbutton.click();
		if (driver.getTitle().equals("JavaByKiran | Dashboard"))
			Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
		else {
			Assert.assertEquals(driver.findElement(By.id("email_error")).getText(), emailErr);
			Assert.assertEquals(driver.findElement(By.id("password_error")).getText(), passErr);
		}

	}

	@DataProvider
	public Object[][] dp() throws Exception {
		FileInputStream fileInputStream = new FileInputStream("excel.xls");
		Workbook workbook = Workbook.getWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet("Sheet2");
		int rows = sheet.getRows();
		int col = sheet.getColumns();
		String[][] data = new String[rows][col];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < col; j++) {
				Cell cell = sheet.getCell(j, i);
				String celldata = cell.getContents();
				data[i][j] = celldata;

			}
		}
		return data;

	}
}

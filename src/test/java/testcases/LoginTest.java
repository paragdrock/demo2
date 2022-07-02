 package testcases;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import utility.DriverOpener;

public class LoginTest {
	WebDriver driver = null;
	LoginPage lp = null;

	@BeforeClass
	public void driverOpener() throws Exception {
		driver = DriverOpener.chromeDriverOpener();
		lp = new LoginPage(driver);
	}

	@Test(priority = -1)
	public void checkTitle() {
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "JavaByKiran | Log in");
	}

	@Test(priority = 2)
	public void checkLogo() {
		Assert.assertTrue(lp.checkImg());
	}

	@Test(priority = 3)
	public void JBkText() {
		Assert.assertEquals(lp.JBKtext.getText(), "Java By Kiran");
	}

	@Test(priority = 4)
	public void jspText() {
		Assert.assertEquals(lp.JSPtext.getText(), "JAVA | SELENIUM | PYTHON");
	}

	@Test(priority = 5)
	public void siggInText() {
		Assert.assertEquals(lp.signintext.getText(), "Sign in to start your session");
	}

	@Test(dataProviderClass = LoginPage.class, dataProvider = "loginCredential", priority = 6)
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

	@Test(priority = 5)
	public void backgroundColorCheck() {
		WebElement color = driver.findElement(By.xpath("/html/body"));
		String bgc = color.getCssValue("background-color");
		String hex = Color.fromString(bgc).asHex();
		Assert.assertEquals(hex, "#d2d6de");
	}

	@AfterClass
	public void closingDriver() {
		driver.close();
	}

}

package testcases;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.RegistrationPage;
import utility.DriverOpener;

public class RegistrationPageTest {
	WebDriver driver=null;
	RegistrationPage rp=null;
	LoginPage lp=null;
	
	@BeforeClass
	public void driverOpener() throws Exception {
		driver = DriverOpener.chromeDriverOpener();
		lp= new LoginPage(driver);
		rp=lp.getRegistrationPage();
	}
@Test(priority=1)
	public void titleCheck(){
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Registration Page");
	}
	@Test(priority=2)
	public void jbkTextCheck(){
		Assert.assertEquals(rp.jbkText.getText(), "Java By Kiran");
	}
	@Test(priority=3)
	public void registerANewMembershipTextCheck(){
		Assert.assertEquals(rp.registerANewMembershipText.getText(), "Register a new membership");
	}
	@Test(priority=4)
	public void hyperlinkiAlreadyHaveAMembershipCheck(){
		rp.iAlreadyHaveAMembership.click();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");
	}
	
	@Test()
	public void validCredCheck() throws InterruptedException{
		Thread.sleep(500);
		if (driver.getTitle().equals("JavaByKiran | Log in")) 
			lp.registrationButton.click();
			rp.clearingInputs();
		rp.registerANewMembershipCred("parag", "9890949069", "parag@gmail.com","98basdfa");
		driver.switchTo().alert().accept();
		
		
		}
	
	@Test()
	public void verifyingInputsDisplaying(){
		
		if (driver.getTitle().equals("JavaByKiran | Log in")) 
			lp.registrationButton.click();
		Assert.assertTrue(rp.isDisplay());
	
		}
@Test(dataProviderClass = RegistrationPage.class, dataProvider = "errRegistrationCredential")
	public void errRegistrationCredentialCheck
(String name, String mobile, String email, String pass,String nameErr, String mobileErr, String emailErr, String passErr) 
	{
	if (driver.getTitle().equals("JavaByKiran | Log in")) 
		lp.registrationButton.click();
		
	rp.clearingInputs();
		rp.name.sendKeys(name);
		rp.mobile.sendKeys(mobile);
		rp.email.sendKeys(email);
		rp.password.sendKeys(pass);
		rp.signinbutton.click();
	Assert.assertEquals(rp.name_err.getText(), nameErr);
	Assert.assertEquals(rp.mobile_err.getText(), mobileErr);
	Assert.assertEquals(rp.email_err.getText(), emailErr);
	Assert.assertEquals(rp.password_err.getText(), passErr);
	
	}

@Test(priority = 5)
public void backgroundColorCheck() {
	WebElement color = driver.findElement(By.xpath("/html/body"));
	String bgc = color.getCssValue("background-color");
	String hex = Color.fromString(bgc).asHex();
	Assert.assertEquals(hex, "#d2d6de");
}

	@AfterClass
	public void closingDriver()
	{
		driver.close();
	}

}

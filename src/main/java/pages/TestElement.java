package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.DriverOpener;

public class TestElement {
	public static void main(String[] args) throws Exception {
		WebDriver driver = DriverOpener.chromeDriverOpener();
		LoginPage lp = new LoginPage(driver);
		DashboardPage dp  = lp.getDashboardPage();
		
		List<WebElement>we  =dp.coursesName;
		for (WebElement webElement : we) {
			System.out.println(webElement.getText());
		}
		List<WebElement>we1= dp.moreInfoLink;
		for (WebElement webElement : we1) {
			Thread.sleep(3000);
			webElement.click();
		
		}
		//driver.quit();
		
	}


}

package utility;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;

public class Dataprovider {

  @Test(dataProvider = "loginCredential")
  public void credentialsTest(String n, String s) {
  }

  @DataProvider
  public Object[][] loginCredential() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
}

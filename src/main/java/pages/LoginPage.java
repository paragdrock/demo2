package pages;

import java.io.FileInputStream;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class LoginPage {
	WebDriver driver =null;
	@FindBy(xpath="//b")public WebElement JBKtext;
	@FindBy(xpath="//h4")public WebElement JSPtext;
	@FindBy(xpath="//img")public WebElement img;
	@FindBy(xpath="//p")public WebElement signintext;
	@FindBy(id="email")public WebElement usname;
	@FindBy(id="password")public WebElement password;
	@FindBy(tagName="button")public WebElement signinbutton;
	@FindBy(id="email_error")public WebElement email_error;
	@FindBy(id="password_error")public WebElement password_error;
	@FindBy(xpath="//div[@id='email_error']")public WebElement enterkiranerr;
	@FindBy(xpath="//div[@id='password_error']")public WebElement enter123456err;
	@FindBy(xpath="//a[text()]")public WebElement registrationButton;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
//initElements() used to initialize WebElements declared in the page class
	}      
	//actions
	public boolean checkImg(){
		boolean flag;
		flag= img.isDisplayed();
		return flag;
	}
	public void loginCredential(String uname, String password){
		usname.sendKeys(uname);
		this.password.sendKeys(password);
		signinbutton.click();
	}
	public void clearingTextboxes(){
		usname.clear();
		password.clear();
	}
	public RegistrationPage getRegistrationPage(){
		registrationButton.click();
		return new RegistrationPage(driver);
	}
	public DashboardPage  getDashboardPage(){
		usname.sendKeys("kiran@gmail.com");
		password.sendKeys("123456");
		signinbutton.click();
		return new DashboardPage(driver);
		}
	@DataProvider
	  public static Object[][] loginCredential() throws Exception {
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

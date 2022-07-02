package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

public class RegistrationPage {
@FindBy(xpath = "//b")public WebElement jbkText;
@FindBy(xpath = "//p")public WebElement registerANewMembershipText;
@FindBy(id = "name")public WebElement name;
@FindBy(id = "mobile")public WebElement mobile;
@FindBy(id = "email")public WebElement email;
@FindBy(id = "password")public WebElement password;
@FindBy(xpath = "//input")public List<WebElement> inputs;
@FindBy(xpath = "//div[@id]")public List<WebElement> credentialserrMsg;
@FindBy(xpath = "//a[text()]")public WebElement iAlreadyHaveAMembership;
@FindBy(xpath = "//button")public WebElement signinbutton;
@FindBy(xpath = "//*[contains(@id,'name_error')]")public WebElement name_err;
@FindBy(xpath = "//*[@id='mobile_error']")public WebElement mobile_err;
@FindBy(xpath = "//*[@id='email_error' or text()='Please enter Email.']")public WebElement email_err;
@FindBy(xpath="//*[@id='password_error' and @style='color:red;']")public WebElement password_err;

	public RegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void registerANewMembershipCred(String name, String mobile, String email, String passwrd) {
		this.name.sendKeys(name);
		this.mobile.sendKeys(mobile);
		this.email.sendKeys(email);
		this.password.sendKeys(passwrd);
		signinbutton.click();
	}

	public boolean isDisplay() {
		boolean b = false;
		for (WebElement webElement : inputs) {
			if (webElement.isDisplayed() == true) {
				b = true;
			} else
				b = false;
		}
		return b;
	}

	public List<String> ExptBlankErrmsgs() {
		List<String> em = new ArrayList<String>();
		em.add("Please enter Name.");
		em.add("Please enter Mobile.");
		em.add("Please enter Email.");
		em.add("Please enter Password.");
		System.out.println("ExptBlankErrmsgs");
		System.out.println(em);
		return em;
	}

	public List<String> actBlankErrmsgs() {
		List<String> em = new ArrayList<String>();
		for (WebElement err : credentialserrMsg) {
			em.add(err.getText());
		}
		System.out.println("actBlankErrmsgs");
		System.out.println(em);
		return em;
	}
public void clearingInputs(){
	/*name.clear();
	mobile.clear();
	email.clear();
	password.clear();*/
	for (WebElement webElement : inputs) {
		webElement.clear();
	}
}
	@DataProvider
	public static Object[][] errRegistrationCredential() {
		return new Object[][] {
new Object[] 
{ "", "", "", "", "Please enter Name.", "Please enter Mobile.", "Please enter Email.","Please enter Password." },
new Object[] 
{ "parag","","", "", "", "Please enter Mobile.", "Please enter Email.","Please enter Password." },
new Object[] 
{ "parag","989092","", "", "", "", "Please enter Email.","Please enter Password." },
new Object[] 
{ "parag","989092","parag@gmail.com", "", "", "", "","Please enter Password." },
new Object[] 
{ "", "", "", "34tfsg", "Please enter Name.", "Please enter Mobile.", "Please enter Email.","" },
new Object[] 
{ "", "98909", "parag@gmail.com", "34tfsg", "Please enter Name.", "", "","" },
		};
	}
}
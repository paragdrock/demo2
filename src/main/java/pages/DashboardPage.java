package pages;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class DashboardPage {
@FindBy(xpath="//b[text()='Java By Kiran']")public WebElement jbkhyperlink;//title check dashB
@FindBy(xpath="//a[text()=' Online']")public WebElement Online;//isDisply
@FindBy(xpath="//img]")public WebElement img;//isDisply
@FindBy(xpath="//*[text()='MAIN NAVIGATION']]")public WebElement MAIN_NAVIGATION;//text confirm
@FindBy(partialLinkText="Dashboard")public WebElement dashboardLink;//title check dashB
@FindBy(partialLinkText="Users")public WebElement UsersLink;//title check Users
@FindBy(partialLinkText="Operators")public WebElement OperatorsLink;//title check Operators//  
@FindBy(partialLinkText="Useful Links")public WebElement  Useful_LinkssLink;//title check  Useful Links// 
@FindBy(partialLinkText="Downloads")public WebElement  DownloadsLink;//title check  Downloads
@FindBy(partialLinkText="Logout")public WebElement  LogoutLink;//title check  login
@FindBy(partialLinkText="LOGOUT")public WebElement  LOGOUTLink;//title check  login
@FindBy(xpath="//*[text()='Courses Offered']")public WebElement Courses_Offered;//text confirm
@FindBy(xpath="//h1")public WebElement dashboradText;//text confirm Dashboard Courses Offered]
@FindBy(xpath="//a[text()=' Home']")public WebElement Home;//title check dashB  
@FindBy(xpath="//*[text()='Dashboard' and @class]")public WebElement dashboardTextafterHome;//text check
@FindBy(xpath="//a[text()='More info ']")public List<WebElement> moreInfoLink;//
@FindBy(xpath="//h3")public List<WebElement> coursesName;//text check

public DashboardPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}


}

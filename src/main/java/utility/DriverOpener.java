package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverOpener {
	public static WebDriver chromeDriverOpener() throws Exception{
		FileInputStream fileInputStream = new FileInputStream("config.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		String url = properties.getProperty("url");
		String chromepath = properties.getProperty("chromepath");
		String chromeexe= properties.getProperty("chromeexe");
		System.setProperty(chromepath, chromeexe);
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		return driver;
	}
}

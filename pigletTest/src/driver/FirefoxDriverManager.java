package driver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager {
	
	@Override
	public void createWebDriver() {
		System.setProperty("webdriver.firefox.driver","Drivers\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		this.driver = new FirefoxDriver();
	}
}

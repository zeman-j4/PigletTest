package driver;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class IeDriverManager extends DriverManager {
	
	@Override
	public void createWebDriver() {
		System.setProperty("webdriver.internetExplorer.driver","C:\\Users\\lucie\\eclipse-workspace\\Selenium_tests\\Drivers\\IEDriverServers.exe");
		InternetExplorerOptions options = new InternetExplorerOptions();
		this.driver = new InternetExplorerDriver(options);
	}
}
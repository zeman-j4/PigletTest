package driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {

	@Override
	public void createWebDriver() {
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		this.driver = new ChromeDriver(options);
	}
}

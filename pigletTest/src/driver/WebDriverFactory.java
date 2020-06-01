package driver;

import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverManager.DriverType;
import utility.Constant;
import xpath.StfuAndClickXpath;

public class WebDriverFactory {

	static WebDriver driver = null;

	public static WebDriver initWebDriver() {
		DriverManager driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
		driver = driverManager.getWebDriver();
		driver.get(Constant.url);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(StfuAndClickXpath.bTeamNameXPath)));
		return driver;
	}

	public static WebDriver getWebDriver() {
		return driver;
	}

	public static boolean isElementPresent(String xpath) {

		try {
			driver.findElement(By.xpath(xpath));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void clickOn(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public static void maximalizeWindow() {
		driver.manage().window().maximize();
	}

	public static void scrollByVisibleElement(String xpath) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(xpath));
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public static boolean waitForElement(String xpath, long timeOutInSeconds) throws InterruptedException {
		boolean result = false;
		LocalDateTime start = LocalDateTime.now();
		long durationInSeconds = 0;
		boolean pageLoaded = false;
		while (!pageLoaded && durationInSeconds < timeOutInSeconds) {
			durationInSeconds = Duration.between(start, LocalDateTime.now()).getSeconds();
			try {
				driver = getWebDriver();
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
				pageLoaded = true;
				result = true;
			} catch (Exception e) {
				Thread.sleep(1000);
			}
		}
		return result;
	}

	public static boolean waitForElement(String xpath) throws InterruptedException {
		Thread.sleep(1000);
		boolean result = waitForElement(xpath, 60);
		return result;
	}

	public static void refreshPage() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(3000);
	}
}

package methods;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driver.WebDriverFactory;
import xpath.StfuAndClickXpath;

public class StfuAndClickMethod {

	static WebDriver driver = WebDriverFactory.getWebDriver();

	public static void waitForElement(String xpath) throws InterruptedException {
		assertTrue(WebDriverFactory.waitForElement(xpath));
	}

	public static void clickOn(String xpath) throws InterruptedException {
//		waitForElement(xpath);
		WebDriverFactory.clickOn(xpath);
	}

	public static void clickOnMultipleTimes(String xpath, int numberOfClicks) throws InterruptedException {

		waitForElement(StfuAndClickXpath.buttonClickXPath);
		for (int i = 0; i < numberOfClicks; i++) {
			clickOn(xpath);
		}
	}

	public static int getMyCountOfClicks() throws InterruptedException {
		Thread.sleep(50);
		waitForElement(StfuAndClickXpath.pNumberOfYourClicksXPath);
		driver = WebDriverFactory.getWebDriver();
		String count = driver.findElement(By.xpath(StfuAndClickXpath.pNumberOfYourClicksXPath)).getText();
		int number = convertStringToInteger(count);
		return number;
	}

	public static int convertStringToInteger(String myString) {
		String digits = myString.replaceAll("[^0-9]", "");
		int number = Integer.parseInt(digits);
		return number;
	}
}

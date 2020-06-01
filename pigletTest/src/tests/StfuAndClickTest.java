package tests;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import driver.WebDriverFactory;
import methods.StfuAndClickMethod;
import xpath.StfuAndClickXpath;

public class StfuAndClickTest {

	WebDriver driver = null;

	@Before
	public void before() {

		driver = WebDriverFactory.initWebDriver();
	}

	@After
	public void closeBrowser() {

		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		driver = null;
	}

	@Test
	public void clickMultipleTimes() throws InterruptedException {

		int numberOfClicks = 50000;
		StfuAndClickMethod.clickOnMultipleTimes(StfuAndClickXpath.buttonClickXPath, numberOfClicks);
		int yourClicks = StfuAndClickMethod.getMyCountOfClicks();
		assertTrue(numberOfClicks == yourClicks);

		System.out.println("clickMultipleTimes finished successfully.");
	}
}

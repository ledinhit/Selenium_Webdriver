package Demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import java.util.List;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class TC_02_DemoElementVsElements {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "F:\\DemoSelenium\\Browser\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get("http://demo.guru99.com/test/ajax.html");
	}

	@Test
	public void TC_01_Element() {
		// find radio button No and click
		driver.findElement(By.id("no")).click();
		// find button Check and click
		driver.findElement(By.id("buttoncheck")).click();
		// get notify
		String notifyMes = driver.findElement(By.className("radiobutton")).getText();
		// Verify notify
		assertEquals(notifyMes, "Radio button is checked and it's value is No");

	}

	@Test
	public void TC_02_Elements() {
		// find Elements radio button
		List<WebElement> listRadio = driver.findElements(By.name("name"));
		System.out.println("Number of elements: "+ listRadio.size());
		for (int i = 0; i < listRadio.size(); i++) {
			System.out.println("Radio button text:" +listRadio.get(i).getAttribute("value"));
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}

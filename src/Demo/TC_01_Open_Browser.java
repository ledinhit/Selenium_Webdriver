package Demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TC_01_Open_Browser {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "F:\\DemoSelenium\\Browser\\chromedriver.exe");
		// System.setProperty("webdriver.gecko.driver","F:\\DemoSelenium\\Browser\\geckodriver.exe");
		// driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://app.omisell.com/authentication/login");
	}

	@Test
	public void TC_01_ValidateCurrentUrl() {
		// Login Page Url matching
		//// String loginPageUrl = driver.getCurrentUrl();
		// System.out.println(loginPageUrl);
		// Assert.assertEquals(loginPageUrl, "http://demo.guru99.com/v4/");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}

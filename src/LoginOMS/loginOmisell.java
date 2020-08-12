package LoginOMS;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

public class loginOmisell {
	WebDriver driver;
	By emailTextBox = By.xpath("//input[@type='email']");
	By passwordTextBox = By.xpath("//input[@type='password']");
	By loginButton = By.xpath("//button[@type='submit']");
	Select selectCountry;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://app.omisell.com/authentication/login");
	}

	// @Test
	/*
	 * public void TC_01_ValidateCurrentUrl() {
	 * driver.get("https://app.omisell.com/authentication/login"); // Login Page Url
	 * matching String loginPageUrl = driver.getCurrentUrl(); //
	 * System.out.println(loginPageUrl); Assert.assertEquals(loginPageUrl,
	 * "https://app.omisell.com/authentication/login"); }
	 */

	@Test
	public void TC_02_LoginCorrect() throws InterruptedException {
		// locator
		// css: tagname[attribute='value']
		// path: //tagname[@attribute='value']
 //Xpath = //a[contains(text(),'thủ thuật CSS')]
		// selectCountry =
		// driver.findElement(By.xpath("//span[contains(.,'Thailand')]")).click();
		// driver.findElement(By.xpath("//span[contains(.,'Thailand')]")).click();

		/*
		 * selectCountry = new Select(driver.findElement(By.cssSelector(
		 * "ng-select[formcontrolname='country']")));
		 * selectCountry.selectByVisibleText("Thailand");
		 */
		/*
		 * driver.findElement(By.xpath("//input[@type='email']")).sendKeys(
		 * "dinhlt@boxme.asia"); Thread.sleep(4000);
		 * driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456a@"
		 * ); Thread.sleep(4000);
		 * driver.findElement(By.xpath("//button[@type='submit']")).click();
		 * Thread.sleep(4000);
		 */

		// input email
		driver.findElement(emailTextBox).click();
		driver.findElement(emailTextBox).sendKeys("dinhlt@boxme.asia");
		// input pass
		driver.findElement(passwordTextBox).click();
		driver.findElement(passwordTextBox).sendKeys("123456a@");
		// click Login
		driver.findElement(loginButton).click();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}

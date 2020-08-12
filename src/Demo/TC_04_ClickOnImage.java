package Demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class TC_04_ClickOnImage {
	WebDriver driver;
	WebElement radio1, radio2, radio3;

	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://www.facebook.com/login/identify?ctx=recover");
	}

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
	}

	@Test
	public void TC_01_clickOnImage() {
		System.out.println("========TC_01_clickOnImage========");

		// click on the "Facebook" logo on the upper left portion
		driver.findElement(By.cssSelector("a[title='Vào Trang chủ Facebook']")).click();
		
		//get title
		
		System.out.println(driver.getTitle());

		// verify that we are now back on Facebook's homepage
		/*
		 * if (driver.getTitle().equals("Facebook - log in or sign up")) {
		 * System.out.println("We are back at Facebook's homepage"); } else {
		 * System.out.println("We are NOT in Facebook's homepage"); }
		 */

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}

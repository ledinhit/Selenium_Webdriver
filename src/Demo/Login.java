package Demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class Login {

	WebDriver driver;
	By emailTextBox = By.id("email");
	By passwordTextBox = By.id("pass");
	By loginButton = By.id("send2");
	Select selectCountry;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get("http://live.demoguru99.com/index.php/customer/account/login/");
	}

	@Test
	public void TC_01_LoginWithEmailPassEmpty() {
		// input emai
		driver.findElement(emailTextBox).sendKeys("");
		// input pass
		driver.findElement(passwordTextBox).sendKeys("");
		// click Login
		driver.findElement(loginButton).click();
		// verify error message email
		String emailErroMessage = driver.findElement(By.id("advice-required-entry-email")).getText();
		assertEquals(emailErroMessage, "This is a required field.");
		// verify error message pass
		String passErroMessage = driver.findElement(By.id("advice-required-entry-pass")).getText();
		assertEquals(passErroMessage, "This is a required field.");

	}

	@Test
	public void TC_02_LoginWithEmailInvalid() {
		// input emai
		driver.findElement(emailTextBox).sendKeys("ledinh@123");
		// input pass
		driver.findElement(passwordTextBox).sendKeys("123456");
		// click Login
		driver.findElement(loginButton).click();
		// verify error message email
		String emailInvalidMessage = driver.findElement(By.id("advice-validate-email-email")).getText();
		assertEquals(emailInvalidMessage, "Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test
	public void TC_03_LoginWithPassInvalid() {
		// input emai
		driver.findElement(emailTextBox).sendKeys("ledinh@gmail.com");
		// input pass
		driver.findElement(passwordTextBox).sendKeys("123");
		// click Login
		driver.findElement(loginButton).click();
		// verify error message email
		String passInvalidMessage = driver.findElement(By.id("advice-validate-password-pass")).getText();
		assertEquals(passInvalidMessage, "Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void TC_04_LoginEmailOrPassIncorrect() {
		// input emai
		driver.findElement(emailTextBox).sendKeys("ledinh@gmail.com");
		// input pass
		driver.findElement(passwordTextBox).sendKeys("123123");
		// click Login
		driver.findElement(loginButton).click();
		// verify error message email
		String emailOrPassIncorrectMessage = driver.findElement(By.xpath("//li[@class='error-msg']//span")).getText();
		assertEquals(emailOrPassIncorrectMessage, "Invalid login or password.");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}

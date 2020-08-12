package Demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class TC_03_Demo_RadioVsCheckBox {
	WebDriver driver;
	WebElement radio1, radio2, radio3;

	@BeforeMethod
	public void beforeMethod() {
		driver.get("http://demo.guru99.com/test/radio.html");
	}

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
	}

	@Test
	public void TC_01_selectRadio() {

		System.out.println("========TC_01_selectRadio========");
		radio1 = driver.findElement(By.id("vfb-7-1"));
		radio2 = driver.findElement(By.id("vfb-7-2"));
		radio3 = driver.findElement(By.id("vfb-7-3"));

		// radio button1 is select
		radio1.click();
		// check button1 isSelect
		System.out.println("radio button 1:" + radio1.isSelected());
	}

	@Test
	public void TC_02_selectRadios() {
		System.out.println("========TC_02_selectRadios========");
		List<WebElement> listRadio = driver.findElements(By.xpath("//input[@type='radio']"));
		// click radio
		for (WebElement radio : listRadio) {
			radio.click();
			System.out.println("Radio button text is select: " + radio.getAttribute("value"));
		}
	}

	@Test
	public void TC_03_selectCheckBox() {
		System.out.println("========TC_03_selectCheckBox========");
		List<WebElement> listCheckBox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		// click radio
		for (WebElement select : listCheckBox) {
			select.click();
			System.out.println(select.getAttribute("value") + " is select: " + select.isSelected());
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}

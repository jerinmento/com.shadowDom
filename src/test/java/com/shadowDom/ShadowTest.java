package com.shadowDom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ShadowTest {
	WebDriver driver;
	//private String actual;
	@BeforeTest
	public void setup()
	{
		
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("chrome://downloads/");
	}
	@Test
	public void googleDownloads() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement text=(WebElement)js.executeScript("return document.querySelector(\"body > downloads-manager\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#search\").shadowRoot.querySelector(\"#searchInput\")");
		text.sendKeys("selenium");
		String actual = driver.getTitle();
		System.out.println("actual value is "+ actual);
		assertEquals(actual,"Downloads", "The title is \"Downloads\" not actual");
	}

}

package com.herokuapp.theinternet;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTest {
	@Test
	public void loginTest() {

		System.out.println("Starting login page");
		// Create Driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// sleep for 3 second
		sleep(3000);

		// maximize browser windows
		driver.manage().window().maximize();

		// open test page

		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		System.out.println("Page is open");

		// sleep for 3 second
		sleep(2000);

		// enter username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");
		sleep(1000);

		// enetr passwork
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("SuperSecretPassword!");
		sleep(1000);

		// click login button

		WebElement logInButton = driver.findElement(By.tagName("button"));
		logInButton.click();
		sleep(5000);

		// verification
		// new url
		String expectedUrl = "https://the-internet.herokuapp.com/secure";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Acual page url is not the same as expected");

		// logout button is visible
		WebElement logOutButton = driver.findElement(By.xpath("//<a[@class='button secondary radius']"));
		Assert.assertTrue(logOutButton.isDisplayed(), "Logout button is not visible");
		// succesful login message

		WebElement logOutSuccessMessage = driver.findElement(By.cssSelector("#flash"));

		// closed browser
		driver.quit();
	}

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			e.printStackTrace();

		}
	}

}

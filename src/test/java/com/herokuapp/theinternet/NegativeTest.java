package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NegativeTest {
	
	
	public void incorectUserNameTest()
	{
		System.out.println("Starting login page");
		// Create Driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// maximise briwser windows
		driver.manage().window().maximize();
		// open test page
		
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		System.out.println("Page is open");

		// sleep for 3 second

		// enter username
		
		WebElement username = driver.findElement(By.id("username"));
		
		// enetr passwork
		
		WebElement password = driver.findElement(By.name("password"));
		
		// click login button
		
		WebElement logInButton = driver.findElement(By.tagName("button"));
		logInButton.click();

	}
}

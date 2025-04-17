package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.LandingPage;


public class basicTests {

	@Test
	public void userLogin() {
		System.out.println("hello");
		// TODO Auto-generated method stub
		String productName = "ZARA COAT 3";
		
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		options.addArguments("headless");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		LandingPage landingPage = new LandingPage(driver);
		landingPage.loginApplications("razin.qa@example.com", "Justdoit@123");
		
		String homeText = driver.findElement(By.xpath("//section[@id='sidebar']/p")).getText();

		System.out.println(homeText);
		
		System.out.println(homeText.contains("Home"));
		
		Assert.assertTrue(homeText.contains("Home"));
		driver.close();
	}

	@Test
	public void secondTest() {
		System.out.println("Second test");
	}
}

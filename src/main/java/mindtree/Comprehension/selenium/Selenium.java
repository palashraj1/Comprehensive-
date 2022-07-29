package mindtree.Comprehension.selenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Selenium {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tide.com/en-us");
		System.out.println(driver.getTitle());
		
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@class='lilo3746-close-link lilo3746-close-icon']")).click();
		
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.linkText("Sign up now")).click();
		
		String current = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for(String actual : windows) {
			if(!actual.equalsIgnoreCase(current)) {
				driver.switchTo().window(actual);
				driver.get("https://www.pggoodeveryday.com/signup/tide-coupons/");
			}
		}
		driver.findElement(By.id("name")).sendKeys("palash");
		driver.findElement(By.id("email")).sendKeys("palashraj73@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Palash@123");
		
		driver.findElement(By.xpath("//input[@value='CREATE ACCOUNT']")).click();
		
		current = driver.getWindowHandle();
		windows = driver.getWindowHandles();
		for(String actual : windows) {
			if(!actual.equalsIgnoreCase(current)) {
				driver.switchTo().window(actual);
				driver.get("https://tide.com/en-us");
			}
		}
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
		search.click();
		search.sendKeys("tide");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.get("https://tide.com/en-us");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("Shop Products"))).build().perform();
		driver.findElement(By.linkText("Liquid")).click();
		
	}

}

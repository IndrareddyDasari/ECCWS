package com.eccanada.Institutions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Test {

	static WebDriver driver;
	

	public void EccWebsite() {

	
			try {
				System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.get("https://www.eccanada.com");
				driver.findElement(By.xpath("//*[@id=\"button\"]")).click();
				Actions action = new Actions(driver);
				action.moveToElement(driver.findElement(By.cssSelector(".navigation_ul > li:nth-child(2) > a:nth-child(1)")))
						.perform();
				driver.findElement(
						By.cssSelector(".collage-unv > li:nth-child(12) > a:nth-child(1) > p:nth-child(1) > span:nth-child(1)"))
						.click();
				Thread.sleep(3000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,800)", "");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@class='area-of-interest-list position-list']")).click();
				Thread.sleep(3000);
				//driver.findElement(By.xpath("//*[@id='credentials_503']")).click();
				WebElement ele = driver.findElement(By.id("credentials_503"));
				
				js.executeScript("arguments[0].click();", ele);
				js.executeScript("arguments[0].click();",driver.findElement(By.cssSelector(".alphabetical-series > ul:nth-child(1) > li:nth-child(8)")));
				
				//WebElement program = driver.findElement(By.cssSelector("tr.main-table-row:nth-child(1) > td:nth-child(1)"));
				
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				driver.findElement(By.xpath("/html/body/div[3]/section[4]/div/div/table/tbody/tr[3]/td[6]")).click();
		
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}



	public static void main(String[] args) {
		Test ecc = new Test();
		ecc.EccWebsite();
	
	}
}
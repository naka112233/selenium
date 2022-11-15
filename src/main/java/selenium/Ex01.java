package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ex01 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.google.co.jp/");
		Thread.sleep(2000);
	    WebElement element = driver.findElement(By.cssSelector("div.a4bIc>input"));
	    Thread.sleep(2000);
	    element.sendKeys("selenium");
		Thread.sleep(2000);
	    element.sendKeys(Keys.ENTER);
	}

}

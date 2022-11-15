package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.google.co.jp/");
		Thread.sleep(2000);
	    WebElement element = driver.findElement(By.cssSelector("div.a4bIc>input"));
	    //List<WebElement> elements = driver.findElements(By.cssSelector("div.a4bIc"));
	    Thread.sleep(2000);
	    //WebElement elem1 = elements.get(3);
	    //elem1.click();
	    //driver.find ずっと存在
	    element.sendKeys("CSSセレクタとは？");
		Thread.sleep(2000);
	    element.sendKeys(Keys.ENTER);
	    //driver.close();
	}
}


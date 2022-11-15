package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ex02 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://rakuplus.jp/");
		Thread.sleep(1000);
		//メールアドレス
		driver.findElement(By.xpath("//*[@id=\"user_login\"]")).sendKeys("");
		Thread.sleep(1000);
		//パスワード
		driver.findElement(By.xpath("//*[@id=\"user_pass\"]")).sendKeys("");
		//チェックボックス
		driver.findElement(By.cssSelector("#loginform > p.forgetmenot > label")).click();
		Thread.sleep(1000);
		//ログインボタン
		driver.findElement(By.cssSelector("#wp-submit")).click();
		//ページ遷移
		driver.get("https://rakuplus.jp/archives/11203");
		Thread.sleep(1000);
		//取得
	    WebElement sectionElem = driver.findElement(By.cssSelector("section.entry-content.cf"));
	    //System.out.println(sectionElem.getText());
	    sectionElem.findElement(By.cssSelector("div"));

	    List<WebElement> divElemList = sectionElem.findElements(By.cssSelector("div.is-layout-flow.wp-block-column.is-vertically-aligned-top.visual"));
	    
	    int count = 0;
	    for(WebElement elem : divElemList) {
	    if(count > 0) {

	    	//名前
	    	WebElement spanElm = elem.findElement(By.cssSelector("span.big"));
	    	System.out.println(spanElm.getText());
	    	//なまえ
	    	WebElement pElm = elem.findElement(By.cssSelector("div.is-layout-flow.wp-block-column.is-vertically-aligned-top.visual > p"));
	    	System.out.println(pElm.getText());	    	
	    	//写真
	    	WebElement imgElm = elem.findElement(By.tagName("img"));
	    	String url = imgElm.getAttribute("src");
	    	System.out.println(url);

	    }
	   count++;
	}

	}
	
}

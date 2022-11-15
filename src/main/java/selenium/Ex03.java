package selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ex03 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.e-procurement.metro.tokyo.lg.jp/index.jsp");
		
		Set<String> handles = driver.getWindowHandles();
		
		Thread.sleep(1000);

		//リンク1
		driver.findElement(By.cssSelector("#category_menu > ul > li.cat_menu_1 > a:nth-child(1) > img")).click();

		//タブ切り替え
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		
		//リンク2
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#topMenuBtn03 > a")).click();
		//開始日
		Thread.sleep(1000);
		driver.findElement(By.name("StartDateYY")).sendKeys("4");
		driver.findElement(By.name("StartDateMM")).sendKeys("11");
		driver.findElement(By.name("StartDateDD")).sendKeys("15");
		//終了日
		Thread.sleep(1000);
		driver.findElement(By.name("EndDateYY")).sendKeys("4");
		driver.findElement(By.name("EndDateMM")).sendKeys("12");
		driver.findElement(By.name("EndDateDD")).sendKeys("15");
		//検索実行
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("body > div.contents > div > form > table:nth-child(5) > tbody > tr:nth-child(3) > td > table:nth-child(2) > tbody > tr > td > a")).click();
		//出力
		//テーブル
		WebElement tableElem = driver.findElement(By.cssSelector("table.list-data"));
		    //System.out.println(tableElem.getText());
		    tableElem.findElement(By.cssSelector("tr"));
		//trリスト
		List<WebElement> trElemLists = tableElem.findElements(By.tagName("tr"));
	    for(WebElement trelem : trElemLists) {
	    	//tdリスト
			List<WebElement> tdElemLists = tableElem.findElements(By.tagName("td"));
			int count = 0;
			for(WebElement tdelem : tdElemLists) {
				if (count < 3) {
					System.out.println(tdelem.getText() + "\t");
				}
					if(count == 2){
						String hrefStr = tdelem.findElement(By.tagName("a")).getAttribute("href");
						System.out.println(hrefStr + "\t");
					}
				count++;
			}
	    	//System.out.println(tdelem.getText());	   
			}
		//driver.close();
	}
}
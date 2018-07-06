package mentoring;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://orbitz.com");
		driver.findElement(By.cssSelector("#primary-header-deals")).click();
		driver.findElement(By.xpath("(//a[@class='change-lob'])[4]")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//input[@id='A-destination']")).sendKeys(" washington DC"+Keys.ENTER);
	
		driver.findElement(By.xpath("//a[@aria-label='Washington, D.C. Day Tour from New York']")).click();
		
		
		Set<String> ids = driver.getWindowHandles();  
		Iterator<String> it = ids.iterator();  
		String parentid = it.next();
		String childid = it.next();
		
		System.out.println(driver.getTitle());
		driver.switchTo().window(childid);
		System.out.println(driver.getTitle());
		
		

	}

}

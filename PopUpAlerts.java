package mentoring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PopUpAlerts {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		
		//==============Simple Alert=================
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		driver.switchTo().alert().accept();
		
		//================Alert with Accept/Dismiss buttons===================
		driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']")).click();
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		
		//============Alert with Text Field===================================
		driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().sendKeys("CyberTek");
		driver.switchTo().alert().accept();
		
		
		
		
		
	}

}

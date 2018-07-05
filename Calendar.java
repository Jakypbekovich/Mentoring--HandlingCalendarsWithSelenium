package mentoring;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calendar {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://hotels.com");

		String year = "2019";
		String month = "Jan";
		String day = "10";

		String year1 = "2019";
		String month1 = "Mar";
		String day2 = "28";

		driver.findElement(By.cssSelector("#qf-0q-localised-check-in")).click();
		String monthYear = driver.findElement(By.cssSelector(".widget-datepicker-label")).getText();

		while (!driver.findElement(By.cssSelector(".widget-datepicker-label")).getText().contains(year)) {
			driver.findElement(By.xpath("(//button[@aria-label='Next month'])[2]")).click();
		}
		while (!driver.findElement(By.cssSelector(".widget-datepicker-label")).getText().contains(month)) {
			driver.findElement(By.xpath("(//button[@aria-label='Next month'])[2]")).click();
		}

		int countDays = driver.findElements(By.xpath("(//div[@class='widget-datepicker-bd'])[1]/table/tbody/tr/td"))
				.size();
		List<WebElement> days = driver
				.findElements(By.xpath("(//div[@class='widget-datepicker-bd'])[1]/table/tbody/tr/td"));

		// ========Using for loop===========
		// for(int i=0; i<countDays; i++) {
		// String day1 = days.get(i).getText();
		// if(day1.contains(day)) {
		// days.get(i).click();
		// }
		// }
		// ===========Using For Each loop=========

		for (WebElement e : days) {
			if (e.getText().contains(day))
				e.click();
		}
		// ===========Check-Out===================
		driver.findElement(By.cssSelector("#qf-0q-localised-check-out")).click();

		while (!driver.findElement(By.cssSelector(".widget-datepicker-label")).getText().contains(year1)) {
			driver.findElement(By.xpath("(//button[@aria-label='Next month'])[2]")).click();
		}
		while (!driver.findElement(By.cssSelector(".widget-datepicker-label")).getText().contains(month1)) {
			driver.findElement(By.xpath("(//button[@aria-label='Next month'])[2]")).click();
		}

		int countDays1 = driver.findElements(By.xpath("(//div[@class='widget-datepicker-bd'])[1]/table/tbody/tr/td"))
				.size();
		List<WebElement> days1 = driver
				.findElements(By.xpath("(//div[@class='widget-datepicker-bd'])[1]/table/tbody/tr/td"));
		for (int i = 0; i < countDays; i++) {
			String day1 = days1.get(i).getText();
			if (day1.contains(day2)) {
				days1.get(i).click();
			}
		}
	}

}

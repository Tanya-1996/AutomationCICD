package rahulshettyacademy.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    // System.setProperty("webdriver.gecko.driver", "D:\\Gecko\\geckodriver.exe");
     WebDriver driver =new FirefoxDriver();
     driver.get("https://www.amazon.in/");
     WebElement driver1= driver.findElement(By.id("nav-xshop-container"));
    driver1.findElement(By.linkText("Amazon miniTV")).click();
	}

}

package rahulshettyacademy.pageobject;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAlone {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String email="leotanya.kishore@gmail.com";
      String pass="Hello@123";

      WebDriver driver=new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.get("https://rahulshettyacademy.com/client");
      driver.manage().window().maximize();
      driver.findElement(By.cssSelector("input[type='email']")).sendKeys(email);
      driver.findElement(By.xpath("//input[@formcontrolname='userPassword']")).sendKeys(pass);
      driver.findElement(By.id("login")).click();
      WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
      List<WebElement>products=driver.findElements(By.cssSelector(".mb-3"));
       WebElement prod=products.stream().filter(product-> 
       product.findElement(By.cssSelector(".card-body b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
       prod.findElement(By.cssSelector(".btn.w-10.rounded")).click();
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));

       driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
       List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
      Boolean match= cartProducts.stream().anyMatch(cartpro->cartpro.getText().equalsIgnoreCase("ZARA COAT 3"));
      Assert.assertTrue(match);
      JavascriptExecutor js = (JavascriptExecutor) driver;
      WebElement element = driver.findElement(By.cssSelector(".totalRow button"));
      js.executeScript("arguments[0].scrollIntoView(true);", element);
      wait.until(ExpectedConditions.visibilityOf(element));
      js.executeScript("arguments[0].click();", element);
         WebElement element1=driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
         //js.executeScript("arguments[0].value='Ind';", element1);
         element1.sendKeys("Ind");
         
         
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
     
    driver.findElement(By.cssSelector(".ta-results")).click();
      driver.findElement(By.cssSelector(".action__submit")).click();
//      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));
//      
//      String lastPage=driver.findElement(By.cssSelector(".hero-primary")).getText();
//      System.out.println(lastPage);
//      Assert.assertEquals(lastPage, "THANKYOU FOR THE ORDER.");
//      
//      driver.quit();
	}

}

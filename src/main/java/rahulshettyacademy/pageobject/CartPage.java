package rahulshettyacademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import rahulshettyacademy.AbstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent {
     WebDriver driver;
	public CartPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	


	@FindBy(css=".totalRow button")
	WebElement Checkoutbutton;
	
public Boolean productAddedCart(String productname) {
    Boolean match= cartProducts.stream().anyMatch(cartpro->cartpro.getText().equalsIgnoreCase(productname));
    return match;

}


public CheckoutPage gotocheckout() {
	//Checkoutbutton.click();
	JavascriptExecutor js = (JavascriptExecutor) driver;
    WebElement element = driver.findElement(By.cssSelector(".totalRow button"));
    js.executeScript("arguments[0].scrollIntoView(true);", element);
    visibilityWait(element);
    //wait.until(ExpectedConditions.visibilityOf(element));
    js.executeScript("arguments[0].click();", element);
	CheckoutPage checkoutpage=new CheckoutPage(driver);
	return checkoutpage;
}

}

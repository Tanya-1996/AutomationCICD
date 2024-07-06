package rahulshettyacademy.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobject.CartPage;
import rahulshettyacademy.pageobject.OrderPage;

public class AbstractComponent {
    
    WebDriver driver;
    OrderPage orderpage;
    
    public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
    	this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	public void visibilityWait(By FindBy) {
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));

    }
	
	public void visibilityWait(WebElement wait1) {
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(wait1));

    }
	
	public void invisibilityWait(By FindBy) {
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(FindBy));

    }
	
//	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
//	WebElement CartHeaderlink;


	@FindBy(css="[routerlink*='cart']")
	WebElement CartHeaderlink;

	public CartPage goToCart() {
     CartHeaderlink.click();
     CartPage cartpage = new CartPage(driver);
		return cartpage;
	}
	
	//driver.findElement(By.cssSelector(".hero-primary")).getText();
	
	@FindBy(css=".hero-primary")
	WebElement Thankyoupagetext;
	
	public String getThankyoupage() {
	String lastPage=Thankyoupagetext.getText();
	return lastPage;
	}
	
	@FindBy(css="button[routerlink='/dashboard/myorders']")
	WebElement Orderbutton;
	
    public OrderPage goToOrderPage() {
    	Orderbutton.click();
		orderpage=new OrderPage(driver);
		return orderpage;
	}
}

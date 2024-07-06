package rahulshettyacademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponent.AbstractComponent;

public class CatalogPage extends AbstractComponent{
     WebDriver driver;
	public CatalogPage(WebDriver driver){
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css=".mb-3")
	List<WebElement> products;
    
	public List<WebElement> getproducts() {
		visibilityWait(By.cssSelector(".mb-3"));
		return products;
	}
	
	By cartButton=By.cssSelector(".btn.w-10.rounded");
    By toastwait=By.cssSelector("#toast-container");
    By animatewait= By.cssSelector(".ng-animating");
	
	public WebElement getProductName(String productname) {
		 WebElement prod=getproducts().stream().filter(product-> 
	     product.findElement(By.cssSelector(".card-body b")).getText().equals(productname)).findFirst().orElse(null);
		 return prod;
	}
	
	
	
	public void addToCart(String productname) {
		  WebElement prod=getProductName(productname);
		getProductName(productname).findElement(cartButton).click();
		visibilityWait(toastwait);
		invisibilityWait(animatewait);
		

	}
	
	
}

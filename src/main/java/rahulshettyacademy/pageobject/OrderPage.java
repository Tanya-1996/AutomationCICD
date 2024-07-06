package rahulshettyacademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponent.AbstractComponent;

public class OrderPage extends AbstractComponent{
	WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);

		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css="tr td:nth-of-type(2)")
	List<WebElement> orderProducts;
	
	public Boolean productAddedCart(String productname) {
	    Boolean match= orderProducts.stream().anyMatch(cartpro->cartpro.getText().equalsIgnoreCase(productname));
	    return match;

	}

		
	

}

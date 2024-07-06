package rahulshettyacademy.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponent.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
     WebDriver driver;
	public CheckoutPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
@FindBy(xpath="//input[@placeholder='Select Country']")
WebElement Country;

By dropdownvalue=By.cssSelector(".ta-results");
	
@FindBy(css=".ta-item:nth-of-type(2)")
WebElement dropdownvaluecountry;


@FindBy(css=".action__submit")
WebElement Submit;

By thankyoutext=By.cssSelector(".hero-primary");
public void selectCountry(String countryname ) {
//    Actions a=new Actions(driver);
//    a.sendKeys(Country,countryname).build().perform();
	WebElement element1=driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
    element1.sendKeys(countryname);
    visibilityWait(dropdownvalue);
    dropdownvaluecountry.click();
    goToThankyouPage();
}

public void goToThankyouPage() {
	Submit.click();
    visibilityWait(thankyoutext);
    
    getThankyoupage();
}

}

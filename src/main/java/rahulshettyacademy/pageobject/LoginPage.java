package rahulshettyacademy.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponent.AbstractComponent;

public class LoginPage extends AbstractComponent {
     WebDriver driver;
	public LoginPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

@FindBy(css="input[type='email']")
WebElement Username;
	
@FindBy(xpath="//input[@formcontrolname='userPassword']")
WebElement Password;


@FindBy(id="login")
WebElement Submit;

@FindBy(id="toast-container")
WebElement error;


public CatalogPage loginApplication(String username,String pass) {
	Username.sendKeys(username);
	Password.sendKeys(pass);
	Submit.click();
	CatalogPage cp = new CatalogPage(driver);
    return cp;
       
}
public void applicationUrl() {
    driver.get("https://rahulshettyacademy.com/client");
}

public String getErrorText() {
	visibilityWait(error);
return error.getText();
}
}

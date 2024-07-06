package rahulshettyacademy.Test;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponent.BaseTest;
import rahulshettyacademy.pageobject.CatalogPage;

public class ErrorValidation extends BaseTest {
	
	@Test(groups= {"sanity"})
	public void SubmitOrder() throws IOException{
		// Email,password and product name 
		String email = "leotanya.kishore@gmai.com";
		String pass = "Hello@123";
		
		//Initialize driver
		CatalogPage cp=lp.loginApplication(email, pass);
		String error=lp.getErrorText();
		System.out.println(error);
		Assert.assertEquals(error, "Incorrect email or password.");
		
	
	}

}

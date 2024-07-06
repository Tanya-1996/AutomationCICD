package rahulshettyacademy.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponent.BaseTest;
import rahulshettyacademy.pageobject.CatalogPage;
import rahulshettyacademy.pageobject.OrderPage;

public class VerifyOrderPageProduct extends BaseTest {
	
	@Test(groups= {"sanity"})
	public void VerifyOrder() {
		// Email,password and product name 
		String email = "leotanya.kishore@gmail.com";
		String pass = "Hello@123";
		String productName = "ZARA COAT 3";

		CatalogPage cp=lp.loginApplication(email, pass);
		OrderPage orderpage =cp.goToOrderPage();
		Assert.assertTrue(orderpage.productAddedCart(productName));
		}
}
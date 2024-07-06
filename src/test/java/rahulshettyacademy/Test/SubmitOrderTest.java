package rahulshettyacademy.Test;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponent.BaseTest;
import rahulshettyacademy.pageobject.CartPage;
import rahulshettyacademy.pageobject.LoginPage;

import rahulshettyacademy.pageobject.CatalogPage;
import rahulshettyacademy.pageobject.CheckoutPage;

public class SubmitOrderTest extends BaseTest {
	
	@Test(dataProvider= "data")
	public void SubmitOrder(HashMap<String,String> input) throws IOException{
		// Email,password and product name 
//		String email = "leotanya.kishore@gmail.com";
//		String pass = "Hello@123";
//		String productName = "ZARA COAT 3";
		CatalogPage cp=lp.loginApplication(input.get("email"), input.get("pass"));
		//Moving to catalog page
		List<WebElement> products=cp.getproducts();
		cp.addToCart(input.get("productName"));
		
		//Moving to cart page
		CartPage cartpage=cp.goToCart();
		Boolean match = cartpage.productAddedCart(input.get("productName"));
		//Verify product
		Assert.assertTrue(match);
		//Moved to checkout page
		CheckoutPage checkoutpage = cartpage.gotocheckout();
		//selecting country
		checkoutpage.selectCountry("Ind");
         //Verify whether we are getting confirmation page or not
		String lastPage = checkoutpage.getThankyoupage();
		System.out.println(lastPage);
		Assert.assertEquals(lastPage, "THANKYOU FOR THE ORDER.");
	}
	
//1 way with object
	
//	@DataProvider
//	public Object[][] data() {
//		return new Object[][]{{"leotanya.kishore@gmail.com","Hello@123","ZARA COAT 3"},{"leotkishore96@gmail.com","Hello@123","ADIDAS ORIGINAL"}};
//	}

//2nd way with HashMap	
//	@DataProvider
//	public Object[][] data() {
//		HashMap<String,String> map= new HashMap();
//		map.put("email", "leotanya.kishore@gmail.com");
//		map.put("pass", "Hello@123");
//		map.put("productName", "ZARA COAT 3");
//		
//		HashMap<String,String> map1= new HashMap();
//		map1.put("email", "leotkishore96@gmail.com");
//		map1.put("pass", "Hello@123");
//		map1.put("productName", "ADIDAS ORIGINAL");
//
//		return new Object[][]{{map},{map1}};
//	}
//	
	
	//3rd way
	
	@DataProvider
	public Object[][] data() throws IOException {
		
		 List<HashMap<String,String>> data =getJsonDataToMap(System.getProperty("user.dir")+"//src//main//java//rahulshettyacademic//data//Purchase.json");
		return new Object[][]{{data.get(0)},{data.get(1)}};
	}
		
}

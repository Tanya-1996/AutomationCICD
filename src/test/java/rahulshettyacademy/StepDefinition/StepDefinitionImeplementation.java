package rahulshettyacademy.StepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponent.BaseTest;
import rahulshettyacademy.pageobject.CartPage;
import rahulshettyacademy.pageobject.CatalogPage;
import rahulshettyacademy.pageobject.CheckoutPage;
import rahulshettyacademy.pageobject.LoginPage;

public class StepDefinitionImeplementation extends BaseTest {
	public LoginPage lp;
	public CatalogPage cp;
	public CartPage cartpage;
	public String lastPage;

	@Given("i have landed on ecommerce page")
	public void i_Have_Landed_On_Ecommerce_Page() throws IOException {
		lp=launchApplication();
		System.out.println("Tanya");
	    throw new io.cucumber.java.PendingException();

		 
	}
	
    @Given ("^Logged in with username(.+) and password(.+)$")
    public void Logged_In_With_Username_And_Password(String username,String Pass){
    	
		 cp=lp.loginApplication(username, Pass);
		    throw new io.cucumber.java.PendingException();


    }
    @When("^I add product (.+) to cart$")
    public void I_Add_Product_To_Cart(String productname) {
    	List<WebElement> products=cp.getproducts();
		cp.addToCart(productname);
	    throw new io.cucumber.java.PendingException();

    }
    @When("^And checkout (.+) and submit the order$")
    public void And_Checkout_And_Submit_The_Order (String productname) {
     cartpage=cp.goToCart();
	Boolean match = cartpage.productAddedCart(productname);
	Assert.assertTrue(match);//product verified
	
	//Submitting order
	CheckoutPage checkoutpage = cartpage.gotocheckout();
	//selecting country
	checkoutpage.selectCountry("Ind");
     //Verify whether we are getting confirmation page or not
	 lastPage = checkoutpage.getThankyoupage();
	    throw new io.cucumber.java.PendingException();

	
    }
    
    //Then "THANKYOU FOR THE ORDER." message is displayed on the confirmation page.
    
    @Then(" Then {string} message is displayed on the confirmation page.")
    public void  Then_message_is_displayed_on_the_confirmation_page(String string) {
    	System.out.println(lastPage);
    	Assert.assertEquals(lastPage, string);
        throw new io.cucumber.java.PendingException();

    }
}

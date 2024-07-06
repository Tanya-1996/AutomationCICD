package rahulshettyacademy.TestComponent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import rahulshettyacademy.pageobject.LoginPage;

public class BaseTest {
	public WebDriver driver;
	public LoginPage lp;
	public WebDriver initializeDriver() throws IOException {
		
		
		Properties pro=new Properties();
		FileInputStream Fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\rahulshettyacademy\\resource\\GlobalData.properties");
		pro.load(Fis);
	    String browser = System.getProperty("browser")!=null?System.getProperty("browser"):pro.getProperty("browser");
	
	
	    if(browser.equals("chrome")) {
	    driver = new ChromeDriver();
	          }
	    else if(browser.equals("Firefox")) {
		    driver = new FirefoxDriver();

	    }
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().window().maximize();
	    return driver;
	    
	    
	     

}

	public List<HashMap<String,String>>getJsonDataToMap(String filepath) throws IOException
	{
	String jsonContent=	FileUtils.readFileToString(new File(filepath),"UTF-8");

	
	ObjectMapper mapper=new ObjectMapper();
	List<HashMap<String,String>> data =mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
	 return data;
	
	
	}
	
	public String getscreenshot(String testCaseName,WebDriver driver ) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        File file =new File(System.getProperty("user.dir")+"//reports//"+ testCaseName +".png");
        FileUtils.copyFile(source,file);
        return System.getProperty("user.dir")+"//reports//"+ testCaseName +".png";
	
	}
	
	@BeforeMethod(alwaysRun=true)
	public LoginPage launchApplication() throws IOException {
		driver=initializeDriver();
		 lp = new LoginPage(driver);
		lp.applicationUrl();
		return lp;

	}
	@AfterMethod(alwaysRun=true)
	public void closeApplication() {
	        driver.quit();

	}
}
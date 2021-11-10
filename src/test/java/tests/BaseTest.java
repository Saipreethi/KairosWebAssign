package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.HomePage;
import common.LoginPage;

public class BaseTest {
	 protected WebDriver driver;
	 String baseURL= "https://dev99284.service-now.com/";
	    protected HomePage homePage;
	    
	    @Test
	    @Parameters("browser")
	    public void openBrowser(@Optional("browser")String browser) {
	    	try {
	            if (browser.equalsIgnoreCase("Firefox")) {
	                System.setProperty("webdriver.gecko.driver","C:\\Automation Software\\SeleniumDriver\\geckodriver.exe");
	                driver = new FirefoxDriver();
	            } else if (browser.equalsIgnoreCase("chrome")) {
	                System.setProperty("webdriver.chrome.driver", "C:\\Automation Software\\SeleniumDriver\\chromedriver.exe");
	                driver = new ChromeDriver();
	            } else if (browser.equalsIgnoreCase("IE")) {
	                System.setProperty("webdriver.ie.driver", "C:\\Automation Software\\SeleniumDriver\\IEDriverServer.exe");
	                driver = new InternetExplorerDriver();
	            }
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        driver.get(baseURL);
	        LoginPage lp =new LoginPage(driver);
	        lp.setUsername("admin");
	        lp.setPassword("W2n0LwOTXtke");
	        HomePage hp = lp.clickLoginButton();
	       
	        Assert.assertEquals(hp.getHomePageTitle(), "ServiceNow");
	    
	    }   
}


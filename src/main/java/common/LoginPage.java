package common;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	private By usernameField = By.id("user_name");
	private By passwordField = By.id("user_password");
	private By loginButton = By.id("sysverb_login");

	public LoginPage(WebDriver driver){
        this.driver = driver;
    }

	public void setUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

	public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

	public HomePage clickLoginButton(){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(loginButton).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        JavascriptExecutor js = (JavascriptExecutor)driver;
		String status = js.executeScript("return document.readyState").toString();
		System.out.println(status);
        return new HomePage(driver);
    }
}

package common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private WebDriver driver;
	private By homepageHeader = By.xpath("//header[@id='oneHeader']");

	public HomePage(WebDriver driver){
        this.driver = driver;
    }

	public String getHomePageTitle(){
        return driver.getTitle();
    }
}

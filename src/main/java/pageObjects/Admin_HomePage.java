package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Admin_HomePage extends BasePage{
	
	public Admin_HomePage(WebDriver driver){
		super(driver);
	}
	@FindBy(xpath = "//input[@name='email']") WebElement Username;
	@FindBy(xpath = "//input[@name='password']") WebElement Password;
	@FindBy(xpath = "//button[text()='Sign In']") WebElement SignIn_button;
	@FindBy(xpath = "//div[contains(text(),'Venue Infra')]") WebElement VenueInfra;
	@FindBy(xpath = "//a[text()='Venue List']") WebElement venueList;
	
	public void username(String user) {
		Username.sendKeys(user);
	}
	
	public void password(String pass) {
		Password.sendKeys(pass);
	}
	public void singIn() {
		SignIn_button.click();
	}
	public void venuInfra() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		VenueInfra = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Venue Infra')]")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", VenueInfra);
        VenueInfra.click();
        Thread.sleep(3000);
        venueList = wait.until( ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Venue List')]") ) );
        venueList.click();
	}
}

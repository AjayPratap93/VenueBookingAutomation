package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Booking_Management_Admin  extends BasePage{
	
	
	Booking_Management_Admin(WebDriver driver){
		super(driver);
	}
	//Play and pay button 
	@FindBy(xpath="//span[text()='Slot Management']/ancestor::a[@data-slot=\"sidebar-menu-button\"]") WebElement Slot_Management_button;
	
	public void slotManagement() {
		Slot_Management_button.click();
	}
	
	
	
	
}

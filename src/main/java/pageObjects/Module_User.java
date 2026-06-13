package pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class Module_User  extends BasePage{
	
	 public Module_User(WebDriver driver){
		super(driver);
		
	}
	
	// Module User
	@FindBy(xpath="//div[normalize-space()='Module Users']") WebElement Module_User;
	@FindBy(xpath="//input[@placeholder=\"Enter Name\"]") WebElement Enter_Name;
	@FindBy(xpath="//input[@placeholder=\"Enter Email\"]") WebElement Enter_Email;
	@FindBy(xpath="//input[@placeholder=\"Enter Phone Number\"]") WebElement Enter_Contect_Number;
	@FindBy(xpath="//input[@placeholder=\"Enter Password\"]") WebElement Enter_Passwrod;
	@FindBy(xpath="//input[@placeholder=\"Confirm Password\"]")  WebElement Enter_Confirm_Pass;
	@FindBy(xpath="//select[@id=\"selectCluster\"]") WebElement ChooseCluster_button;
	@FindBy(xpath="//select[@id=\"selectVenue\"]") WebElement Choose_Venue;
	@FindBy(xpath="//button[normalize-space()='Create Module Admin']") WebElement create_Moddule_Admin;
	

	
	
	public void EnterName(String name) throws InterruptedException {
		Thread.sleep(3000);
		Enter_Name.sendKeys(name);
	}
	public void ModuleUserButton() throws InterruptedException {
		Thread.sleep(3000);
		Module_User.click();
	}
	public void EnterEmail(String Email) throws InterruptedException {
		Thread.sleep(3000);
		Enter_Email.sendKeys(Email);;
	
	}
	public void EnterContectNumber(String Contect) throws InterruptedException {
		Thread.sleep(3000);
		Enter_Contect_Number.sendKeys(Contect);
	}
	public void EnterPassword(String Pass) throws InterruptedException {
		Thread.sleep(3000);
		Enter_Passwrod.sendKeys(Pass);
	}
	public void EnterConfirmPassword(String ConfirmPass) throws InterruptedException {
		Thread.sleep(3000);
		Enter_Confirm_Pass.sendKeys(ConfirmPass);
	}
	
	public void chooseClusterButton() {
		ChooseCluster_button.click();
	}
	public void chooseCluster(String cluster) throws InterruptedException {
		//ChooseCluster_button.click();
		Thread.sleep(3000);
		Select s=new Select(ChooseCluster_button);
		Thread.sleep(3000);
		s.selectByVisibleText(cluster);
	}
	// dynamic value for choosing cluster  
	/*
	 * public void choosecluster() throws InterruptedException {
	 * ChooseCluster_button.click(); Thread.sleep(2000);
	 * 
	 * Select s = new Select(ChooseCluster_button);
	 * 
	 * // ✅ Use dynamic value s.selectByVisibleText(TestDataStore.clusterName); }
	 */
	
	public void chooseVenueButton() {
		Choose_Venue.click();
	}
	
	public void chooseVenue(String venue) throws InterruptedException {
		Thread.sleep(3000);
		Select s=new Select(Choose_Venue);
		Thread.sleep(3000);
		s.selectByVisibleText(venue);
	}
	// Dynamic value for the venue selection
	/*
	 * public void choosevenue() throws InterruptedException {
	 * 
	 * Choose_Venue.click(); Thread.sleep(2000);
	 * 
	 * Select s = new Select(Choose_Venue);
	 * 
	 * // ✅ Use dynamic value s.selectByVisibleText(TestDataStore.venueName); }
	 */
	
	public void createModuleAdmin() throws InterruptedException {
		Thread.sleep(4000);
		create_Moddule_Admin.click();
	}
	
	
	
	
}

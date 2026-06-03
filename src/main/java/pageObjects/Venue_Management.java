package pageObjects;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Venue_Management extends BasePage {
	
	
	
	 public Venue_Management(WebDriver driver){
		super(driver);
	}
	//Cluster Xpath
	@FindBy(xpath = "//span[text()='Clusters']") WebElement cluster;
	@FindBy(xpath="//p[text()='Create Clusters']") WebElement create_Culster;
	@FindBy(xpath="//input[@id=\"cluster_name\"]") WebElement cluster_name;
	@FindBy(xpath="//input[@id=\"latitude\"]") WebElement cluster_latitude;
	@FindBy(xpath="//input[@id=\"longitude\"]") WebElement cluster_longitude;
	@FindBy(xpath="//input[@id=\"cluster_radius\"]") WebElement cluster_radius;
	@FindBy(xpath="//input[@id=\"supervisor_name\"]") WebElement cluster_supervisor_name;
	@FindBy(xpath="//input[@id=\"supervisor_contact\"]") WebElement Cluster_superVisor_contact;
	@FindBy(xpath="//input[@id=\"supervisor_email\"]") WebElement cluster_email;
	@FindBy(xpath="//input[@type=\"file\"]") WebElement cluster_image;
	@FindBy(xpath="//textarea[@id=\"cluster_description\"]")WebElement description;
	@FindBy(xpath="//button[text()='Save Cluster']") WebElement save_cluster;
	@FindBy(xpath="//p[text()='Create Venue in Cluster']") WebElement Create_Cluster_IN_Venue;
	//Venue Xpath
	@FindBy(xpath="//input[@id=\"venue_name\"]") WebElement Venue_name;
	@FindBy(xpath="//input[@type=\"file\"]") WebElement Upload_venue_Image;
	@FindBy(xpath="//input[@placeholder=\"Search location...\"]") WebElement Search_Location;
	@FindBy(xpath="//input[@placeholder=\"Search location...\"]/../..//li") WebElement click_location;
	@FindBy(xpath="//input[@id=\"venue_radius\"]") WebElement Venue_Redius;
	@FindBy(xpath="//input[@id=\"supervisor_name\"]") WebElement Venue_Supervisor_name;
	@FindBy(xpath="//input[@id=\"supervisor_contact\"]") WebElement Venue_Spuervisor_contect;
	@FindBy(xpath="//input[@id=\"supervisor_email\"]") WebElement Venue_Supervisor_email;
	@FindBy(xpath="//textarea[@id=\"venue_description\"]") WebElement Venue_Descripton;
	@FindBy(xpath="//button[@role=\"switch\"]") WebElement Enable_button;
	@FindBy(xpath="//button[text()='Save Venue']")WebElement Venue_Save;
	
	// Facilities xpath 
	@FindBy(xpath = "//p[text()='Add Facility']") WebElement AddFacilities;
	@FindBy (xpath = "//button[@data-slot='select-trigger']") WebElement FacilitiesType;
	@FindBy(xpath="//span[normalize-space()='Sport']") WebElement SportsFacilities;
	@FindBy(xpath = "(//button[@data-slot=\"select-trigger\"])[2]")WebElement SelectSportsFacili;
	@FindBy(xpath="//div[@data-slot=\"select-item\"]") List<WebElement> SportsName;
	@FindBy(xpath="//input[@placeholder=\"Search sports...\"]") WebElement searchSports;
	@FindBy(xpath="//span[text()='Archery']")WebElement finalSports;
	@FindBy(xpath="//input[@placeholder=\"Enter Radius\"]") WebElement facilityRedius;
	
	
	
	// Create cluster in the venue managemnet System 
	public void Cluster() {
		cluster.click();
	}
	
	public void addCluster() throws InterruptedException {
		create_Culster.click();
		Thread.sleep(3000);
	}
	public void Clustername(String name) throws InterruptedException {
		cluster_name.sendKeys(name);
		Thread.sleep(2000);
	}
	public void ClusteLat_Lon(String Latitude,String longitude) throws InterruptedException {
		cluster_latitude.sendKeys( Latitude);
		Thread.sleep(2000);
		cluster_longitude.sendKeys(longitude);
		Thread.sleep(2000);
	}
	public void clusterRedius(String radius) throws InterruptedException {
		cluster_radius.sendKeys(radius);
		Thread.sleep(2000);
	}
	public void clusterSuperviosr(String Supervisorname ,String Contact ) throws InterruptedException {
		cluster_supervisor_name.sendKeys(Supervisorname);
		Cluster_superVisor_contact.sendKeys(Contact);
		Thread.sleep(2000);
	}
	public void clusterEmail(String email) throws InterruptedException {
		cluster_email.sendKeys(email);
		Thread.sleep(2000);
	}
	public void clusterImage(String Image) throws InterruptedException {
		cluster_image.sendKeys(Image);
		Thread.sleep(2000);
	}
	public void clusterdescription(String text) throws InterruptedException {
		description.sendKeys(text);
		Thread.sleep(2000);
	}
	public void clusterSave() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor) driver;;
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		save_cluster = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Save Cluster']")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", save_cluster);
        save_cluster.click();
	}
	
	// Create Venue under the cluster 
	
	 public void scrolldown() {
		 JavascriptExecutor js=(JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,1000)");
	 }
	
	
	
	public void clickViewButton(String clusterName) throws InterruptedException {
		 String xpath = "//div[normalize-space()='" + clusterName + "']/ancestor::tr//button[normalize-space()='View']"; 
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement view = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		    view.click();
		    Thread.sleep(2000);
	}
	public void createClusterInVenue() throws InterruptedException {
		Thread.sleep(2000);
		Create_Cluster_IN_Venue.click();
		Thread.sleep(2000);
		
	}
	public void enterVenueName(String name) throws InterruptedException {
		Thread.sleep(2000);
		Venue_name.sendKeys(name);
	}
	public void uploadVenueImage(String image) throws InterruptedException {
		Thread.sleep(2000);
		 Upload_venue_Image.sendKeys(image);
		
	}
	public void searchLocation(String location) throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor) driver;;
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		Search_Location = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Search location...']")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", Search_Location);
        Search_Location.click();
		Thread.sleep(4000);
		Search_Location.sendKeys(location);
		Thread.sleep(4000);
		click_location.click();
	}
	public void VenueRedius(String redius) throws InterruptedException {
		Thread.sleep(2000);
		Venue_Redius.sendKeys(redius);
	}
	public void VenueSuperVisorName(String name) throws InterruptedException {
		Thread.sleep(2000);
		Venue_Supervisor_name.sendKeys(name);
	}
	
	public void VenueSuperVisorContect(String contect) throws InterruptedException {
		Thread.sleep(2000);
		Venue_Spuervisor_contect.sendKeys(contect);
	}
	public void VenueSupervisorEmail(String email) throws InterruptedException {
		Thread.sleep(2000);
		Venue_Supervisor_email.sendKeys(email);
		
	}
	public void venueDescription(String Description) throws InterruptedException {
		Thread.sleep(2000);
		Venue_Descripton.sendKeys(Description);
	}
	public void EnableButton() throws InterruptedException {
		Thread.sleep(2000);
		Enable_button.click();
	}
	public void VenueSave() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor) driver;;
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		Venue_Save = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Save Venue']")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", Venue_Save);
        Thread.sleep(2000);
        Venue_Save.click();
        Thread.sleep(3000);
	}
	
	
	// Create Facilities under the venue 
	
	public void clickFacilitiesView(String venueName) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    String xpath = "//td[normalize-space()='"+venueName +"']/ancestor::tr[@data-slot=\"table-row\"]/descendant::td[5][@data-slot=\"table-cell\"]//button[normalize-space()='View']";

	    WebElement viewBtn = wait.until(
	        ExpectedConditions.elementToBeClickable(By.xpath(xpath))
	    );

	    viewBtn.click();
	}
	public void AddFacilities() throws InterruptedException {
		Thread.sleep(3000);
		AddFacilities.click();
	}
	
	public void FacilitiesType() throws InterruptedException {
		Thread.sleep(3000);
		FacilitiesType.click();
		Thread.sleep(3000);
		SportsFacilities.click();
		Thread.sleep(3000);
		SelectSportsFacili.click();
	}
	public void SportsFacilities() throws InterruptedException {
		Thread.sleep(3000);
		searchSports.sendKeys("Archery");
		Thread.sleep(3000);
		finalSports.click();
		/*
		 * String facilitiyName="Hockey"; for (WebElement sport:SportsName) {
		 * if(sport.equals(facilitiyName)) { sport.click(); break; }
		 * 
		 * }
		 */	
	}
	
	public void FailitiesRedius(String radius) throws InterruptedException {
		Thread.sleep(2000);
		facilityRedius.sendKeys(radius);
	}
	
	
}

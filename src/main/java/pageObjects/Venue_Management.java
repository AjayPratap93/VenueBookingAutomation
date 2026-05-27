package pageObjects;


import java.time.Duration;

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
	
	@FindBy(xpath = "//span[text()='Clusters']") WebElement cluster;
	@FindBy(xpath="//p[text()='Create Clusters']") WebElement create_Culster;
	@FindBy(xpath="//input[@id=\"cluster_name\"]") WebElement cluster_name;
	@FindBy(xpath="//input[@id=\"latitude\"]") WebElement cluster_latitude;
	@FindBy(xpath="//input[@id=\"longitude\"]") WebElement cluster_longitude;
	@FindBy(xpath="//input[@id=\"cluster_radius\"]") WebElement cluster_radius;
	@FindBy(xpath="//input[@id=\"supervisor_name\"]") WebElement cluster_supervisor_name;
	@FindBy(xpath="//input[@id=\"supervisor_contact\"]") WebElement Cluster_superVisor_contact;
	@FindBy(xpath="//input[@id=\"supervisor_email\"]") WebElement cluster_email;
	@FindBy(xpath="//input[@id=\"cluster_image\"]") WebElement cluster_image;
	@FindBy(xpath="//textarea[@id=\"cluster_description\"]")WebElement description;
	@FindBy(xpath="//button[text()='Save Cluster']") WebElement save_cluster;
	@FindBy(xpath="//div[text() = 'ClusterGVrEq']/../../..//button[text() = 'View']") WebElement view;
	 
	
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
	
	
	

}

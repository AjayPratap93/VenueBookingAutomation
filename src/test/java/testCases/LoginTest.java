package testCases;

import java.time.Duration;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.Admin_HomePage;
import pageObjects.Venue_Management;
import utilities.RandomData;

public class LoginTest  {
	
	WebDriver driver;
	Logger  log =   LogManager.getLogger(this.getClass());
	@BeforeClass
	void loginApp() {
		log.info("Lunching browswer");
		driver=new ChromeDriver();
		driver.get("https://staging-admin.khelouk.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test(priority=1)
		void loginAdmin() throws InterruptedException {
		Admin_HomePage p1=new Admin_HomePage(driver);
		try {
		log.info("Start admin panle login ");
		p1.username("ukadmin@gmail.com");	
		p1.password("Admin@123");
		p1.singIn();
		log.info("Login completed ");
		Assert.assertTrue(true);
		Thread.sleep(3000);
		p1.venuInfra();
		}
		catch(Exception e) {
			log.error("Test failed ");
			log.debug("Debug log....");
			Assert.fail();
		}
		log.info("Test Excute perfectly  ");
		
	}
	@Test(priority=2)
	void create() throws InterruptedException {
		Venue_Management v1=new Venue_Management(driver);
		String clusterName = "Cluster" + RandomData.randomString();
		v1.Cluster();
		v1.addCluster();
		v1.Clustername(clusterName);
		v1.ClusteLat_Lon("28.5197","77.2006");
		v1.clusterRedius("2000");
		v1.clusterSuperviosr("Yakub","7987597988");
		v1.clusterEmail("newUser@yopmail.com");
		v1.clusterdescription("THis is for new cluster description ");
		v1.clusterSave();
		
	}
		
	@AfterClass
	
	void close() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
	

}

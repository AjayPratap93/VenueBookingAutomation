package testCases;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.Admin_HomePage;
import pageObjects.Venue_Management;
import utilities.RandomData;
import utilities.TestDataStore;

public class LoginTest  {
	
	WebDriver driver;
	Logger  log =   LogManager.getLogger(this.getClass());
	String imagePath="file:///C:/Users/Ajay%20Pratap/Downloads/selenium.jpg";
	@BeforeClass
	//@Parameters({"os","browser"})
	void loginApp() {
		
		//switch(br.toLowerCase()) {
		//case "chrome" : driver=new ChromeDriver(); break;
		//case "edge" : driver=new EdgeDriver(); break;
		//default : System.out.println("Invalid browser name");
		//return;
		//}
		driver=new ChromeDriver();
		log.info("Lunching browswer");
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
		
		TestDataStore.clusterName=clusterName;
		v1.Cluster();
		v1.addCluster();
		v1.Clustername(clusterName);
		v1.ClusteLat_Lon("28.5197","77.2006");
		v1.clusterRedius("2000");
		v1.clusterSuperviosr("Yakub","7987597988");
		v1.clusterEmail("newUser@yopmail.com");
		v1.clusterdescription("THis is for new cluster description ");
		v1.clusterSave();
		Thread.sleep(4000);
		v1.clickViewButton(TestDataStore.clusterName);

	}
		
	@AfterClass
	
	void close() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
	

}

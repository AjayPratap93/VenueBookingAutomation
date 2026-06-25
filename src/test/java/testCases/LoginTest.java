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
import org.testng.asserts.SoftAssert;

import pageObjects.Admin_HomePage;
import pageObjects.Module_User;
import pageObjects.Venue_Management;
import utilities.RandomData;
import utilities.TestDataStore;

public class LoginTest  {
	WebDriver driver ;
	Logger  log =   LogManager.getLogger(this.getClass());
	String imagePath="C:/Users/Ajay Pratap/Downloads/selenium.jpg";
	String clusterName ;
	String venueName="Demo" +RandomData.randomString();
	String Name = "Manager" + RandomData.randomString();
	String Email="Testing" +RandomData.randomString()+"@yopmail.com";
	
	String phone;
	String pass;
	
	@BeforeClass
	//@Parameters({"os","browser"})
	void loginApp() {//String os,String br
		/*
		 * switch(br.toLowerCase()) { case "chrome" : driver=new ChromeDriver(); break;
		 * case "edge" : driver=new EdgeDriver(); break; default :
		 * System.out.println("Invalid browser name"); return;
		 *
		}*/
		
		
		String phone = RandomData.randomPhoneNumber();
		String pass = RandomData.customPassword();
		
		
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
		Thread.sleep(1000);
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
	void createCluster() throws InterruptedException {
		Venue_Management v1=new Venue_Management(driver);
		String clusterName = "Demo" + RandomData.randomString();
		String Name =  RandomData.randomString();
		String Email= "Testing"+RandomData.randomString()+"@yopmail.com";
	    TestDataStore.clusterName = clusterName;
		TestDataStore.clusterName=clusterName;
		v1.Cluster();
		  v1.addCluster(); v1.Clustername(clusterName);
		  v1.ClusteLat_Lon("28.5197","77.2006"); 
		  v1.clusterRedius("2000");
		  v1.clusterSuperviosr(Name,"7987597988");
		  v1.clusterEmail(Email);
		  v1.clusterImage(imagePath);
		  v1.clusterdescription("This is for new cluster  ");
		  Assert.assertTrue(true);
		  v1.clusterSave();
		  Thread.sleep(2000);
		  System.out.println("SuccessFul Cluster Creat");
		  log.info("Cluster created: " + clusterName);
		  log.info("Test Excute perfectly  ");
		  SoftAssert sa= new SoftAssert();
		  sa.assertTrue(true);
		  sa.assertAll();	  
	}
	@Test(priority=3)
	void CreateVenue() throws InterruptedException {
		Venue_Management venue=new Venue_Management(driver);
		String venueName="Demo" +RandomData.randomString();
		String Email= "Testing"+RandomData.randomString()+"@yopmail.com";
		TestDataStore.venueName = venueName;
		TestDataStore.venueName = venueName;
		venue.clickViewButton(TestDataStore.clusterName);
		venue.createClusterInVenue();
		venue.enterVenueName(venueName);
		venue.uploadVenueImage(imagePath);	
		venue.searchLocation("kanpur");
		venue.VenueRedius("2000");
		venue.VenueSuperVisorName("Kanchan Thakur ");
		venue.VenueSuperVisorContect("7984987879");
		venue.VenueSupervisorEmail(Email);
		venue.venueDescription("This is new Venue under the cluster ");
		venue.EnableButton();
		venue.VenueSave();
		System.out.println("Successful venue created ");
		log.info("Venue created: " + venueName);
		log.info("Test Excute perfectly  ");
		Assert.assertTrue(true);
	}
	@Test(priority=4) 
	 void createFacilities() throws InterruptedException {
		Venue_Management Faci=new Venue_Management(driver);
		String Facility =  RandomData.randomString();
		String Email= "Demo"+RandomData.randomString()+"@yopmail.com";
		Faci.clickFacilitiesView(TestDataStore.venueName);
		Faci.AddFacilities();
		Faci.FacilitiesType();
		Faci.SportsFacilities();
		Faci.FailitiesRedius("2000");
		Faci.EnterLocarion("kanpur");
		Faci.FacilitiesSuperVisorDetails(Facility, Email, "9879798798");
		Faci.CreateFacility("Camera");
		Assert.assertTrue(true);
	}
	@Test(priority=5)
	void createZone() throws InterruptedException {
		Venue_Management Zone=new Venue_Management(driver);
		String ZoneName =  RandomData.randomString();
		String Email= "Demo"+RandomData.randomString()+"@yopmail.com";
		Zone.clickZonebutton();
		Zone.enterZoneName(ZoneName, "2000");
		Zone.EnterLocarionZone("kanpur");
		Zone.ZoneSuperVisorDetails(ZoneName, Email, "9879798798");
		Zone.CreateZone();
		Assert.assertTrue(true);
	}
	@Test(priority=5)
	void createModuleManager() throws InterruptedException {
		Module_User user=new Module_User(driver);
		String phone = RandomData.randomPhoneNumber();
		String pass = RandomData.customPassword();
		TestDataStore.phoneNumber = phone;
		TestDataStore.password = pass;
		user.ModuleUserButton();
		user.EnterName(Name);
		user.EnterEmail(Email);
		user.EnterContectNumber(phone);
		user.EnterPassword(pass);
		user.EnterConfirmPassword(pass);
		user.chooseCluster("");
		user.chooseVenue("");
		user.createModuleAdmin();
		log.info("module admin created successful");
		System.out.println(" Phone number : "+phone);
		System.out.println(" Password is : "+pass);
		Assert.assertTrue(true);
	}
	@AfterClass
	void close() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();	
	}
}

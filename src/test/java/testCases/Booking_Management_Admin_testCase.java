package testCases;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.Admin_HomePage;
import pageObjects.Venue_Management;
import utilities.RandomData;

public class Booking_Management_Admin_testCase {
	
	
	WebDriver driver ;
	Logger  log =   LogManager.getLogger(this.getClass());
	@BeforeClass
	void loginApp() {
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
		Venue_Management venue=new Venue_Management(driver);
		venue.playPaybutton();
		
		}
		catch(Exception e) {
			log.error("Test failed ");
			log.debug("Debug log....");
			Assert.fail();
		}
		log.info("Test Excute perfectly  ");
	}
}

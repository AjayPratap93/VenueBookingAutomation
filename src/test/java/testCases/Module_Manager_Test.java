package testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import pageObjects.Admin_HomePage;
import pageObjects.Module_User;
import utilities.RandomData;
import utilities.TestDataStore;

public class Module_Manager_Test {
	WebDriver driver ;
	Logger  log =   LogManager.getLogger(this.getClass());
	String imagePath="C:/Users/Ajay Pratap/Downloads/selenium.jpg";
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
		
		TestDataStore.phoneNumber = phone;
		TestDataStore.password = pass;
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
	void createModuleManager() throws InterruptedException, IOException {
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
		//user.createModuleAdmin();
		log.info("module admin created successful");
		System.out.println(" Phone number : "+phone);
		System.out.println(" Password is : "+pass);
		
		
		TakesScreenshot ts=(TakesScreenshot) driver;
			 File src=ts.getScreenshotAs(OutputType.FILE);
			 File dest=new File("C:\\Users\\Ajay Pratap\\eclipse-workspace\\Booking_management\\screenshots\\image1.png");
			// Files.copy(src, dest);
			 System.out.println("Screenshot taken successful ");
			 log.info("Screenshot taken successful");
	}
	@AfterClass
	void closeBrowser() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
	
}

package pageObjects;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
public 	Logger logger;
Logger  log =  LogManager.getLogger(this.getClass());
	WebDriver driver;
	public BasePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public BasePage() {
		// TODO Auto-generated constructor stub
	}

	public void setup() {
		driver=new ChromeDriver();
		log.info("Lunching browswer");
		driver.get("https://staging-admin.khelouk.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void close() {
		driver.quit();
	}
	
	public String catpureScreenShot(String screenshot) throws IOException {
		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takeScreenshot=(TakesScreenshot) driver;
		File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
		String targetPath = System.getProperty(" user.dir"+"\\screenshots\\"+screenshot+" _"+".png");
		File locationOfFile= new  File(targetPath);
		FileUtils.copyFile(sourceFile,locationOfFile );
		return targetPath;
		
	}

}

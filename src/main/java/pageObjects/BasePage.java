package pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasePage {
public 	Logger logger;
Logger  log =  LogManager.getLogger(this.getClass());
	WebDriver driver;
	public BasePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

}

package com.mirketa.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


/**
 *  
 * @author Manas Jena
 *
 */

public class BrowserFactory {
	static WebDriver driver;

	public static WebDriver getBrowser(String browserName)
	{
		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions ops = new ChromeOptions();
            ops.addArguments("--disable-notifications");
    		System.setProperty("webdriver.chrome.driver",DataProviderFactory.getConfig().getChromePath());
			driver = new ChromeDriver(ops);
		}

		 if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",DataProviderFactory.getConfig().getIEPath());
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();

			ieCapabilities.setCapability("nativeEvents", false);    
			ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
			ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
			ieCapabilities.setCapability("disable-popup-blocking", true);
			ieCapabilities.setCapability("enablePersistentHover", true);

			driver = new InternetExplorerDriver(ieCapabilities);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		if (browserName.equalsIgnoreCase("Firefox")) {
			 System.setProperty("webdriver.gecko.driver",DataProviderFactory.getConfig().getFirefoxPath());
			 FirefoxDriver ops = new FirefoxDriver();
			
            
            
			
		}
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void closeBrowser(WebDriver ldriver)
	{
		ldriver.quit();
	}

}

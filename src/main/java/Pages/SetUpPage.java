package Pages;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.WebDriverWait;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SetUpPage   {
	  public static AppiumDriver<MobileElement> driver;
		public static WebDriverWait wait;

	
	  public void Connect(String deviceName , String udid , String platformVersion  )  {
			 DesiredCapabilities caps = new DesiredCapabilities();
		  //Liron's phone
	        //DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("deviceName", deviceName);
	        caps.setCapability("udid", udid); //DeviceId from "adb devices" command
	        caps.setCapability("platformName", "Android");
	        //
	        caps.setCapability("platformVersion", platformVersion);
	        caps.setCapability("skipUnlock","true");
	        //
	        caps.setCapability("appPackage", "com.sec.android.app.popupcalculator");
	        caps.setCapability("appActivity","com.sec.android.app.popupcalculator.Calculator");
	        //
	        caps.setCapability("noReset","true");
	        try {
	            driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),caps);
	            wait = new WebDriverWait(SetUpPage.driver, 40);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
	        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 
	       try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
	
	
}

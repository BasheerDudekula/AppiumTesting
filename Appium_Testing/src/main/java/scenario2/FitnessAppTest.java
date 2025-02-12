package scenario2;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FitnessAppTest {

	public static void main(String[] args) {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Medium Phone API 35");
		caps.setCapability("appPackage", "com.example.fitnesstracker");
		caps.setCapability("appActivity", "com.example.fitnesstracker.SplashScreenActivity");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		
		try {
			AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
            driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
            
            WebElement appLogo = driver.findElement(By.id("com.example.fitnesstracker:id/appLogo"));
            
            if(appLogo.isDisplayed()) {
            	System.out.println("App logo is Displayed");
            }else {
            	System.out.println("Logo is not displayed");
            }
            
            Thread.sleep(3000);   
            
            WebElement viewPager = driver.findElement(By.id("com.example.fitnesstracker:id/viewPager"));
            
            if(viewPager.isDisplayed()) {
            	System.out.println("Page is displayed");
            }else {
            	System.out.println("Page is not displayed");
            }
            
            WebElement title = driver.findElement(By.xpath("//android.widget.TextView[@text='Stay Active!']"));
            WebElement desc = driver.findElement(By.xpath("//android.widget.TextView[@text='Exercise daily for a healthy life.']"));
            
            if(viewPager.isDisplayed()) {
            	System.out.println("Text is displayed");
            }else {
            	System.out.println("Text is not displayed");
            }
            
            WebElement skipButton = driver.findElement(By.id("com.example.fitnesstracker:id/btnSkip"));
            skipButton.click();
            
            Thread.sleep(2000);
            WebElement fitnessMetrices = driver.findElement(By.id("com.example.fitnesstracker:id/txtMetrics"));
            
            if(fitnessMetrices.isDisplayed()) {
            	System.out.println("Steps and calories Text displayed");
            	System.out.println("Successfully navigated to Dashboard Screeen");
            }else {
            	System.out.println("Steps and Calories Text not Displayed");
            }
            
            WebElement sync = driver.findElement(By.id("com.example.fitnesstracker:id/btnSync"));
            sync.click();
            
            WebElement steps = driver.findElement(By.xpath("//android.widget.TextView[@text='Steps: 5000 | Calories: 300']"));
            
            if(steps.isDisplayed()) {
            	System.out.println("Syncing device is done successfully");
            }else {
            	System.out.println("device syncing is not done");
            }
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}

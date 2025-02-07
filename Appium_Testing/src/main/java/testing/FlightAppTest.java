package testing;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FlightAppTest {
	
	public static void main(String[] args) {
		
		try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Medium Phone API 35");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            capabilities.setCapability("appPackage", "com.example.flightapp");
            capabilities.setCapability("appActivity", "com.example.flightapp.ui.MainActivity");
 
            
            AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
 
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
            WebElement firstTitle = driver.findElement(By.xpath("//android.widget.TextView[@text='Delta Air Lines']"));
            firstTitle.click();
 
            WebElement discElement = driver.findElement(By.id("airlineName"));
            System.out.println("Flight Description: " + discElement.getText());
 
            driver.quit();
 
        } catch (Exception e) {
            e.printStackTrace();
        }

	}
}
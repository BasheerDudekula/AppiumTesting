package testing;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FlightApptesting {
	 
    public static void main(String[] args) {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Medium Phone API 35");
            capabilities.setCapability("appPackage", "com.example.flightapp");
            capabilities.setCapability("appActivity", "com.example.flightapp.ui.MainActivity"); 
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
 
            AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
 
            // Wait for the RecyclerView to load
            Thread.sleep(3000);
 
            // Click on the first movie item in the RecyclerView
            List<WebElement> flightItems = driver.findElements(MobileBy.className("android.widget.TextView"));
            if (!flightItems.isEmpty()) {
                flightItems.get(0).click();
            }
 
            // Wait for the details screen
            Thread.sleep(2000);
 
            // Verify flight details
            WebElement flightName = driver.findElement(MobileBy.id("com.example.flightapp:id/airlineName"));
            System.out.println("Flight Name: " + flightName.getText());
 
            WebElement flightDescription = driver.findElement(MobileBy.id("com.example.flightapp:id/Country"));
            System.out.println("Flight Description: " + flightDescription.getText());
 
            // Close the driver
            driver.quit();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

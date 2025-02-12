package scenario3;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FoodAppListTest {

	public static void main(String[] args) {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Medium Phone API 35");
		caps.setCapability("appPackage", "com.example.foodapp");
		caps.setCapability("appActivity", "com.example.foodapp.ui.RecipeListActivity");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		
		try {
			
			AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
            driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
            
            //For fetching the image of the item
            Thread.sleep(3000);
            WebElement itemImage = driver.findElement(By.id("com.example.foodapp:id/mealImage"));
            
            if(itemImage.isDisplayed()) {
            	System.out.println("Item image is displayed on the screen");
            }else {
            	System.out.println("Item image is not displayed");
            }
            
            //for fetching the name is displayed or not
            WebElement itemName = driver.findElement(By.id("com.example.foodapp:id/mealName"));
            System.out.println("Item Name: " + itemName.getText());
            
            if(itemName.isDisplayed()) {
            	System.out.println("Item name is fetched Successfully");
            }else {
            	System.out.println("Item name is not fetched");
            }
            
            WebElement favoriteButton = driver.findElement(By.id("com.example.foodapp:id/buttonFavorites"));
            if(favoriteButton.isDisplayed()) {
            	System.out.println("Favorites Button is displayed");
            }
            else {
            	System.out.println("Favorites Button is not displayed");
            }
          
            driver.quit();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

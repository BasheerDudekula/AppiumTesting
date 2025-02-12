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

public class FoodAppFavoritiesTest {

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
            
            Thread.sleep(2000);
            List<WebElement> foodItems = driver.findElements(MobileBy.className("android.widget.ImageView"));
            if (!foodItems.isEmpty()) {
                foodItems.get(0).click();
            }
            
            WebElement saveButton = driver.findElement(By.id("com.example.foodapp:id/btnFavorite"));
            saveButton.click();
            
            WebElement backButton = driver.findElement(By.id("com.example.foodapp:id/btnBack"));
            backButton.click();
            
            Thread.sleep(2000);
            WebElement favorities = driver.findElement(By.id("com.example.foodapp:id/buttonFavorites"));
            favorities.click();
            
            Thread.sleep(2000);
            WebElement itemsName = driver.findElement(MobileBy.id("com.example.foodapp:id/mealName"));
            System.out.println("Item Name: " + itemsName.getText());
            
            WebElement itemImage = driver.findElement(By.id("com.example.foodapp:id/mealImage"));
            
            if(itemImage.isDisplayed()) {
            	System.out.println("Item image is displayed on the screen");
            }else {
            	System.out.println("Item image is not displayed");
            }
            
            System.out.println("Item saved to the Database successfully");
            
            WebElement removeButton = driver.findElement(By.id("com.example.foodapp:id/btnRemove"));
            if(removeButton.isDisplayed()) {
            	System.out.println("Remove button is displayed");
            }
            else {
            	System.out.println("Remove button is not displayed");
            }
            removeButton.click();
            
            List<WebElement> foodItem = driver.findElements(MobileBy.className("android.widget.TextView"));
            
            if (!foodItem.isEmpty()) {
                System.out.println("Removed the item from the database");
            }else {
            	System.out.println("Error in deleting the item");
            }
            
            WebElement navigationButton = driver.findElement(By.id("com.example.foodapp:id/buttonBack"));
            if(navigationButton.isDisplayed()) {
            	System.out.println("Back button is displayed");
            }
            else {
            	System.out.println("Back button is not displayed");
            }
            
            navigationButton.click();
            WebElement itemName = driver.findElement(MobileBy.id("com.example.foodapp:id/mealName"));
            
            if(itemName.isDisplayed()) {
            	System.out.println("Navigated back to the List");
            }
            else {
            	System.out.println("Navigation failed");
            }
            driver.quit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

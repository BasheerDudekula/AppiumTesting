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

public class FoodAppDetailsTest {

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
            
            Thread.sleep(2000);
            WebElement itemsName = driver.findElement(MobileBy.id("com.example.foodapp:id/mealName"));
            System.out.println("Item Name: " + itemsName.getText());
            
            WebElement itemImage = driver.findElement(By.id("com.example.foodapp:id/mealImage"));
            
            if(itemImage.isDisplayed()) {
            	System.out.println("Item image is displayed on the screen");
            }else {
            	System.out.println("Item image is not displayed");
            }
            
            WebElement instructions = driver.findElement(MobileBy.id("com.example.foodapp:id/mealInstructions"));
            System.out.println("Item Instructions: " + instructions.getText());
            
            WebElement saveButton = driver.findElement(By.id("com.example.foodapp:id/btnFavorite"));
            if(saveButton.isDisplayed()) {
            	System.out.println("Save to Favorites Button is displayed");
            }
            else {
            	System.out.println("Save to Favorities Button is not displayed");
            }
            
            WebElement backButton = driver.findElement(By.id("com.example.foodapp:id/btnBack"));
            if(backButton.isDisplayed()) {
            	System.out.println("Back button is displayed");
            }
            else {
            	System.out.println("Back button is not displayed");
            }
            
            backButton.click();
            WebElement itemName = driver.findElement(MobileBy.id("com.example.foodapp:id/mealName"));
            
            if(itemName.isDisplayed()) {
            	System.out.println("Navigated back to the List");
            }
            else {
            	System.out.println("Navigation failed");
            }
            
            driver.quit();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}

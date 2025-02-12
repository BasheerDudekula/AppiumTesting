package appiumscenarios1;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ECommerceShoppingLoginTest {

	public static void main(String[] args) {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Medium Phone API 35");
		caps.setCapability("appPackage", "com.example.e_commerceshoppingapp");
		caps.setCapability("appActivity", "com.example.e_commerceshoppingapp.LoginActivity");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		
		try {
			// Initialize the Appium driver
            AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
            driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
            
            WebElement email = driver.findElement(By.id("com.example.e_commerceshoppingapp:id/editTextEmail"));
			System.out.println("Email : " + email);
			email.sendKeys("admin");
			
			WebElement password = driver.findElement(By.id("com.example.e_commerceshoppingapp:id/editTextPassword"));
			System.out.println("Password : " + password);
			password.sendKeys("admin");
			
			WebElement loginButton = driver.findElement(By.id("com.example.e_commerceshoppingapp:id/buttonLogin"));
            loginButton.click();
            System.out.println("User login Successfully and navigated to product list");
            
            driver.quit();
            
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}

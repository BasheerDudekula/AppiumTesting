package appiumscenarios1;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ECommerceShoppingRegisterTest {

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
            
            //Registering user
            WebElement registerButton = driver.findElement(By.id("com.example.e_commerceshoppingapp:id/buttonRegister"));
            registerButton.click();
            
            System.out.println("Successfully navigated to the Register Activity from Login Activity");
            
            //On Cancellation Button
            WebElement cancelButton = driver.findElement(By.id("com.example.e_commerceshoppingapp:id/btnCancel"));
            cancelButton.click();
            System.out.println("Successfully navigated back to login activity by cancelling Registeration");
            
            //Register user
            WebElement registerButton1 = driver.findElement(By.id("com.example.e_commerceshoppingapp:id/buttonRegister"));
            registerButton1.click();
            System.out.println("Successfully navigated to the Register Activity from Login Activity");
            
            WebElement email = driver.findElement(By.id("com.example.e_commerceshoppingapp:id/etEmail"));
			System.out.println("Email : " + email);
			email.sendKeys("admin");
			
			WebElement password = driver.findElement(By.id("com.example.e_commerceshoppingapp:id/etPassword"));
			System.out.println("Password : " + password);
			password.sendKeys("admin");
			
			WebElement confirmPassword = driver.findElement(By.id("com.example.e_commerceshoppingapp:id/etConformPassword"));
			System.out.println("Confirm Password : " + confirmPassword);
			confirmPassword.sendKeys("admin");
			
			WebElement mobile = driver.findElement(By.id("com.example.e_commerceshoppingapp:id/etMobile"));
			System.out.println("Mobile Number : " + mobile);
			mobile.sendKeys("8978947837");
			
			WebElement signupButton = driver.findElement(By.id("com.example.e_commerceshoppingapp:id/btnRegister"));
            signupButton.click();
            
            System.out.println("User Registered Successfully");
            
            driver.quit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

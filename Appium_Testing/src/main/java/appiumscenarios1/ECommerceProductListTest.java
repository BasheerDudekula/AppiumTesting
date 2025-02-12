package appiumscenarios1;

import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ECommerceProductListTest {

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
            
            WebElement productList = driver.findElement(By.id("productContainer"));
            if(productList.isDisplayed()) {
            	System.out.println("Products are available");
            }
            else {
            	System.out.println("Error in fetching product details");
            }
            
            List<WebElement> productNames = driver.findElements(By.className("android.widget.TextView"));
            WebElement productTitle = driver.findElement(By.xpath("//android.widget.TextView[@text='Laptop - $800.0']"));
            System.out.println("Shown the List of Products Available");
            
            List<WebElement> addToCartButtons = driver.findElements(By.className("android.widget.Button"));
            addToCartButtons.get(0).click();
            
            WebElement checkoutButton = driver.findElement(By.xpath("//android.widget.Button[contains(@text,'GO TO CHECKOUT')]"));
            checkoutButton.click();
            
            WebElement checkoutScreen = driver.findElement(By.id("tvTotalPrice"));
            if(checkoutScreen.isDisplayed()) {
            	System.out.println("Successfully navigated to the checkout screen");
            	System.out.println("add to cart item is available");
            }
            else {
            	System.out.println("Error in  fetching the cart items");
            }
            
            WebElement payment = driver.findElement(By.id("com.example.e_commerceshoppingapp:id/buttonPay"));
            payment.click();
            System.out.println("Payment successfull and navigated back to product list");
            
            WebElement logout = driver.findElement(By.id("com.example.e_commerceshoppingapp:id/btnLogout"));
            logout.click();
            System.out.println("Logout User successfully");
            
            driver.quit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

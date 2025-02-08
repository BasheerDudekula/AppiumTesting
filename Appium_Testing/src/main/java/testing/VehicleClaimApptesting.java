package testing;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class VehicleClaimApptesting {

	public static void main(String[] args) throws InterruptedException {
		// AndroidDriver<AndroidElement> driver;

		// Setup desired capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Medium Phone API 35");
		caps.setCapability("appPackage", "com.example.vehicleclaimapp");
		caps.setCapability("appActivity", "com.example.vehicleclaimapp.ui.claim.ClaimSubmissionActivity");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

		try {
			// Initialize the Appium driver
			AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);

			// Perform claim operation
			WebElement enterClaim = driver.findElement(By.id("com.example.vehicleclaimapp:id/etClaimDescription"));
			System.out.println("Claim Description : " + enterClaim);
			enterClaim.sendKeys("Nani");

			 WebElement submitButton = driver.findElement(By.id("com.example.vehicleclaimapp:id/btnSubmitClaim"));
			 submitButton.click();
			 
			 WebElement viewClaim = driver.findElement(By.id("com.example.vehicleclaimapp:id/btnViewClaimHistory"));
			 viewClaim.click();

			Thread.sleep(2000);
			
			WebElement description = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Description: Nani')]"));
			WebElement status = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Status: Pending')]"));

			if (description.isDisplayed() && status.isDisplayed()) {
				System.out.println("claim is submitted successfully");
				System.out.println("Successfully fetched View Claim History");
			} else {
				System.out.println("claim is not submitted");
			}
			
			//Updating the claim
			WebElement updateClaim = driver.findElement(By.id("com.example.vehicleclaimapp:id/btnUpdateClaim"));
			 updateClaim.click();
			 
			 System.out.println("Successfully Navigated to Update claim status");
			 
			 Thread.sleep(3000);
			 WebElement enterClaimId = driver.findElement(By.id("com.example.vehicleclaimapp:id/etClaimId"));
				System.out.println("Claim Id : " + enterClaimId);
				enterClaimId.sendKeys("1");
				
			WebElement enterStatus = driver.findElement(By.id("com.example.vehicleclaimapp:id/etNewStatus"));
				System.out.println("Updated status : " + enterStatus);
				enterStatus.sendKeys("Approved");
			
			WebElement updateStatus = driver.findElement(By.id("com.example.vehicleclaimapp:id/btnUpdateStatus"));
				 updateStatus.click();
				 
				 WebElement viewUpdateClaim = driver.findElement(By.id("com.example.vehicleclaimapp:id/btnViewClaimHistory"));
				 viewUpdateClaim.click();

				Thread.sleep(2000);
				
				WebElement updateDescription = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Description: Nani')]"));
				WebElement updatedStatus = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Status: Approved')]"));

				if (updateDescription.isDisplayed() && updatedStatus.isDisplayed()) {
					System.out.println("claim is Updated successfully");
					System.out.println("Successfully fetched Updated View Claim History");
				} else {
					System.out.println("claim is not updated");
				}

			driver.quit();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}

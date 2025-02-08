package testing;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class VehicleInsuranceAppTesting {

	public static void main(String[] args) throws InterruptedException {

		// AndroidDriver<AndroidElement> driver;

		// Setup desired capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Medium Phone API 35");
		caps.setCapability("appPackage", "com.example.vehicleinsuranceapp");
		caps.setCapability("appActivity", "com.example.vehicleinsuranceapp.MainActivity");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

		try {
			// Initialize the Appium driver
			AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);

			// Perform addition operation
			WebElement vehicleNumber = driver
					.findElement(By.id("com.example.vehicleinsuranceapp:id/vehicleNumberEditText"));
			System.out.println("Vehicle Number : " + vehicleNumber);
			vehicleNumber.sendKeys("Ap2159");

			WebElement accidentDetails = driver
					.findElement(By.id("com.example.vehicleinsuranceapp:id/accidentDetailsEditText"));
			System.out.println("Accident Details : " + accidentDetails);
			accidentDetails.sendKeys("Car");

			WebElement claimAmount = driver
					.findElement(By.id("com.example.vehicleinsuranceapp:id/claimAmountEditText"));
			System.out.println("Claim Amount : " + claimAmount);
			claimAmount.sendKeys("500");

			// WebElement addButton =
			// driver.findElement(By.id("com.example.vehicleinsuranceapp:id/btnAdd"));
			// addButton.click();

			// Navigate to the second screen
			WebElement navigateButton = driver
					.findElement(By.id("com.example.vehicleinsuranceapp:id/submitClaimButton"));
			navigateButton.click();

			Thread.sleep(2000);
			WebElement vehicleText = driver
					.findElement(By.xpath("//android.widget.TextView[contains(@text,'Vehicle Number: Ap2159')]"));
			WebElement accidentText = driver
					.findElement(By.xpath("//android.widget.TextView[contains(@text,'Accident Details: Car')]"));
			WebElement amountText = driver
					.findElement(By.xpath("//android.widget.TextView[contains(@text,'Claim Amount: 500')]"));

			if (vehicleText.isDisplayed() && accidentText.isDisplayed() && amountText.isDisplayed()) {
				System.out.println("Successfully navigated to AddClaimFragment");
				System.out.println("claim is submitted successfully");
			} else {
				System.out.println("claim is not submitted");
			}

			System.out.println("Navigated Successfully from submit claim to add new claim");

			WebElement navigateButton2 = driver.findElement(By.id("com.example.vehicleinsuranceapp:id/addClaimButton"));
			navigateButton2.click();

			System.out.println("Navigated Successfully from Add new claim to Submit claim");

			driver.quit();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}

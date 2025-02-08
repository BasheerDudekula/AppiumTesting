package testing;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class WeatherAppTest {

	public static void main(String[] args) {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Medium Phone API 35");
		caps.setCapability("appPackage", "com.example.weatherapp");
		caps.setCapability("appActivity", "com.example.weatherapp.MainActivity");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

		try {
			// Initialize the Appium driver
			AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);

			// Perform addition operation
			WebElement fetchWeatherButton = driver.findElement(By.id("com.example.weatherapp:id/btnFetchWeather"));
			fetchWeatherButton.click();

			WebElement num1Field = driver.findElement(By.id("com.example.weatherapp:id/tvTitle"));

			WebElement num2Field = driver.findElement(By.id("com.example.weatherapp:id/tvWeather"));

			// Navigate to the second screen

			System.out.println("Successfully Fetched Weather!!!");

			driver.quit();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}

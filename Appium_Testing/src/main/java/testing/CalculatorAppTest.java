package testing;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class CalculatorAppTest {

	public static void main(String[] args) {
		try {
				{
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Medium Phone API 35");
				capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
				
				capabilities.setCapability("appPackage", "com.example.calculatorapp");
				capabilities.setCapability("appActivity", ".MainActivity");
				
				AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),capabilities);
				
				WebElement firstNumber = driver.findElement(By.id("com.example.calculatorapp:id/etFirstNumber"));
				WebElement secondNumber = driver.findElement(By.id("com.example.calculatorapp:id/etSecondNumber"));
				
				WebElement addButton = driver.findElement(By.id("com.example.calculatorapp:id/btnAdd"));
				WebElement resultView = driver.findElement(By.id("com.example.calculatorapp:id/tvResult"));
				
				firstNumber.sendKeys("3");
				secondNumber.sendKeys("5");
				addButton.click();
				
				String resultText = resultView.getText();
				if(resultText.contains("8")) {
					System.out.println("Test Passed: Result is Correct");
				}else {
					System.out.println("Test Failed: Incorrect result");
					
				}
				driver.quit();
				}
				
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
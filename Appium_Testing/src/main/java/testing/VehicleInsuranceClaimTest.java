package testing;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class VehicleInsuranceClaimTest {

	public static void main(String[] args) {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Medium Phone API 35");
		caps.setCapability("appPackage", "com.example.vehicleinsuranceclaim");
		caps.setCapability("appActivity", "com.example.vehicleinsuranceclaim.ui.LoginActivity");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		
		try {
			// Initialize the Appium driver
            AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
            driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
            
            //Registering user
            WebElement registerButton = driver.findElement(By.id("com.example.vehicleinsuranceclaim:id/register_button"));
            registerButton.click();
            
            System.out.println("Successfully navigated to the Register Activity from Login Activity");
            
            WebElement name = driver.findElement(By.id("com.example.vehicleinsuranceclaim:id/name_edit_text"));
			System.out.println("Name : " + name);
			name.sendKeys("Basheer Ahamed");
			
			WebElement email = driver.findElement(By.id("com.example.vehicleinsuranceclaim:id/email_edit_text"));
			System.out.println("Email : " + email);
			email.sendKeys("ahamed@gmail.com");
			
			WebElement password = driver.findElement(By.id("com.example.vehicleinsuranceclaim:id/password_edit_text"));
			System.out.println("Password : " + password);
			password.sendKeys("12345");
			
			WebElement mobileNumber = driver.findElement(By.id("com.example.vehicleinsuranceclaim:id/phone_edit_text"));
			System.out.println("Mobile Number : " + mobileNumber);
			mobileNumber.sendKeys("8978947837");
			
			WebElement policyNumber = driver.findElement(By.id("com.example.vehicleinsuranceclaim:id/policy_number_edit_text"));
			System.out.println("Policy Number : " + policyNumber);
			policyNumber.sendKeys("1234");
			
			WebElement vehicleNumber = driver.findElement(By.id("com.example.vehicleinsuranceclaim:id/vehicle_number_edit_text"));
			System.out.println("Vehicle Number : " + vehicleNumber);
			vehicleNumber.sendKeys("Ap31 4245");

			WebElement register = driver.findElement(By.id("com.example.vehicleinsuranceclaim:id/register_button"));
            register.click();
            
            System.out.println("User Registered Successfully");
            
            //User Login
            WebElement userName = driver.findElement(By.id("com.example.vehicleinsuranceclaim:id/email_edit_text"));
			userName.sendKeys("ahamed@gmail.com");
            
			WebElement userPassword = driver.findElement(By.id("com.example.vehicleinsuranceclaim:id/password_edit_text"));
			userPassword.sendKeys("12345");
			
			WebElement login = driver.findElement(By.id("com.example.vehicleinsuranceclaim:id/login_button"));
            login.click();
            
            //Dashboard
            WebElement displayName = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Name: Basheer Ahamed')]"));
			WebElement displayEmail = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Email: ahamed@gmail.com')]"));
            
			if (displayName.isDisplayed() && displayEmail.isDisplayed()) {
				System.out.println("User Login Successfull");
				System.out.println("Successfully Navigated from Login page to Dashboard");
			} else {
				System.out.println("user login failed!");
			}
			
			//Claim Submission and updates 
			WebElement claims = driver.findElement(By.id("com.example.vehicleinsuranceclaim:id/claims_button"));
            claims.click();
            
            System.out.println("Successfully navigated to Claims Activity");
            
            // Perform claim operation
         	WebElement enterClaim = driver.findElement(By.id("com.example.vehicleinsuranceclaim:id/etClaimDescription"));
         	System.out.println("Claim Description : " + enterClaim);
         	enterClaim.sendKeys("Nani");

         	WebElement submitButton = driver.findElement(By.id("com.example.vehicleinsuranceclaim:id/btnSubmitClaim"));
         	submitButton.click();
         			 
         	WebElement viewClaim = driver.findElement(By.id("com.example.vehicleinsuranceclaim:id/btnViewClaimHistory"));
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
         	WebElement updateClaim = driver.findElement(By.id("com.example.vehicleinsuranceclaim:id/btnUpdateClaim"));
         	updateClaim.click();
         			 
         	System.out.println("Successfully Navigated to Update claim status");
         			 
         	Thread.sleep(3000);
         	WebElement enterClaimId = driver.findElement(By.id("com.example.vehicleinsuranceclaim:id/etClaimId"));
         	System.out.println("Claim Id : " + enterClaimId);
         	enterClaimId.sendKeys("1");
         				
         	WebElement enterStatus = driver.findElement(By.id("com.example.vehicleinsuranceclaim:id/etNewStatus"));
         	System.out.println("Updated status : " + enterStatus);
         	enterStatus.sendKeys("Approved");
         			
         	WebElement updateStatus = driver.findElement(By.id("com.example.vehicleinsuranceclaim:id/btnUpdateStatus"));
         	updateStatus.click();
         				 
         	WebElement viewUpdateClaim = driver.findElement(By.id("com.example.vehicleinsuranceclaim:id/btnViewClaimHistory"));
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

			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}

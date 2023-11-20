package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;




public class calculatorTest {
		
//	  AppiumDriver driver;
//	
//
//	public static void main(String[] args) {
//
//		try {
//			FleetEnable();
//		}catch(Exception exp) {
//			System.out.println(exp.getCause());
//			System.out.println(exp.getMessage());
//			exp.printStackTrace();
//		}
//
//	}

	public static void main(String[] args) throws MalformedURLException, InterruptedException{
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
//		cap.setCapability("deviceName", "iqoo neo 6");
//		cap.setCapability("udid", "10BC9S1837000E2");
//		cap.setCapability("platformName", "Android");
//		cap.setCapability("platformVersion", "13");
		
		cap.setCapability("deviceName", "Galaxy M13 5G");
		cap.setCapability("udid", "RZCT91SA83X");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "13");
		cap.setCapability("automationName", "UiAutomator2");
		
		cap.setCapability("appPackage","com.fleet_enable");
		cap.setCapability("appActivity", "com.fleet_enable.MainActivity");
		
	    URL url = new URL("http://127.0.0.1:4723/wd/hub");
	    
		AppiumDriver driver = new AppiumDriver(url, cap);
		
		// application started
		System.out.println("Application started....");
		
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		
		// invalid mobile number 
			// allowing camera to access popup enabling
			WebElement one = driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
			one.click();
			Thread.sleep(5000);
		
			// selecting the country india
			WebElement country = driver.findElement(By.className("android.widget.ImageView"));
			country.click();
			
			// selecting in the dropdown of country
			WebElement india = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"+91 India\"]"));
			india.click();
			
			// clicking on the mobileInput to send the invalid number
			WebElement mobileInput = driver.findElement(By.xpath("//android.widget.EditText"));
			mobileInput.click();
			
			// enter invalid mobile number
			mobileInput.sendKeys("1122445511");
	
			// click on the temporary otp button to navigate to the otp page
			WebElement verifyMobNumBtn = driver.findElement(By.className("android.widget.Button"));
			verifyMobNumBtn.click();
			Thread.sleep(5000);
			
            // popup for invalid mobile number
			driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"OK\"]")).click();
			mobileInput.clear();
			
			
			
			// less than 10 digit of mobile number
			WebElement mobilenumValidation = driver.findElement(By.xpath("//android.widget.EditText"));
			mobilenumValidation.click();
			mobilenumValidation.sendKeys("112455");
			verifyMobNumBtn.click();
			driver.findElement(By.xpath("//android.view.View[@content-desc=\"Please enter valid mobile number\"]")).isDisplayed();
			mobileInput.clear();
		
			// Enter a valid number
			mobileInput.sendKeys("7382340847");
			WebElement temporaryOtp = driver.findElement(By.className("android.widget.Button"));
			temporaryOtp.click();
			Thread.sleep(5000);
			
			
			
			WebElement pinCodeElement = driver.findElement(By.className("android.widget.EditText"));
			pinCodeElement.click();
			String otp = generateInvalidOTP(6);                              // Clear any existing value in the field
			pinCodeElement.sendKeys(otp);
			System.out.println(otp);
			
//			List<WebElement> tfl=driver.findElements(By.className("android.widget.EditText"));
//		     tfl.get(0).sendKeys("1"); // tfl=text field list
//		     tfl.get(1).sendKeys("2");
//		     tfl.get(2).sendKeys("1"); // tfl=text field list
//		     tfl.get(3).sendKeys("2");
//		     tfl.get(4).sendKeys("1"); // tfl=text field list
//		     tfl.get(5).sendKeys("2");

			
			// System.out.println(otp);
			// security code popup
			driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Verify Temporary Password\"]")).click();
			Thread.sleep(5000);
			driver.findElement(By.className("android.widget.Button")).click();
			
			driver.navigate().back();
			mobileInput.clear();
			// valid mobile number
			mobileInput.sendKeys("7077982182");
			temporaryOtp.click();
			Thread.sleep(5000);
			
//			String validOtp = generateValidOtp();
//			verifyOtpField.click();
//			verifyOtpField.sendKeys(validOtp);
//			System.out.println(validOtp);
		
			
		
	}
	
	
	public static String generateInvalidOTP(int length) {
       String charset = "0123456789";
       
        StringBuilder otp = new StringBuilder();

        // Create a Random object
        Random random = new Random();

       // Generate the OTP
      for (int i = 0; i < length; i++) {
            int index = random.nextInt(charset.length());
            char randomChar = charset.charAt(index);
            otp.append(randomChar);
        }

        return otp.toString();
    }
	
	private static String generateValidOtp() {
        // Generate a 6-digit OTP
        return "202581";
    }
	
}





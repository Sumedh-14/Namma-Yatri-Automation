package Driver;

import base.BaseClass;
import io.appium.java_client.AppiumBy;


public class EnterOTPPopUp extends BaseClass {
	
	//try for right/wrong otp and various edge cases
	
	public void enterCorrectOTP() throws InterruptedException {
		
		System.out.println("Ride OTP is transferred to Driver to Start Ride = "+rideOTP);

        driver.findElement(AppiumBy.xpath("//android.widget.EditText")).click();
        Thread.sleep(3000);
    	driver.findElement(AppiumBy.xpath("//android.widget.EditText")).sendKeys(rideOTP);
		System.out.println("Driver entered the right otp");
		Thread.sleep(3000);
	}
	
	public void clickBackAfterEnteringOTP() {
		
		
	}
	
	public void enterWrongOTP() {
		
		
	}

}

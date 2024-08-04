package Driver;

import io.appium.java_client.AppiumBy;
import base.BaseClass;

public class StartRideScreen extends BaseClass {
	
	//can write about start or cancel ride
	//also messaging, calling , opening maps, click i've arrived
	
	public void startRide() throws InterruptedException {
		
		System.out.println("Ride OTP is transferred to Driver to Start Ride = "+rideOTP);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Start Ride']")).click();
		Thread.sleep(4000);
	}
	
	public void cancelRide() {
		
		
	}
	
	public void clickIHaveArrived() {
		
		
	}
	
	public void clickMaps() {
		
		
	}
	
	public void clickChatMessaging() {
		
		
	}
	
	public void clickOnCall() {
		
		
	}
	
	public void verifyRideFareAndRideDistance() {
		
		
	}

}

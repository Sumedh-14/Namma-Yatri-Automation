package User.Android;

import io.appium.java_client.AppiumBy;

import org.testng.annotations.Test;

import base.BaseClass;

public class EstimateScreen extends BaseClass {
	
	//we can write to choose from preferences
	@Test
	public void autoAssignDriver() throws InterruptedException {
		driver1.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Auto']")).click();
		Thread.sleep(2000);
		System.out.println("Coming to Tap Book auto ");
		driver1.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Confirm Button to Proceed With Auto']")).click();
		System.out.println("Ride Search is Successful ");
		Thread.sleep(2000);
	}
	
	public void chooseBetweenMultipleDrivers() {

		//Choose between multiple drivers
		driver1.findElement(AppiumBy.xpath("//android.widget.TextView[@test='Choose between multiple drivers']")).click();
		//if chosen this option automatically it will assign hence give sleep of 12-15 sec

	}
	
	public void confirmRideByChoosingBetweenMultipleDriverOffers() {
		
		
	}
	
	public void autoConfirmFirstDriverOffer() {
		
		
	}
	
	public void cancelAutoConfirm() {
		
		
	}

}

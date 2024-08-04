package Driver;

import base.BaseClass;
import io.appium.java_client.AppiumBy;

public class EndRideScreen extends BaseClass {
	
	//about opening maps
	//about end ride/Go back
	//read ridefare and ride distance and assert with value received at estimate screen/ at start ride screen/ with screen from user side
	
	public void clickEndRide() throws InterruptedException {
		System.out.println("Coming to tap on the EndRide");
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='End Ride']")).click();
		System.out.println("Waiting to tap on the Endride in the pop yup");
		Thread.sleep(3000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"End Ride : Button\"]")).click();
		Thread.sleep(3000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Fare Collected\"]")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"5 Star : Un Selected\"]")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Submit Feedback\"]")).click();
	}
	
	public void clickMaps() {
		
		
	}
	
	public void verifyRideFareAndRideDistance() {
		
		
	}
	
	public void clickEndRideAndGoBack() throws InterruptedException {
		//End Ride from Go back option
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Go Back']/../following-sibling::android.widget.LinearLayout/android.widget.TextView")).click();		
		System.out.println("The ride is completed and ended");
		Thread.sleep(4000);
	}
}

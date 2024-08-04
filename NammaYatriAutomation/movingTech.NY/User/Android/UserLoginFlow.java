package User.Android;

import io.appium.java_client.AppiumBy;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import base.BaseClass;

public class UserLoginFlow extends BaseClass{
	String userUdid = System.getProperty("userUdid");
	
	public void successfulUserLogin() throws InterruptedException {
		
		//Thread.sleep(5000);
		//User
		
		driver1.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Get Started']")).click();   
		Thread.sleep(2000);
		decliningTheAutoSuggestions();
		System.out.println("None is tapped");
		driver1.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Enter Mobile number']")).sendKeys("8808908811");
		Thread.sleep(2000);
		driver1.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Continue']")).click();
		Thread.sleep(2000);
		driver1.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Enter 4 digit OTP']")).sendKeys("7891");
		Thread.sleep(3000);
//		if(driver1.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Full Name']"))!= null)
//		{
//		register();
//		}
		Thread.sleep(2000);
		System.out.println("Selecting the location");
		driver1.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Allow Location Access']")).click();
		Thread.sleep(6000);
	    selectingLocationPermission();
		
	}
		
	public void register() throws InterruptedException 
		
	  {
			driver1.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Enter Your Name']")).sendKeys("Automation Testing");
			Thread.sleep(2000);
			driver1.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Select Your Gender']")).click();
			Thread.sleep(2000);
			driver1.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Male']")).click();
			Thread.sleep(2000);
			driver1.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Let’s go!']")).click();
			Thread.sleep(3000);

		}
	
	public void decliningTheAutoSuggestions() throws InterruptedException{
		System.out.println("Coming to this block");
		if("1371785921000CT".equals(userUdid)) {
			System.out.println("Trying to tap none");
		driver1.findElement(AppiumBy.xpath("//android.widget.Button[@text='NONE OF THE ABOVE']")).click(); 
		}
		else if("1377682723004YR".equals(userUdid)) {
			System.out.println("Trying to tap none");
			driver1.findElement(AppiumBy.xpath("//android.widget.Button[@text='NONE OF THE ABOVE']")).click(); 
		}
		
		Thread.sleep(1000); 
	}
	 public void selectingLocationPermission() throws InterruptedException{
		 if("1371785921000CT".equals(userUdid)) {
			driver1.findElement(AppiumBy.xpath("//android.widget.Button[@text='WHILE USING THE APP']")).click();
			Thread.sleep(1000);
			driver1.findElement(AppiumBy.xpath("//android.widget.Button[@text='ALLOW']")).click();
			Thread.sleep(1000);
		 }
	 }

}

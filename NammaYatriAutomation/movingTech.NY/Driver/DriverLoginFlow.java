package Driver;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.testng.annotations.Test;

import base.BaseClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class DriverLoginFlow extends BaseClass{

	DevicePermissions devicePermissions = new DevicePermissions();
    @Test
	public void successfulDriverLogin() throws InterruptedException {
		String driverUdid = System.getProperty("driverUdid");
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Enable Location']")).click();

		switch(driverUdid) {
		case "RZ8N91FWYXT":
			driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='While using the app']")).click();
			break;
		case "1377682723004YR":
			driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='WHILE USING THE APP']")).click();
			break;
		case "1371785921000CT":
			driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='WHILE USING THE APP']")).click();
			break;
		case "R9ZTB0KD0FA":
			driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='While using the app']")).click();
		    break;
		default:
			throw new NoSuchElementException("Invalid Selectors");

		}

		Thread.sleep(9000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Confirm']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Get Started']")).click();
		Thread.sleep(2000);


		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='10-digit mobile number']")).sendKeys("9876544451"); 
		Thread.sleep(2000);

		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Continue']")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Auto Reading OTP...']")).sendKeys("7891");
		Thread.sleep(5000);
		devicePermissions.handlePermissions();

	}
}

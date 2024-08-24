package User.Android;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import base.BaseClass;
import io.appium.java_client.AppiumBy;

public class RentalUserCancellation extends BaseClass {
	@Test
	private void rentalUserCancellation() {
		scroll(); // scroll
		driver1.findElement(By.xpath("//android.widget.TextView[@text=\"Cancel Ride\"]")).click();
		driver1.findElement(By.xpath("(//android.widget.TextView[@text=\"Cancel Ride\"])[2]")).click(); //reappearing question of cancellation
		driver1.findElement(By.xpath("//android.widget.TextView[@text=\"Driver is not moving\"]")).click(); // reason of cancellation	
		driver1.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Cancel Ride : Button\"]")).click(); // final cancel button
	}
	
	private void scroll()
	{WebElement source = driver1.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Time\"]"));
	
	((JavascriptExecutor) driver1).executeScript("mobile: dragGesture", ImmutableMap.of(
		    "elementId", ((RemoteWebElement) source).getId(),
		    "endX", 178,
		    "endY", 1410
		));
	}
}

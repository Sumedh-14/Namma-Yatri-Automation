package Driver;

import org.testng.annotations.Test;

import base.BaseClass;
import io.appium.java_client.AppiumBy;

public class DriverRatingScreen extends BaseClass{
	@Test
	public void ratingScreen() throws InterruptedException {
		driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"5 Star : Un Selected\"]")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Submit Feedback\"]")).click();
		
	}

}

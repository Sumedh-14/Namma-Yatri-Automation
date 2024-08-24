package User.Android;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseClass;
import io.appium.java_client.AppiumBy;

public class QuotesScreen extends BaseClass {
	@Test
	private void selectingAutoQuote() throws InterruptedException {
		driver1.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Auto']")).click();
		Thread.sleep(2000);
		System.out.println("Coming to Tap Book auto ");
		driver1.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Confirm Button to Proceed With Auto\"]")).click(); //confirm estimates
		driver1.findElement(By.xpath("//android.widget.TextView[@text=\"Confirm Rental\"]")).click(); // confirm rental
	}
}

package Driver;

import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class AndroidBackButton extends BaseClass {

	@Test
	public void tapBack() throws InterruptedException {

		//        checkAndNavigateBack("//android.widget.RelativeLayout[@content-desc=\"Activate to open step list\"]"
		//                + "/android.widget.RelativeLayout/android.widget.RelativeLayout"
		//                + "/android.widget.LinearLayout/android.widget.LinearLayout", "Validating whether the route in map is displaying.");
		//
		//        checkAndNavigateBack("//android.view.View[@content-desc=\"Start driving navigation\"]", "Validating whether the start Navigation screen is displaying.");
		//
		//        checkAndNavigateBack("//android.widget.TextView[@text=\"Search here\"]", "Validating whether the Gmap HomeScreen is displaying.");
		
		for(int i =0;i<6;i++)
		{   
			Thread.sleep(3000);
			driver.navigate().back();
		}
		((AndroidDriver) driver).startActivity(new Activity("in.juspay.nammayatripartner.debug", "in.juspay.mobility.MainActivity"));

	}

	private void checkAndNavigateBack(String xpath, String validationMessage) {
		try {
			WebElement element = driver.findElement(By.xpath(xpath));
			Assert.assertTrue(element.isDisplayed(), validationMessage);
			System.out.println(validationMessage + " - PASSED");
			driver.navigate().back();
		} catch (NoSuchElementException e) {
			System.out.println(validationMessage + " - FAILED");
		}
	}
}

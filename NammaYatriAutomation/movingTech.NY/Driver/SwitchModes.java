package Driver;

import base.BaseClass;
import io.appium.java_client.AppiumBy;

public class SwitchModes extends BaseClass{
	
public void driverMode() throws InterruptedException
{
	Thread.sleep(9000);
	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Silent']")).click();
	Thread.sleep(2000);
	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Online']")).click();
	Thread.sleep(2000);
	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Offline']")).click();
	Thread.sleep(2000);
	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Go Silent : Button']")).click();
	Thread.sleep(1000);
	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Offline']")).click();
	Thread.sleep(2000);
	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Cancel']")).click();
	Thread.sleep(1000);
	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Offline']")).click();
	Thread.sleep(2000);
	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Go Offline']")).click();
	Thread.sleep(2000);
	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='GO!']")).click();
	Thread.sleep(2000);
	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Offline']")).click();
	Thread.sleep(2000);
	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Go Offline : Button']")).click();
	Thread.sleep(1000);
}
}

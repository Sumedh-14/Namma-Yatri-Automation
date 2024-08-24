package User.Android;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseClass;

public class RentalRideSearch extends BaseClass{
	
	@Test
	private void rideSearchWithoutAddingStop() {
		driver1.findElement(By.xpath("//android.widget.TextView[@text=\"Rentals\"]")).click(); //click on rentals
		driver1.findElement(By.xpath("(//android.widget.TextView[@text=\"+\"])[1]")).click();  //add time
		driver1.findElement(By.xpath("(//android.widget.TextView[@text=\"+\"])[1]")).click();
		driver1.findElement(By.xpath("(//android.widget.TextView[@text=\"+\"])[2]")).click(); //add km
		driver1.findElement(By.xpath("(//android.widget.TextView[@text=\"+\"])[2]")).click();
		driver1.findElement(By.xpath("//android.widget.TextView[@text=\"View Fares\"]")).click(); // View the fares
		
		//driver1.findElement(By.xpath("//android.widget.TextView[@text=\"Non-AC Mini\"]")).click(); // Select estimates
	}

}

package Driver;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;
import io.appium.java_client.AppiumBy;

public class PopUpScreen extends BaseClass {
    
    // Method to wait for the 'Accept Offer' button to be present
    public void waitForRideRequestPopup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement acceptOfferButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.xpath("//android.widget.Button[@text='Accept Offer']")));
        System.out.println("Waiting for 'Accept Offer' button to be present");
    }

    // Method to accept the ride request
    public void acceptOffer() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Waiting to accept the request");
        WebElement acceptButton = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Accept Offer']"));
        acceptButton.click();
        System.out.println("Driver accepted the ride request");
        Thread.sleep(7000);
    }

    // Method to decline the ride offer (placeholder, not implemented)
    public void declineOffer() {
        // To be implemented
    }

    // Method to add extra charges (example implementation)
    public void addExtraCharges() {
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='+ ']")).click();
    }

    // Method to remove added extra charges (example implementation)
    public void removeExtraAddedCharges() {
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='- ']")).click();
    }

    // Placeholder methods for swiping to second or third customer offer
    public void swipeToSecondCustomerOffer() {
        // To be implemented
    }

    public void swipeToThirdCustomerOffer() {
        // To be implemented
    }
}

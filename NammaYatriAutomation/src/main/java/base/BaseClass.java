package base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import TestSuite.Android;
import io.appium.java_client.AppiumDriver;

public class BaseClass {
    protected static AppiumDriver driver; 
    protected static AppiumDriver driver1;
    public static String rideOTP = null;

    @Test
    public void setUp() throws MalformedURLException {
        try {
            String driverDeviceName = System.getProperty("driverDeviceName");
            String driverUdid = System.getProperty("driverUdid");
            String userDeviceName = System.getProperty("userDeviceName");
            String userUdid = System.getProperty("userUdid");
            int flowOption = Integer.parseInt(System.getProperty("flowOption"));

            URL url = new URL("http://0.0.0.0:4723/wd/hub/");

            if (flowOption == 2 || flowOption == 3) {
                // Driver
                System.out.println("Setting the capabilities of the Driver Application and Driver app Installation is in Progress");
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setCapability("platformName", "Android");
                cap.setCapability("platformVersion", "13");
                cap.setCapability("deviceName", driverDeviceName);
                cap.setCapability("udid", driverUdid);
                cap.setCapability("automationName", "UiAutomator2");
                cap.setCapability("newCommandTimeout", 300);
                cap.setCapability("app", "/Users/sumedh.kp/eclipse-workspace/NammaYatriAutomation/movingTech.NY/Resources/app-nyDriver-prod-debug.apk");
                driver = new AppiumDriver(url, cap);
                driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                System.out.println("Launched the Driver Application");
            }

            if (flowOption == 1 || flowOption == 3) {
                // User
                System.out.println("Setting the capabilities of the User Application and User app Installation is in Progress");
                DesiredCapabilities cap1 = new DesiredCapabilities();
                cap1.setCapability("platformName", "Android");
                cap1.setCapability("platformVersion", "13");
                cap1.setCapability("deviceName", userDeviceName);
                cap1.setCapability("udid", userUdid);
                cap1.setCapability("automationName", "UiAutomator2");
                cap1.setCapability("newCommandTimeout", 300);
                cap1.setCapability("app", "/Users/sumedh.kp/eclipse-workspace/NammaYatriAutomation/movingTech.NY/Resources/app-nyUser-prod-debug.apk");
                driver1 = new AppiumDriver(url, cap1);
                driver1.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                System.out.println("Launched the User Application");
            }
        } catch (Exception exp) {
            System.out.println("Cause is: " + exp.getCause());
            System.out.println("Message is: " + exp.getMessage());
            exp.printStackTrace();
        }
    }

//    public void scrollToText(String text) {
//        driver.findElement(
//            new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
//                + ".scrollIntoView(new UiSelector()" + ".textMatches(\"" + text + "\").instance(0))"));
//    }

   // @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        if (driver1 != null) {
            driver1.quit();
        }
    }
}

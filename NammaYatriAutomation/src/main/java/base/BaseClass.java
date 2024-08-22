package base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class BaseClass {
    protected static AppiumDriver driver; 
    protected static AppiumDriver driver1;
    public static String rideOTP = null;
    public int flowOption;
   
    @BeforeSuite
    @Parameters("flowOption")
    public void setUp(int flowOption) throws MalformedURLException {
    	
        try {
        	this.flowOption = flowOption;
        	prerequisite();
            String driverDeviceName = System.getProperty("driverDeviceName");
            String driverUdid = System.getProperty("driverUdid");
            String userDeviceName = System.getProperty("userDeviceName");
            String userUdid = System.getProperty("userUdid");
           // int flowOption = Integer.parseInt(System.getProperty("flowOption"));

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
                driver = new AndroidDriver(url, cap);
                
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
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
                cap1.setCapability("app", "/Users/sumedh.kp/Downloads/app-nyUser-prod-debug (1).apk");
                driver1 = new AppiumDriver(url, cap1);
                driver1.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                System.out.println("Launched the User Application");
            }
        } catch (Exception exp) {
            System.out.println("Cause is: " + exp.getCause());
            System.out.println("Message is: " + exp.getMessage());
            exp.printStackTrace();
        }
    }
    
    public void prerequisite() {
		Scanner userInput = new Scanner(System.in);
		int userDevice = 0, driverDevice = 0;
//		System.out.println("Select the Flows that has to be executed.\n1.User Flow\n2.Driver Flow\n3.Both");
//		int flowOption = userInput.nextInt();
//		System.setProperty("flowOption", Integer.toString(flowOption));

		if (flowOption == 1) {
			System.out.println("Select the device from the below options for user Application");
			deviceNames();
			driverDevice = 0;
			userDevice = userInput.nextInt();
		} else if (flowOption == 2) {
			System.out.println("Select the device from the below options for driver Application");
			deviceNames();
			userDevice = 0;
			driverDevice = userInput.nextInt();
		} else if (flowOption == 3) {
			System.out.println("Select the device from the below options for user Application");
			deviceNames();
			userDevice = userInput.nextInt();
			System.out.println("Select the device from the below options for driver Application");
			deviceNames();
			driverDevice = userInput.nextInt();
		}

		// Validate and set device configurations
		setDeviceConfiguration(userDevice, driverDevice);

		// Run TestNG tests
		//           TestNG testng = new TestNG();
		//           testng.setTestClasses(new Class[]{TestSuite.Android.class});
		//           testng.run();
	}

	public static void deviceNames() {
		System.out.println("\n1.Samsung A51"
				+ "\n2.Iqoo Z5"
				+ "\n3.Realme RMX2117"
				+ "\n4.Vivo Y21"
				+ "\n5.Google Pixel 6a"
				+ "\n6.Redmi 10"
				+ "\n7.Samsung Galaxy A03 Core"
				+ "\n8.One Plus"
				+ "\n9.Samsung Galaxy A21s");

	}

	private static void setDeviceConfiguration(int userDevice, int driverDevice) {
		switch (userDevice) {
		case 0:break;
		case 1:
			System.setProperty("userDeviceName", "Samsung A51");
			System.setProperty("userUdid", "RZ8N91FWYXT");
			break;
		case 2:
			System.setProperty("userDeviceName", "Iqoo Z5");
			System.setProperty("userUdid", "1371785921000CT");
			break;
		case 3:
			System.setProperty("userDeviceName", "Realme RMX2117");
			System.setProperty("userUdid", "SONJFMDUKV65OJV4");
			break;
		case 4:
			System.setProperty("userDeviceName", "Vivo Y21");
			System.setProperty("userUdid", "1377682723004YR");
			break;
		case 5:
			System.setProperty("userDeviceName", "Google Pixel 6a");
			System.setProperty("userUdid", "28301JEGR03129");
			break;
		case 6:
			System.setProperty("userDeviceName", "Redmi 10");
			System.setProperty("userUdid", "eb23ba");
			break;
		case 7:
			System.setProperty("userDeviceName", "Samsung Galaxy A03 Core");
			System.setProperty("userUdid", "R9ZTB0KD0FA");
			break;
		case 8:
			System.setProperty("userDeviceName", "oneplus");
			System.setProperty("userUdid", "6b0d3c63");
			break;
		case 9:
			System.setProperty("userDeviceName", "Samsung Galaxy A21s");
			System.setProperty("userUdid", "RZ8R72RE6AB");
			break;
		default:
			throw new IllegalArgumentException("Invalid user device selection.");
		}

		switch (driverDevice) {
		case 0:break;
		case 1:
			System.setProperty("driverDeviceName", "Samsung A51");
			System.setProperty("driverUdid", "RZ8N91FWYXT");
			break;
		case 2:
			System.setProperty("driverDeviceName", "Iqoo Z5");
			System.setProperty("driverUdid", "1371785921000CT");
			break;
		case 3:
			System.setProperty("driverDeviceName", "Realme RMX2117");
			System.setProperty("driverUdid", "SONJFMDUKV65OJV4");
			break;
		case 4:
			System.setProperty("driverDeviceName", "Vivo Y21");
			System.setProperty("driverUdid", "1377682723004YR");
			break;
		case 5:
			System.setProperty("driverDeviceName", "Google Pixel 6a");
			System.setProperty("driverUdid", "28301JEGR03129");
			break;
		case 6:
			System.setProperty("driverDeviceName", "Redmi 10");
			System.setProperty("driverUdid", "eb23ba");
			break;
		case 7:
			System.setProperty("driverDeviceName", "Samsung Galaxy A03 Core");
			System.setProperty("driverUdid", "R9ZTB0KD0FA");
			break;
		case 8:
			System.setProperty("driverDeviceName", "oneplus");
			System.setProperty("driverUdid", "6b0d3c63");
			break;
		default:
			throw new IllegalArgumentException("Invalid driver device selection.");
		}
	}
    
    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        if (driver1 != null) {
            driver1.quit();
        }
    }
}

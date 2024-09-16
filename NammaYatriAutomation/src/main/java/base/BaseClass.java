package base;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
	public List<String> udids;

	@BeforeSuite
	@Parameters("flowOption")
	public void setUp(int flowOption) throws MalformedURLException {

		try {
			this.flowOption = flowOption;
			udids = getDeviceUDIDs();
			System.out.println(udids);
			System.out.println(udids.size());
			if(udids.size()==2 && flowOption ==1) {
				System.setProperty("userUdid", udids.get(1));
			}
			else if(udids.size()==2 && flowOption ==2) {
				System.setProperty("driverUdid", udids.get(1));
			}
			else if(udids.size()==3 && flowOption ==3) {
				System.setProperty("driverUdid", udids.get(1));
				System.setProperty("userUdid", udids.get(2));
			}
			else {
				System.out.println("NotEnoughInput - Either FlowInput in xml is wrong or adb devices are not connected");
			}
			String driverUdid = System.getProperty("driverUdid");
			String userUdid = System.getProperty("userUdid");

			URL url = new URL("http://0.0.0.0:4723/wd/hub/");

			if (flowOption == 2 || flowOption == 3) {
				// Driver
				System.out.println("Setting the capabilities of the Driver Application and Driver app Installation is in Progress");
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability("platformName", "Android");
				cap.setCapability("platformVersion", "13");
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


	public static List<String> getDeviceUDIDs() {
		List<String> udids = new ArrayList<>();
		try {

			ProcessBuilder processBuilder = new ProcessBuilder("/Users/sumedh.kp/Library/Android/sdk/platform-tools/adb", "devices", "-l");   
			//          System.out.println(System.getenv("PATH"));
			Process process = processBuilder.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.contains("device")) {
					String[] parts = line.split("\\s+");
					if (parts.length > 0) {
						udids.add(parts[0]);


					}
				} 
			}
			process.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return udids;
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

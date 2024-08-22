package Main;

import org.testng.TestNG;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Scanner;

public class TestingFlowInputOptions {


	//	public static void main(String[] args) {
	//    prerequisite();
	//    }
	//@Test
	public void prerequisite() {
		Scanner userInput = new Scanner(System.in);
		int userDevice = 0, driverDevice = 0;
		System.out.println("Select the Flows that has to be executed.\n1.User Flow\n2.Driver Flow\n3.Both");
		int flowOption = userInput.nextInt();
		System.setProperty("flowOption", Integer.toString(flowOption));

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
}

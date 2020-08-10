package framework;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import myreports.ExtentManager;
import screenshot.ScreenShot;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest extends TestListener implements ITestListener {

	protected static AppiumDriver<MobileElement> driver;

	static ExtentReports myExtent;
	static ExtentTest myTest;
	static AppiumDriverLocalService service;
	String serverIP = "127.0.0.1";
	int portNumber = 4723;
	ITestResult result;

//	@BeforeSuite
//	    public void startAppiumServer() {
//			
//		System.out.println("===============  Starting Appium Server     ================");
//		String NodePath = "C:/Program Files/nodejs/node.exe";
//		String AppiumMainJSPath = "C:/Program Files/Appium/resources/app/node_modules/appium/build/lib/main.js";
//
//		service = AppiumDriverLocalService
//				.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File(NodePath))
//						.withAppiumJS(new File(AppiumMainJSPath)).withIPAddress(serverIP).usingPort(portNumber));
//		service.start();
//		System.out.print("Server started at Host : " + serverIP + "and Port :" + portNumber);
//	}

	@Parameters({ "deviceName", "version", "deviceID" })
	@BeforeTest
	public void TestSetUp(String deviceName, String version , String deviceID) throws InterruptedException, IOException {
		System.out.println("===============  Execuiting Base Test Class ================");
		// startAppiumServer();
		System.out.println("===============  Parameters Set as below to run    ================");
		System.out.println("Device Name    " + deviceName);
		//String deviceID = getADBDeviceID();
		System.out.println("Device Id      " + deviceID);
		System.out.println("Device Android Version    " + version);
		try {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			caps.setCapability(MobileCapabilityType.UDID, deviceID);
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\akumsrivasta\\Desktop\\Roche\\FH-QA\\fh.apk");
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AppiumDriver<MobileElement>(url, caps);
			myExtent = ExtentManager.GetExtent();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	public void stopAppiumServer() {
//
//		service.stop();
//	}

//	private String getADBDeviceID() throws IOException {
//		Process pr = Runtime.getRuntime().exec("adb devices");
//		BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
//		String line = null;
//		while ((line = input.readLine()) != null) {
//			if (!line.contains(" ")) {
//				String[] dev = Arrays.toString(new String[] { line }).split("\\s+");
//				String selectedDevice = dev[0].replace("[", "").replace("]", "").trim();
//				System.out.println(selectedDevice);
//				return selectedDevice;
//			}
//		}
//		return null;
//
//	}

	public void TearDown() {
		System.out.println("After Test");
		ScreenShot.captureScreenShot();
//		if (ITestResult.FAILURE == result.getStatus()) {
//
//			System.out.println("Inside If");
//			ScreenShot.captureScreenShot();
//		}
		driver.quit();
		// myExtent.flush();
		// stopAppiumServer();

	}

}

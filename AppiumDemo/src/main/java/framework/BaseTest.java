package framework;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import myreports.ExtentManager;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest extends TestListener implements ITestListener {

	static AppiumDriver<MobileElement> driver;
	static ExtentReports myExtent;
	static ExtentTest myTest;
	static AppiumDriverLocalService service;
	String serverIP = "127.0.0.1";
	int portNumber = 4723;

	@Parameters({ "deviceId", "deviceName","version" })
	@BeforeTest
	public void TestSetUp(String deviceId, String deviceName, String version) throws InterruptedException {

		System.out.println("===============  Execuiting Base Test Class ================");
		System.out.println("===============  Starting Appium Server     ================");
		startAppiumServer();
		System.out.println("===============  Parameters Set as below to run    ================");
		System.out.println("Device Id      " + deviceId);
		System.out.println("Device Name    " + deviceName);
		System.out.println("Device Android Version    " + version);
		try {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			caps.setCapability(MobileCapabilityType.UDID, deviceId);
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

	private void startAppiumServer() {
		String NodePath = "C:/Program Files/nodejs/node.exe";
		String AppiumMainJSPath = "C:/Program Files/Appium/resources/app/node_modules/appium/build/lib/main.js";

		service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File(NodePath))
						.withAppiumJS(new File(AppiumMainJSPath)).withIPAddress(serverIP).usingPort(portNumber));
		service.start();
		System.out.print("Server started at Host : " + serverIP + "and Port :" + portNumber);
	}

	private void stopAppiumServer() {
		service.stop();
	}

	@AfterTest
	public void TearDown() {
		driver.quit();
		myExtent.flush();
		stopAppiumServer();

	}

}

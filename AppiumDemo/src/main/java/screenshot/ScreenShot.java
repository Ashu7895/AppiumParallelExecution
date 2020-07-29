package screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import framework.BaseTest;

public class ScreenShot extends BaseTest {

	public static void captureScreenShot() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File("./Screenshot/test.png"));
			System.out.println("Screenshot has taken");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to take sceenshot due to exception " + e);
		}

	}

}

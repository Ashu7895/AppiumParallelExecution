package framework;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import screenshot.ScreenShot;

public class SearchTest extends BaseTest implements SearchUserPageRepository , ITestListener {
	int i = 1;
	
	@Parameters({"deviceName"})
	@Test()
	public void samplePassTestCase(String deviceName) throws InterruptedException 
	{	
		myTest = myExtent.createTest("samplePassTestCase");
		myTest.assignCategory(deviceName);
		myTest.assignAuthor("QA Automation Team");
		myTest.log(Status.INFO, "Hi am Info of a Test Cases");
		myTest.log(Status.INFO, "Hi am Step 1 of a Test Case");
		myTest.log(Status.INFO, "Hi am Step 2 of a Test Case");
		myTest.log(Status.PASS, "Passing Test Case");
		System.out.println("Test Method 1 Executed");
		myExtent.flush();
		
		
	} 
	
	@Parameters({"deviceName"})
	@Test()
	public void sampleFailTestCase(String deviceName) throws InterruptedException, IOException 
	{	String name = "ashu";
		myTest = myExtent.createTest("sampleFailTestCase");
		myTest.assignCategory(deviceName);
		myTest.assignAuthor("QA Automation Team");
		myTest.log(Status.INFO, "Hi am Info of a Test Cases");
		myTest.log(Status.INFO, "Hi am Step 1 of a Test Case");
		myTest.log(Status.INFO, "Hi am Step 2 of a Test Case");
		myTest.log(Status.INFO, "This will get fail");
		myTest.log(Status.FAIL, "Test Case is Failing");
	//	myTest.fail("failed this",MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
		
	
	}

	
	
	
}	
	


//	//@Parameters({"deviceId","deviceName","portNumber"})
//	@Test()
//	public void searchUserByNameByJSON() throws InterruptedException 
//	{	
//		myTest = myExtent.createTest("Hi searchUserByNameByJSON");
//		myTest.log(Status.INFO , "Hi");
//		//myTest.assignCategory(deviceName);
//		myTest.assignAuthor("QA Automation Team");
//		System.out.println("Hi Chrome t " +i);
//		i++;
//		Thread.sleep(2000);
//		assertTrue(true);
//		myExtent.flush();
//	}
	
		//HashMap userDetails  = SearchUserDataModel.userListedData();
		
//		String userName = (String) userDetails.get("Username");
//		
//		ReusableFunctions.clickBy(VIEW_USER);
//		test.info("CLicked on View User Tab");
//		
//		ReusableFunctions.enterText(SEARCH_BAR, userName);
//		test.info("Searching for User : " + userDetails.get("Username"));
//		
//		ReusableFunctions.clickBy(USER_ICON_PHOTO);
//		test.info("CLicked on User");
//		
//		test.info("Below are the user details");
//		
//		String userid =  ReusableFunctions.getText(USER_ID);
//		test.info("User ID is : " + userid);
//		
//		String username =  ReusableFunctions.getText(USER_NAME);
//		test.info("User Name is : " + username);
//		
//		String email =  ReusableFunctions.getText(EMAIL_ID); 
//		test.info("User Email ID is : " + email);
//		
//		String dateofBirth = ReusableFunctions.getText(DATE_OF_BIRTH);
//		test.info("User Date of Birth is : " + dateofBirth);
//		
//		assertEquals(userDetails.get("Username"), userid);

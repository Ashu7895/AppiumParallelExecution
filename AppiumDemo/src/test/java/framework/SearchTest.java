package framework;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

public class SearchTest extends BaseTest implements SearchUserPageRepository {
	int i = 1;
	
	@Parameters({"deviceName"})
	@Test()
	public void searchUserByNameByExcel(String deviceName) throws InterruptedException 
	{	
		myTest = myExtent.createTest("Hi searchUserByNameByExcel");
		myTest.log(Status.INFO , "Hi");
		myTest.assignCategory(deviceName);
		myTest.assignAuthor("QA Automation Team");
		System.out.println("Hi Chrome t " +i);
		i++;
		System.out.println("Hi am in Test Method");
		Thread.sleep(2000);
		assertTrue(true);
		myExtent.flush();
		
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
	

}

//package framework;
//
//import java.io.IOException;
//
//import org.json.simple.JSONObject;
//import org.json.simple.parser.ParseException;
//import org.openqa.selenium.By;
//import org.testng.annotations.Test;
//
//import io.appium.java_client.TouchAction;
//import io.appium.java_client.touch.offset.PointOption;
//
//public class CreateUser extends BaseTest implements CreateUserRepository {
//	
//	
//	@Test
//	public void creaateUserFH() throws IOException, ParseException, InterruptedException 
//	{	
//		test = extent.createTest("Verify Create User");
//		JSONObject userDetails = ReusableFunctions.testDataProvider("TC001");
//		
//		ReusableFunctions.clickBy(ADD_USER);
//		test.info("Clicked on Add User");
//		ReusableFunctions.enterText(USER_ID, (String) userDetails.get("userid"));
//		test.info("Entering User id as "+ (String) userDetails.get("userid"));
//		ReusableFunctions.enterText(FIRST_NAME, (String) userDetails.get("firstname"));
//		test.info("Entering first name as "+ (String) userDetails.get("firstname"));
//		ReusableFunctions.enterText(LAST_NAME, (String) userDetails.get("lastname"));
//		test.info("Entering last name as "+ (String) userDetails.get("lastname"));
//		driver.navigate().back();
//		test.info("Clicked on Add User");
//		ReusableFunctions.clickBy(MALE_BUTTON);
//		test.info("Clicked on Male");
//		ReusableFunctions.clickBy(DOB_TEXT);
//		test.info("Clicked on Date of Birth");
//		ReusableFunctions.clickBy(DOB_OK);
//		test.info("Entered Date of Birth");
//		ReusableFunctions.enterText(EMAIL, (String) userDetails.get("email"));
//		test.info("Entering Email id as "+ (String) userDetails.get("email"));
//		driver.navigate().back();
//		ReusableFunctions.enterText(CELLNUMBER, (String) userDetails.get("cellmumber"));
//		test.info("Entering Cell No. as "+ (String) userDetails.get("cellmumber"));
//		driver.navigate().back();
//		ReusableFunctions.enterText(ADDRESS,(String) userDetails.get("address"));
//		test.info("Entering Address as "+ (String) userDetails.get("address"));
//		driver.navigate().back();
//	
//		Thread.sleep(5000);
//		
////		TouchAction actions = new TouchAction(driver);
////        actions.press(PointOption.point(0, 0)).waitAction().moveTo(PointOption.point(0, 50)).perform().release();
//        
//		ReusableFunctions.enterText(HOSPITAL_ID, (String) userDetails.get("hospitalid"));
//		test.info("Entering Hospital id as "+ (String) userDetails.get("hospitalid"));
//		driver.navigate().back();
//        
//		ReusableFunctions.enterText(DOCTOR_ID, (String) userDetails.get("doctorid"));
//		test.info("Entering Doctor id as "+ (String) userDetails.get("doctorid"));
//		
//		driver.navigate().back();
//                
//        ReusableFunctions.enterText(DEVICE_ID, (String) userDetails.get("deviceid"));
//        test.info("Entering Device id as "+ (String) userDetails.get("deviceid"));
//        driver.navigate().back();
//        
////        TouchAction actionss = new TouchAction(driver);
////        actionss.press(PointOption.point(0, 0)).waitAction().moveTo(PointOption.point(0, 50)).perform().release();
//        
//        ReusableFunctions.enterText(HEART_RATE, (String) userDetails.get("heartrate"));
//        test.info("Entering Hear Rate as "+ (String) userDetails.get("heartrate"));
//        driver.navigate().back();
//        
//        ReusableFunctions.clickBy(SUBMIT);
//        test.info("Clicked on Submit Button");
//        Thread.sleep(5000);
//	}
//		
//}

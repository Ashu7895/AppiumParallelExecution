package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReusableFunctions extends BaseTest{
	
	static WebDriverWait wait = new WebDriverWait(driver, 15);
	
	public static void enterText(String xpath_locator , String stringToBeEnter)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath_locator)));
		driver.findElement(By.xpath(xpath_locator)).sendKeys(stringToBeEnter);
		
	}	
	public static void clickBy(String xpath_locator)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath_locator)));
		driver.findElement(By.xpath(xpath_locator)).click();
	}

	public static String getText(String xpath_locator)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath_locator)));
		return driver.findElement(By.xpath(xpath_locator)).getText();
		 
	}
	
	public static void scrollDown()
	{
//		TouchAction actions = new TouchAction(driver);
//        actions.press(PointOption.point(0, 0)).waitAction().moveTo(PointOption.point(0, 50)).perform().release();
	}
	
	public static JSONObject testDataProvider(String testcaseNumber) throws IOException, ParseException
    {
    	JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("C:\\Users\\akumsrivasta\\Desktop\\Roche\\AppiumDemo\\src\\main\\resources\\testdata\\CreateUserTestData.JSON");
		Object obj =   jsonParser.parse(reader) ;
        JSONObject myobj = (JSONObject) obj;
        JSONArray jsonDataarrays = (JSONArray) myobj.get(testcaseNumber);
        JSONObject jsonData = null;
        for(int i = 0;i<jsonDataarrays.size();i++)
        {
        	jsonData = (JSONObject)jsonDataarrays.get(i);
        	
        }
        
        return jsonData;
    }
    
}

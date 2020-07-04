package myreports;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
 
public class ExtentManager {
 
 private static ExtentReports extent;
 private static ExtentTest test;
 private static ExtentHtmlReporter htmlReporter;
 private static String filePath = "./AutomationReport/timestampextentreport.html";
 
 
 public static ExtentReports GetExtent(){
  if (extent != null)
                    return extent; 
                extent = new ExtentReports();  
  extent.attachReporter(getHtmlReporter());
  return extent;
 }
 
 private static ExtentHtmlReporter getHtmlReporter() {
 
	    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        htmlReporter = new ExtentHtmlReporter(filePath.replace("timestamp", timeStamp));
        htmlReporter.config().setDocumentTitle("FH QA Automatoin Test Report");
        htmlReporter.config().setReportName("Sprint 1.0 Test Report");
        htmlReporter.config().setTheme(Theme.DARK);
        return htmlReporter;
 }
 
 public static ExtentTest createTest(String name, String description){
  test = extent.createTest(name, description);
  return test;
 }
}
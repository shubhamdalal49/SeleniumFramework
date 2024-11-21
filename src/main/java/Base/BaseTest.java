package Base;


import Utils.*;
import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import bsh.org.objectweb.asm.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest implements Constants {
	public static WebDriver driver;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	

@BeforeTest
public void beforeTestMethod() {
	sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reports" + File.separator + "ExtentReport.html");
	extent = new ExtentReports();
	extent.attachReporter(sparkReporter);
	sparkReporter.config().setTheme(Theme.DARK);
	extent.setSystemInfo("HostName", "Shubham");
	extent.setSystemInfo("UserName", "root");
	sparkReporter.config().setDocumentTitle("Automation Reports");
	sparkReporter.config().setReportName("Automation Test reports..... ");
}
@BeforeMethod

@Parameters("browser")
public void BeforeMethodMethod(String browser, Method testMethod) {
	logger = extent.createTest(testMethod.getName());
	setupDriver(browser);
	driver.manage().window().maximize();
	driver.get(Comman.urls);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}
@AfterMethod
public void afterMethod(ITestResult result) {
	if(result.getStatus() == ITestResult.FAILURE) {
		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "- testcase fail ", ExtentColor.RED));
		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + "- testcase fail ", ExtentColor.RED));}
	else if (result.getStatus() == ITestResult.SKIP) {
		logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "- testcase Skipped ", ExtentColor.ORANGE));
}
	else if (result.getStatus() == ITestResult.SUCCESS) {
		logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "- testcase Success ", ExtentColor.GREEN));
		}
	driver.quit();
}
	
@AfterTest
public void setupDriver(String browser) {
	if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();}
	else if (browser.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	else if (browser.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}
}
}

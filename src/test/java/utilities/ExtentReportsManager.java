package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;

import com.aventstack.extentreports.ExtentReports;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;// UI of report
	public ExtentReports extent;
	public ExtentTest test;
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Listenere has been started ");
		sparkReporter = new ExtentSparkReporter("reports/ExtentReport.html");
		sparkReporter.config().setDocumentTitle(" Automation Report ");
		sparkReporter.config().setReportName(" Functional testing ");
		sparkReporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();

		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("computer name", "Dell ");
		extent.setSystemInfo("Environment ", "staging");
		extent.setSystemInfo(" TEster name ", "Ajay ");
		extent.setSystemInfo("OS", " Window ");
		extent.setSystemInfo("Browser ", "Chrome  ");
	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test case is passed: " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, " Test case is  Failed : " + result.getName());
		test.log(Status.FAIL, " Test case failed case is : " + result.getThrowable());

	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, " Test case is Skiped  : " + result.getName());
	}

	public void onFinish(ITestContext context) {
		System.out.println(" Listeners has ended ");
		extent.flush();
	}
}

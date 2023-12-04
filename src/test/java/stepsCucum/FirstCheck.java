package stepsCucum;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstCheck  {
	WebDriver driver;
    ExtentReports extent;
	ExtentTest test;

	
	
	
	@Before(order=0)
	public void setUp() {
		
		ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+"\\src\\test\\resources\\Reports\\extentdemo.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Before(order=1)
	public void anotherHook() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
	    
	    
	}

	@Given("User should be on login page of orange hrm")
	public void userShouldBeOnLoginPageOfOrangeHrm() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@When("User give the username as {string} and password as {string}")
	public void userGiveTheUsernameAsAndPasswordAs(String user, String pass) {

		test = extent.createTest("User get username and password").assignAuthor("suresh").assignDevice("chrome").assignCategory("smoke");     // create the test name
		test.log(Status.INFO, "Enter username and password");      // create log,pass or fail 

		driver.findElement(By.name("username")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys(pass);

	}
	@When("User is clicking on the login button")
	public void userIsClickingOnTheLoginButton() {

		test = extent.createTest("User clicking login button").assignAuthor("suresh").assignDevice("chrome").assignCategory("smoke");     // create the test name
		test.log(Status.INFO, "Click login button");      // create log,pass or fail 

		driver.findElement(By.tagName("button")).click();

	}
	@Then("User must be on dashboard page")
	public void userMustBeOnDashboardPage() throws InterruptedException {

		test = extent.createTest("User get into homepage").assignAuthor("suresh").assignDevice("chrome").assignCategory("smoke");     // create the test name
		test.log(Status.INFO, "Checking Homepage");      // create log,pass or fail 

		Thread.sleep(5000);
		WebElement dashboard = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
		String text = dashboard.getText();

		if(text.equals("Dashboard"))
		{
			Assert.assertTrue(true);
			test.pass("Dashboard is present");		
		}
		else
		{
			Assert.assertTrue(false);
			test.fail("Dashboars is invisible");
		}
		
		//logger.info("Dashboard is present");

	}

	@After(order=1)
	public void afterHook() { 

		System.out.println("Hooks uhohaoudoohc");
	}


	@After(order=0)
	public void tearDown() {

		extent.flush(); 
		driver.quit();
	}




}

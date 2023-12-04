package dataTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BlagspotDatatable {
	WebDriver driver;
	
	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Given("User should be on Automation testing page")
	public void userShouldBeOnAutomationTestingPage() {
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS );
	    
	}
	@When("User click and enter the value in the firstname")
	public void userClickAndEnterTheValueInTheFirstname(DataTable data) {
//		List<String> l1 = data.asList();                                //aslist fun
		WebElement firstname = driver.findElement(By.id("name"));
//		firstname.sendKeys(l1.get(1));
//		for (int i = 0; i < l1.size(); i++)
//		{
//			firstname.sendKeys(l1.get(i));
//		}
		List<List<String>> list1 = data.asLists();                      //aslists fun
		firstname.sendKeys(list1.get(0).get(1));
	}
	@When("User click and enter the value in email")
	public void userClickAndEnterTheValueInEmail(DataTable data) {
		List<String> l2 = data.asList();
		driver.findElement(By.id("email")).sendKeys(l2.get(0));
		driver.findElement(By.id("phone")).sendKeys(l2.get(1));
		driver.findElement(By.id("textarea")).sendKeys(l2.get(2));
	   
	}
	
	@After
	public void tearDown() { 
		driver.quit();
	}


}

package dataTable2;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenMrs {
	WebDriver driver;

	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Given("Patient should be on the openMRS login page")
	public void patientShouldBeOnTheOpenMRSLoginPage() {
		driver.get("https://qa-refapp.openmrs.org/openmrs/login.htm\r\n");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS );

	}
	@When("User given the username and password")
	public void userGivenTheUsernameAndPassword(DataTable data) {
		List<Map<String, String>> asMaps = data.asMaps(String.class,String.class);

		WebElement user = driver.findElement(By.id("username"));
		user.sendKeys(asMaps.get(0).get("Username"));
		driver.findElement(By.id("password")).sendKeys(asMaps.get(0).get("Password"));

	}
	@When("Patient click location and login button")
	public void patientClickLocationAndLoginButton() {
		driver.findElement(By.id("Outpatient Clinic")).click();
		driver.findElement(By.id("loginButton")).click();

	}
	@When("Patient select Register a patient details button")
	public void patientSelectRegisterAPatientDetailsButton() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.linkText("Register a patient")).click();
    }
	@When("Patient enter the value in firstname and lastname")
	public void patientEnterTheValueInFirstnameAndLastname(DataTable data) {
		List<Map<String, String>> asMaps2 = data.asMaps(String.class,String.class);
		
		driver.findElement(By.name("givenName")).sendKeys(asMaps2.get(0).get("Firstname"));
		driver.findElement(By.name("familyName")).sendKeys(asMaps2.get(0).get("Familyname"));
		
		
	}

	@After
	public void tearDown() { 
		driver.quit();
	}




}

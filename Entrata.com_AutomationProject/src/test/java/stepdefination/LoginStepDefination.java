package stepdefination;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import PageObjectModel_Pages.HomePage;
import PageObjectModel_Pages.PersonalInformationPage;
import PageObjectModel_Pages.RegisterNowPage;
import PageObjectModel_Pages.WatchDemoPage;


public class LoginStepDefination {

	public WebDriver driver;
	
	HomePage homepage;
	WatchDemoPage watchdemopage;
	RegisterNowPage registernowpage;
	PersonalInformationPage personalinformationpage;
	
	@Before
	public void openBrowser() {
	   WebDriverManager.chromedriver().setup();
	   System.setProperty("webdriver.chrome.driver", "C:\\Users\\monal\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	   ChromeOptions option=new ChromeOptions();
	   option.setBinary("C:\\Users\\monal\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
	   option.addArguments("--remote-allow-origins=*");
	   driver=new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("https://www.entrata.com/");
	   driver.manage().deleteAllCookies();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@After
	public void closeBrowser() {
		if (driver != null) {
		driver.quit();
	}
	}
	
	
	@Given("user open the browser and navigate on home page")
	public void user_open_the_browser_and_navigate_on_home_page() {
		System.out.println("Browser Luanch Successfully");
	}

	@And("click on sign in button")
	public void click_on_sign_in_button() {
		homepage=new HomePage(driver);
	    homepage.clickOnSignInButton();
	}

	@When("resident login link display then click on link")
	public void resident_login_link_display_then_click_on_link() throws InterruptedException {
		homepage.resident_login_link_display_then_click_on_link();
	}

	@And("navigate on resident portal screen and click on website view")
	public void navigate_on_resident_portal_screen_and_click_on_website_view() {
		homepage.navigate_on_resident_portal_screen_and_click_on_website_view();
	}

	@Then("verify resident portal screen successfully displayed")
	public void verify_resident_portal_screen_successfully_displayed() {
		homepage.verify_resident_portal_screen_successfully_displayed();
	}
	
	//Watch Demo Form
	
	@When("click on watch demo button")
	public void click_on_watch_demo_button() {
		homepage=new HomePage(driver);
		homepage.click_on_watch_demo_button();
	}

	@When("enter details in text fileds")
	public void enter_details_in_text_fileds(DataTable dataTable) {
		watchdemopage=new WatchDemoPage(driver);
		
		//DataTable to fill Form Details
		
	    List<Map<String,String>> map=dataTable.asMaps(String.class,String.class);
	    for(Map<String,String> data:map) {
	    	watchdemopage.enterFirstName(data.get("firstName"));
	    	watchdemopage.enterLastName(data.get("lastName"));
	    	watchdemopage.enterEmail(data.get("email"));
	    	watchdemopage.enterCompanyName(data.get("companyName"));
	    	watchdemopage.enterPhoneNumber(data.get("phoneNumber"));
	    	watchdemopage.enterJobTitle(data.get("jobTitle"));
	    	
	    	watchdemopage.selectUnits();
	    }
	}

	@When("click on watch demp button")
	public void click_on_watch_demp_button() {
		watchdemopage.click_on_watch_demp_button();
	}
	
	@Then("verify all details fill successfully")
	public void verify_all_details_fill_successfully() {
		watchdemopage.verify_all_details_fill_successfully();
	}
	
	//Personal Information in Base Camp
	
	@When("click on base camp link")
	public void click_on_base_camp_link() {
		homepage=new HomePage(driver);
		homepage.click_on_base_camp_link();
	}

	@When("click on register Now button")
	public void click_on_register_now_button() {
		registernowpage=new RegisterNowPage(driver);
		registernowpage.switchToNewTab();
	}

	@When("enter personal details in register form")
	public void enter_personal_details_in_register_form(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		personalinformationpage=new PersonalInformationPage(driver);
		
		//DataTable to fill Form Details
		
		 List<Map<String,String>> map=dataTable.asMaps(String.class,String.class);
		    for(Map<String,String> data1:map) {
		personalinformationpage.enterFirstName(data1.get("firstName"));
		personalinformationpage.enterLastName(data1.get("LastName"));
		personalinformationpage.enterEmailAddress(data1.get("emailAddress"));
		personalinformationpage.enterTitle(data1.get("title"));
		personalinformationpage.enterCompanyName(data1.get("companyName"));
		personalinformationpage.enterMobileNumber(data1.get("mobileNumber"));
		    }
	}

	@When("click on next button")
	public void click_on_next_button() {
		personalinformationpage.clickOnNextButton();
	}

	@Then("verify registration successfully done")
	public void verify_registration_successfully_done() {
		registernowpage.switchToOriginalTab();
	}
	
	// Verify Broken links or Not Broken Linkes on WebPage
	
	@Then("access all the links present on webpage")
	public void access_all_the_links_present_on_webpage() {
		homepage=new HomePage(driver);
		homepage.accessAllLinksOnWebPage();
	}

}

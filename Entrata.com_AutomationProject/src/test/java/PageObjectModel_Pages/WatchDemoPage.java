package PageObjectModel_Pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class WatchDemoPage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//input[@id='FirstName' or @name='FirstName']")
	public WebElement firstNameTxt;
	
	@FindBy(xpath="//input[@id='LastName' or @name='LastName']")
	public WebElement lastNameTxt;
	
	@FindBy(xpath="//input[@id='Email' or @name='Email']")
	public WebElement emailTxt;
	
	@FindBy(xpath="//input[@id='Company' or @name='Company']")
	public WebElement companyNameTxt;
	
	@FindBy(xpath="//input[@id='Phone' or @name='Phone']")
	public WebElement phoneNumberTxt;
	
	@FindBy(xpath="//input[@id='Title' or @name='Title']")
	public WebElement jobTitleTxt;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement submitBtn;
	
	@FindBy(xpath="//select[@id='Unit_Count__c' or @name='Unit_Count__c']")
	public WebElement unitCountDropDown;
	
	@FindBy(xpath="//div[@class='mktoFormRow']//option[@value='11 - 100']")
	public WebElement selectUnit;
	
	public WatchDemoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	public void enterFirstName(String firstName) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='FirstName' or @name='FirstName']")));
			
		
		firstNameTxt.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		lastNameTxt.sendKeys(lastName);
	}
	
	public void enterEmail(String email) {
		emailTxt.sendKeys(email);
	}
	
	public void enterCompanyName(String companyName) {
		companyNameTxt.sendKeys(companyName);
	}
	
	public void enterPhoneNumber(String phoneNumber) {
		phoneNumberTxt.sendKeys(phoneNumber);
	}
	
	public void enterJobTitle(String jobTitle) {
		jobTitleTxt.sendKeys(jobTitle);
	}
	
	public void selectUnits() {
		unitCountDropDown.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='mktoFormRow']//option[@value='11 - 100']")));
		
		selectUnit.click();
		
		String actualUnit=selectUnit.getText();
		System.out.println(actualUnit);
		
		String expectedUnit="11 - 100";
		
		Assert.assertEquals(actualUnit, expectedUnit);
	}
	
	public void click_on_watch_demp_button() {
		submitBtn.click();
	}

	public void verify_all_details_fill_successfully() {
		driver.getTitle();
		
		Assert.assertTrue(true);
		
		System.out.println("Form information filled Successfully");
	}

}

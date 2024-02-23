package PageObjectModel_Pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalInformationPage {


	public WebDriver driver;

	@FindBy(xpath="//input[@id='56aeaca6-a0ad-4548-8afc-94d8d4361ba1']")
	public WebElement firstNameTxt;

	@FindBy(xpath="//input[@id='cfc98829-80b7-41b6-82b5-b968d43ef1c1']")
	public WebElement lastNameTxt;

	@FindBy(xpath="//input[@id='ff919d05-4281-4d9c-aa0d-82e3722d580d']")
	public WebElement emailAddressTxt;

	@FindBy(xpath="//input[@id='032e80c1-f29f-44e6-af13-a89e53906422']")
	public WebElement mobileTxt;

	@FindBy(xpath="//input[@id='227f50d0-f65b-4a72-9a4f-5060ea05f6ab']")
	public WebElement companyTxt;

	@FindBy(xpath="//input[@id='228cc308-a4d9-4212-8454-8407dd578c3d']")
	public WebElement titleTxt;

	@FindBy(xpath="//button[@id='forward']")
	public WebElement nextBtn;


	public PersonalInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void enterFirstName(String firstName) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='56aeaca6-a0ad-4548-8afc-94d8d4361ba1']")));
		
		String personalInformationPage=driver.getTitle();
		System.out.println(personalInformationPage);
		Assert.assertTrue(true);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)");
	
		Thread.sleep(3000);
	
		firstNameTxt.sendKeys(firstName);
	}

	public void enterLastName(String LastName) {
		lastNameTxt.sendKeys(LastName);
	}

	public void enterEmailAddress(String emailAddress) {
		emailAddressTxt.sendKeys(emailAddress);
	}

	public void enterTitle(String title) {
		titleTxt.sendKeys(title);
	}

	public void enterCompanyName(String companyName) {
		companyTxt.sendKeys(companyName);
	}

	public void enterMobileNumber(String mobileNumber) {
		mobileTxt.sendKeys(mobileNumber);
	}
	
	public void clickOnNextButton() {
		nextBtn.click();
		String pageTitle=driver.getTitle();
		System.out.println(pageTitle);
		
		Assert.assertTrue(true);
	}

}

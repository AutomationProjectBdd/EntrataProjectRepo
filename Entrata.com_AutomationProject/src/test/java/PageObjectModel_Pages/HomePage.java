package PageObjectModel_Pages;


import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class HomePage {

	public WebDriver driver;

	@FindBy(xpath="(//a[@href='/sign-in'])[1]")
	public WebElement signinBtn;

	@FindBy(xpath="//a[@href='https://www.residentportal.com']")
	public WebElement residentLoginLink;

	@FindBy(xpath="//div[@class='start-align']//div[text()='View the Website']")
	public WebElement viewWebsiteBtn;

	@FindBy(xpath="(//span[@class='small-font'][contains(text(),'Welcome to')])[2]")
	public WebElement residentPageTitle;

	@FindBy(xpath="(//a[@href='https://go.entrata.com/watchdemo'])[1]")
	public WebElement watchDemoBtn;
	
	@FindBy(xpath="(//a[@href='https://basecamp.entrata.com'])[1]")
	public WebElement baseCampBtn;
	
	@FindBy(tagName="a")
	public List<WebElement> links;
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnSignInButton(){
		signinBtn.click();
	}
	
	public void resident_login_link_display_then_click_on_link() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)");
	
		Thread.sleep(3000);
		
		residentLoginLink.click();
	}

	public void navigate_on_resident_portal_screen_and_click_on_website_view() {
		viewWebsiteBtn.click();
	}

	public void verify_resident_portal_screen_successfully_displayed() {
		
		driver.getTitle();	
		System.out.println(residentPageTitle.getText());	
	}
	
	public void click_on_watch_demo_button() {
		watchDemoBtn.click();
	}
	
	public void click_on_base_camp_link() {
		baseCampBtn.click();
	}
	
	public void accessAllLinksOnWebPage() {
		
		int actuallinksCount=links.size();
		System.out.println(actuallinksCount);
		int expectedlinkCount=186;
		
		Assert.assertEquals(expectedlinkCount, actuallinksCount);
		
		for(WebElement link:links) {
			String url=link.getAttribute("href");
		
	 try {
         URL linkurl = new URL(url);
         HttpURLConnection connection = (HttpURLConnection) linkurl.openConnection();
         connection.connect();
         int responseCode = connection.getResponseCode();
         connection.disconnect();

         if (responseCode != HttpURLConnection.HTTP_OK) {
             System.out.println("Broken link: " + url + " - Response code: " + responseCode);
         }
     } catch (Exception e) {
         System.out.println("Exception occurred while checking link: " + url);
         e.printStackTrace();
     }
		}
	}
		
}

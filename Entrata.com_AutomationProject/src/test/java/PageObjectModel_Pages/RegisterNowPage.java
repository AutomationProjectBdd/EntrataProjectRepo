package PageObjectModel_Pages;

import java.time.Duration;
import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterNowPage {
	
	public WebDriver driver;
	
	@FindBy(xpath="(//a[@href='https://cvent.me/waMMMZ'])[1]")
	public WebElement registerNowLink;
	
	
	public RegisterNowPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public void switchToNewTab() {
        // Get all window handles
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        
        // Switch to new tab
        driver.switchTo().window(tabs.get(1)); // Assuming the new tab is at index 1
        
        String childWindow=driver.getTitle();
        System.out.println(childWindow);
        Assert.assertTrue(true);
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='https://cvent.me/waMMMZ'])[1]")));
		
        registerNowLink.click();
        
        System.out.println("switch and click successfully");
    }

    // Method to switch back to the original tab
    public void switchToOriginalTab() {
        // Get all window handles
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        // Switch to original tab
        driver.switchTo().window(tabs.get(0));
        
        String parentWindoe=driver.getTitle();
        System.out.println(parentWindoe);
        Assert.assertTrue(true);
    }

}

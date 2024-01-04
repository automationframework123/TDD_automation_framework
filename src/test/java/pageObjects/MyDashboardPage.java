package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MyDashboardPage extends BasePage {

	public MyDashboardPage(WebDriver driver) 
	{
		super(driver);
	}
	
	// locator webelement for dashboard message header
	
	@FindBy(xpath="//h6[normalize-space()='Dashboard']") @CacheLookup  
	private WebElement msgDisplayedDashboardAccount;
	
	@FindBy(xpath="//p[@class='oxd-userdropdown-name']") @CacheLookup  
	private WebElement lnkDropdownMenu;
	
	@FindBy(xpath="//a[normalize-space()='Logout']") @CacheLookup  
	private WebElement lnkLogoutDropdownMenu;
		
	public boolean isDashboardAccountPageExists() 
	{
		try 
		{
			boolean msgDisplayconfirmation = msgDisplayedDashboardAccount.isDisplayed();
			return msgDisplayconfirmation;
		}
		catch(Exception e) 
		{
			return (false);
		}
	}
	
	
	public void clickOnDropdownPageLogin() 
	{
		lnkDropdownMenu.click();
	}
	
	public void clickOnDropdownPageLogoutLink() 
	{
		lnkLogoutDropdownMenu.click();
	}
	
}

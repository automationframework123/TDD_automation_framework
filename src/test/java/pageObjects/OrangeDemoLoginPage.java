package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class OrangeDemoLoginPage extends BasePage {

	public OrangeDemoLoginPage(WebDriver driver) 
	{
		super(driver);
	}
	
	// locator web elements on Login Page
		
	@FindBy(xpath="//input[@placeholder='Username']") @CacheLookup 
	private WebElement txtUsername;
	
	@FindBy(xpath="//input[@placeholder='Password']") @CacheLookup 
	private WebElement txtPassword;
	
	@FindBy(xpath="//button[normalize-space()='Login']") @CacheLookup 
	private WebElement btnLogin;

	
	// action performed for web elements
	
	public void setUserName(String uname) 
	{
		txtUsername.sendKeys(uname);
	}
	
	public void setPassword(String pwd) 
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLoginButton() 
	{
		btnLogin.click();
	}
	
	
}

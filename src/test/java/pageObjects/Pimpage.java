package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Pimpage extends BasePage
{
	public Pimpage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='PIM']")
	WebElement lblpim;
	
	@FindBy(xpath="//a[normalize-space()='Add Employee']")
	WebElement btnaddemployee;
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement txtfn;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement txtln;
;
	
	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement btnsave;
	
	@FindBy(xpath="//div[@class=\"orangehrm-edit-employee-name\"]//h6")
    WebElement lblname;
	
	public void clickpim()
	{
		lblpim.click();
	}
	public void click_addemployee()
	{
		btnaddemployee.click();
		
	}
	public void setname(String fname,String lname)
	{
		txtfn.sendKeys(fname);
		txtln.sendKeys(lname);
	}
	
	public void clicksave()
	{
		btnsave.click();
	}
	
	public boolean isnamedisplayed()
	{
		try
		{
			boolean bool=lblname.isDisplayed();
			return bool;
		}catch(Exception e)
		{
			return(false);
		}
	}
	
}

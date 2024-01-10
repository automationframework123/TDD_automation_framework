package pageObjects;

import java.util.List;

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

	
	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement btnsave;
	
	@FindBy(xpath="//div[@class=\"orangehrm-edit-employee-name\"]//h6")
    WebElement lblname;
	
	@FindBy(xpath="//a[normalize-space()='Employee List']")
	WebElement btnemployeelist;
	
	
	@FindBy(xpath="//div[@class='oxd-table-filter']//div[3]//div[1]//div[2]//div[1]//div[1]//div[2]")
	WebElement drpempstatus;
	
	@FindBy(xpath="//div[@role='option']//span")
	List<WebElement> option;
	
	@FindBy(xpath="//button[normalize-space()=\"Search\"]")
	WebElement btnsearch;
	
	@FindBy(xpath="//div[@aria-live='assertive']")
	WebElement lblsrchstatus;
	
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
	
	public void searchemployee() throws InterruptedException
	{
		Thread.sleep(2000);
		btnemployeelist.click();
		Thread.sleep(2000);
		drpempstatus.click();
		Thread.sleep(2000);
		for(WebElement opt:option)
		{
			if(opt.getText().equals("Freelance"))
			{
				opt.click();
				Thread.sleep(2000);
				break;
			}
		}
		btnsearch.click();
		Thread.sleep(2000);
	}
	
	public boolean  verifysearch()
	{
		String txt=lblsrchstatus.getText();
		System.out.println("Records");
		return(txt.contains("No Records Found"));
		
	}
	
}

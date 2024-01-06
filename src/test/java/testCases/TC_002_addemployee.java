package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.OrangeDemoLoginPage;
import pageObjects.Pimpage;
import testBase.BaseClass;

public class TC_002_addemployee extends BaseClass
{  
	@Test(groups= {"sanity"})
	public void verify_addemployee()
	{
		logger.info("*****Starting TC_002_addemployee*****");
		try
		{   OrangeDemoLoginPage odlp = new OrangeDemoLoginPage(driver);
			odlp.setUserName(properties.getProperty("username"));
			odlp.setPassword(properties.getProperty("password"));
			odlp.clickLoginButton();

			Pimpage pm=new Pimpage(driver);
			pm.clickpim();
			pm.click_addemployee();
			pm.setname("abc","xyz");
			pm.clicksave();
			boolean isdisplayed=pm.isnamedisplayed();
			System.out.println("confirmation message if name is added: "+isdisplayed);
			Assert.assertEquals(isdisplayed, true);
		}catch(Exception e)
		{
			logger.error("Test is failed");
			Assert.fail();
		}
		logger.info("****Finished TC_002 Add employee data");

}
}

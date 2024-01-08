package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.OrangeDemoLoginPage;
import pageObjects.Pimpage;
import testBase.BaseClass;

public class TC_003_searchemployee extends BaseClass 
{

	@Test(groups= {"regression"})
	public void verify_search_customer()
	{
		
		logger.info("*****Search Customer******");
		try
		{
			OrangeDemoLoginPage odlp = new OrangeDemoLoginPage(driver);
			odlp.setUserName(properties.getProperty("username"));
			odlp.setPassword(properties.getProperty("password"));
			odlp.clickLoginButton();

			Pimpage pm=new Pimpage(driver);
			pm.clickpim();
			logger.info("pim is clicked in dashboard");
			pm.searchemployee();
			logger.info("searchemp is clicked");
			boolean bool1=pm.verifysearch();
			Assert.assertEquals(bool1, false);
			
         }catch(Exception e)
		{
        	 e.printStackTrace();
			logger.error("Test case failed");
			Assert.fail();
		}
		logger.info("******Finished TC_003_search employee");
		
	}
	
}

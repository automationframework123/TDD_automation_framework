package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.MyDashboardPage;
import pageObjects.OrangeDemoLoginPage;
import testBase.BaseClass;

public class TC_001_OrangeDemoLoginPageTest extends BaseClass 
{
	
	@Test(groups= {"sanity"})
	public void verify_orangehrmaccount_login() 
	{
		
		logger.info("***** Starting TC_001_OrangeDemoLoginPageTest *****");
		logger.debug("***** Capturing application debug logs *****");
		
		try 
		{
			//OrangeHRMDemo Login Page
			OrangeDemoLoginPage odlp = new OrangeDemoLoginPage(driver);
			logger.info("***** Entering valid username and password from config file  *****");

			//getting username and password from config.properties file
			odlp.setUserName(properties.getProperty("username"));
			odlp.setPassword(properties.getProperty("password"));

			//click on login button link
			odlp.clickLoginButton();
			logger.info("***** Clicked on LoginButton link *****");

			//My Dashboard Account Page
			MyDashboardPage mdp = new MyDashboardPage(driver);
			boolean msgDisplayconfirmation = mdp.isDashboardAccountPageExists();

			System.out.println("confirmation dashboard message is displayed: " + msgDisplayconfirmation);
		
			if(msgDisplayconfirmation==true)
			{
				mdp.clickOnDropdownPageLogin();
				mdp.clickOnDropdownPageLogoutLink();
				logger.info("Login test passed");
				Assert.assertTrue(true);
			}
			else 
			{
				logger.error("Login test failed");
				Assert.fail();
			}
			
		}//end of try block
		catch(Exception e)
		{
			logger.error("test failed....");
			Assert.fail();
		}
		
		logger.info("***** Finished TC_001_OrangeDemoLoginPageTestTest *****");
	}
	
}

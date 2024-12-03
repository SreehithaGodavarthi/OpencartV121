package testCases;



import pageObjects.HomePage;
import testBase.BaseClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;

public class TC001_AccountRegistration extends BaseClass
{
	@Test(groups="Regression")
	public void verify_Account_reg() 
	
	{
		
		logger.info("****** Account Registration Starts...*******");
		logger.debug("This is a debug log msg...");
		
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickaccount();
		logger.info("My account link clicked....");
		
		hp.clickregister();
		logger.info("Account Registration Page opened...");
		
		AccountRegistrationPage reg=new AccountRegistrationPage(driver);
		
		logger.info("Providing customer info....");
		reg.setfirstname(randomeString().toUpperCase());
		reg.setlastname(randomeString().toUpperCase());
		reg.setemail(randomeString()+"@gmail.com");
		reg.settelephone(randomeNumber());
		
		String Password=randomalphnum();
		
		reg.setpwd(Password);
		reg.confrmpwd(Password);
		
		reg.setPrivacypolicy();
		reg.bttncontinue();

		
		logger.info("Validating confirmation msg...");
		String confmsg=reg.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
		logger.info("Test Passed...");
		}catch(Exception e)
		{
			logger.error("test failed" +e.getMessage());
			Assert.fail("Test failed" +e.getMessage());
		}
		
		finally {
			logger.info("*******Account Registration finished...******");
		}
		
	}
	
	

}

package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass
{

@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="Datadriven")
public void verify_login(String email, String pwd, String exp)
{
	logger.info("******* TC003_LoginDDT Test Starting from here *******");
	try
	{
	HomePage hp= new HomePage(driver);
	hp.clickaccount();
	hp.clickLogin();
	
	LoginPage lp =new LoginPage(driver);
	lp.setEmail(email);
	lp.setPassword(pwd);
	lp.loginbttn();
	
	MyAccount acc=new MyAccount(driver);
	boolean target_page=acc.ismyaccountexist();
	
	if(exp.equalsIgnoreCase("Valid"))
	{
		if(target_page==true)
		{
			acc.clickLogout();
			Assert.assertTrue(true);
			
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	
	if(exp.equalsIgnoreCase("Invalid"))
	{
		if(target_page==true)
		{
			acc.clickLogout();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
		}
	}
	}catch(Exception e)
	{
		Assert.fail();
	}

	logger.info("******* TC003_LoginDDT Test finished here *******");

}
}

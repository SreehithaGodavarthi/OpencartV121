package testCases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;


import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass
{
	@Test(groups={"Sanity","Master"})
 public void verify_login()
 {
	 logger.info("****** Starting TC002_LoginTest*******");
	 try {
		
	 HomePage hp=new HomePage(driver);
	 hp.clickaccount();
	 hp.clickLogin();
	 
	 LoginPage lp=new LoginPage(driver);
	 lp.setEmail(p.getProperty("email"));
	 lp.setPassword(p.getProperty("password"));
	 lp.loginbttn();
	 
	 MyAccount account=new MyAccount(driver);
	 boolean target_page=account.ismyaccountexist();
	 Assert.assertEquals(target_page, true,"LoginFailed");
	 //Assert.assertTrue(target_page);
	 }
	 catch(Exception e)
	 {
		 Assert.fail();
	 }
	 
	 logger.info("******Finished TC002_LoginTest*******");
 }
}

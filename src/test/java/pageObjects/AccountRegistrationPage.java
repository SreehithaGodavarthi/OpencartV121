package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage
{

	public AccountRegistrationPage(WebDriver driver) 
	{
		super(driver);
	}
	
@FindBy(xpath="//input[@id='input-firstname']")
WebElement txtusername;

@FindBy(xpath="//input[@id='input-lastname']")
WebElement txtlastname;

@FindBy(xpath="//input[@id='input-email']")
WebElement txtemail;

@FindBy(xpath="//input[@id='input-telephone']")
WebElement txttelephone;

@FindBy(xpath="//input[@id='input-password']")
WebElement txtpassword;

@FindBy(xpath="//input[@id='input-confirm']")
WebElement txtconfrmpassword;

@FindBy(xpath="//input[@name='agree']")
WebElement chckbox;

@FindBy(xpath="//input[@value='Continue']")
WebElement Bttncontinue;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement confirmmsg;

public void setfirstname(String fname)
{
	txtusername.sendKeys(fname);
}

public void setlastname(String lname)
{
	txtlastname.sendKeys(lname);
}

public void setemail(String email)
{
	txtemail.sendKeys(email);
}

public void settelephone(String phn)
{
	txttelephone.sendKeys(phn);
}

public void setpwd(String pwd)
{
	txtpassword.sendKeys(pwd);
}

public void confrmpwd(String pwd)
{
	txtconfrmpassword.sendKeys(pwd);
}

public void setPrivacypolicy() 
{
	chckbox.click();
}

public void bttncontinue()
{
	Bttncontinue.click();
}

public String getConfirmationMsg()
{
	try
	{
		
	return (confirmmsg.getText());
	}catch (Exception e) {
		return e.getMessage();
	}
	
}

}

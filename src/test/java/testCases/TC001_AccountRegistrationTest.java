package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	
	@Test(groups= {"Regression","Master"}) //Step8 groups added
	public void verify_account_registration() {
		
		logger.info("***TC001_AccountRegistrationTest Started***");
		try
		{
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		
		logger.info("Clicked on MyAccount Link");
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		logger.info("Costomer Information provided");
		regpage.setFirstname(randomString().toUpperCase());
		regpage.setLastname(randomString().toUpperCase());
		regpage.setemail(randomString()+"@gmail.com"); //randomly generated Email
		regpage.setTel(randomNumber()); // randomly generated number
		String password = randomPass();
		regpage.setPass(password);
		regpage.conPass(password);
		regpage.ChekAgree();
		regpage.btn_Click();
		logger.info("Click on Continue Botton");
		
		String confmsg = regpage.get_Confirmation();
		logger.info("Verify Verification");
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch (Exception e)
		{
			logger.error("Test Failed...");
			logger.debug("Debug logs");		
			Assert.fail();
			
		}
		
		logger.info("....Test Finished....");

	}
	
	

}

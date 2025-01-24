package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginClass;
import pageObject.MyAccount_Page;
import utilities.DataProviderUtil;

public class Login_DTT extends Base_Class {


	HomePage hp;
	LoginClass lp;
	MyAccount_Page myAcc;


	@Test(dataProvider = "LoginData", dataProviderClass = DataProviderUtil.class, groups = {"DataDrivenTest","Sanity"} )
	public void getLoginWithDataDriven(String name, String pwd, String res) throws InterruptedException
	{
		logger.info("<<< Test case started >>>");

		try
		{

			hp = new HomePage(driver);
			lp = new LoginClass(driver);
			myAcc = new MyAccount_Page(driver);

			// click on login button
			hp.clickOnMyAccount();
			hp.clickOnLogin();

			// login to application
			logger.info("<<< Enter Valid User Name>>>");
			lp.setValidUserName(name);

			logger.info("<<< Enter Valid User Password>>>");
			//lp.setValidUserPassword(pwd);
			lp.clickOnLoginBtn();

			// Verify login successfully
			myAcc = new MyAccount_Page(driver);
			boolean targetPage = myAcc.veriMyAccountTxt();

			if(res.equalsIgnoreCase("Valid"))
			{
				if(targetPage==true)
				{	
					hp.clickOnMyAccount();
					myAcc.getLogOut();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}

			if(res.equalsIgnoreCase("Invalid"))
			{
				if(targetPage==false)
				{
					hp.clickOnMyAccount();
					hp.getLogOut();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
		}
		catch(Exception e)
		{
			Assert.fail("An exception occurred: " + e.getMessage());
		}

		Thread.sleep(2000);
	}
}
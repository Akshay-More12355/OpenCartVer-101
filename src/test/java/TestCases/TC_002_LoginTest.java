package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginClass;
import pageObject.MyAccount_Page;
import utilities.DataProviderUtil;

public class TC_002_LoginTest extends Base_Class {

	HomePage hp;
	LoginClass lp;
	MyAccount_Page myAcc;

	@Test(groups = "Sanity")
	public void getLoginWithApplication() {
		logger.info("<<< Test case started >>>");

		hp = new HomePage(driver);
		hp.clickOnMyAccount();
		hp.clickOnLogin();

		// login with credentials
		lp = new LoginClass(driver);
		lp.setValidUserName(properties.getProperty("email"));
		lp.setValidUserPassword(properties.getProperty("password"));
		lp.clickOnLoginBtn();

		// validate login successfull or not
		myAcc = new MyAccount_Page(driver);

		boolean targetPage = myAcc.veriMyAccountTxt();
		Assert.assertEquals(targetPage, true);

	}
}
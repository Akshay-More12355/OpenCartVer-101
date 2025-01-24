package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginClass;
import pageObject.MyAccount_Page;
import pageObject.SearchFunctionalty;

public class TC_003_SearchFuctionality extends Base_Class {
	

	HomePage hp;
	LoginClass lp;
	MyAccount_Page myAcc;
	SearchFunctionalty search;
	
	@Test
	public void getProductSearch() throws InterruptedException
	{
		logger.info("<<< Test case started >>>");
		//create an object
		hp = new HomePage(driver);
		lp = new LoginClass(driver);
		search = new SearchFunctionalty(driver);
		
		//login and search
		logger.info("<<< click on my account and login>>>");
		hp.clickOnMyAccount();
		hp.clickOnLogin();
		
		//login
		logger.info("<<< login successfully with credentials >>>");
		lp.setValidUserName(properties.getProperty("email"));
		lp.setValidUserPassword(properties.getProperty("password"));
		lp.clickOnLoginBtn();
		
		//search product
		logger.info("<<< search product via search box >>>");
		search.searchProduct("samsung mobile");
		search.searchProductandClick();
		
		search.ClickonCheckBox();
		
		logger.info("<<< Test case finished >>>");
		
	}

}

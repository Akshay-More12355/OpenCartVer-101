package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount_Page extends baseClass{

	public MyAccount_Page(WebDriver driver) {

		super(driver);
	}

	@FindBy (xpath = "//h2[text()='My Account']")
	private WebElement myAcc_txt;
	
	@FindBy (xpath = "//ul[@class='dropdown-menu dropdown-menu-right']/descendant::a[text()='Logout']")
	private WebElement logout;


	public boolean veriMyAccountTxt()
	{
		try
		{
			return (myAcc_txt.isDisplayed());
		}

		catch (Exception e)
		{
			return false;
		}

	}
	
	public void getLogOut()
	{
		logout.click();
	}
}

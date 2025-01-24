package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends baseClass {

	

	public HomePage(WebDriver driver) {
		super(driver);

	}

	@FindBy (xpath = "//span[normalize-space()='My Account']")
	private WebElement linkMyAccount;

	@FindBy (xpath = "//a[normalize-space()='Register']")
	private WebElement linkRegistration;

	@FindBy (xpath = "//a[text()='Login']")
	private WebElement login;

	@FindBy (xpath = "//ul[@class='dropdown-menu dropdown-menu-right']/descendant::a[text()='Logout']")
	private WebElement logout;


	public void clickOnMyAccount()
	{
		linkMyAccount.click();
	}

	public void clickOnRegister()
	{
		linkRegistration.click();
	}

	public void clickOnLogin()
	{
		login.click();
	}

	public void getLogOut()
	{
		logout.click();
	}

}

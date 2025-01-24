package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginClass extends baseClass {

	public LoginClass(WebDriver driver) {
		
		super(driver);
		
	}

	@FindBy (xpath = "//input[@id='input-email']")
	private WebElement txt_email;
	
	@FindBy (xpath = "//input[@id='input-password']")
	private WebElement text_password;
	
	@FindBy (xpath = "//input[@value='Login']")
	private WebElement login_btn;
	
	
	public void setValidUserName(String username)
	{
		txt_email.sendKeys(username);
	}
	
	public void setValidUserPassword(String pwd)
	{
		text_password.sendKeys(pwd);
	}
	
	public void clickOnLoginBtn()
	{
		login_btn.click();
	}
}

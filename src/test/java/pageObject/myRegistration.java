package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myRegistration extends baseClass {

	public myRegistration(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (xpath = "//input[@id='input-firstname']")
	private WebElement txtFirst_name;
	
	@FindBy (xpath = "//input[@id='input-lastname']")
	private WebElement txtLast_name;
	
	@FindBy (xpath = "//input[@id='input-email']")
	private WebElement txtEmail;
	
	@FindBy (xpath = "//input[@id='input-telephone']")
	private WebElement txttelePhn;
	
	@FindBy (xpath = "//input[@id='input-password']")
	private WebElement txtpwd;
	
	@FindBy (xpath = "//input[@id='input-confirm']")
	private WebElement txtcnfpwd;
	
	@FindBy (xpath = "//label[normalize-space()='No']")
	private WebElement chkbtn;
	
	@FindBy (xpath = "//input[@value='Continue']")
	private WebElement sbtbtn;
	
	public void setFirstName(String firstname)
	{
		txtFirst_name.sendKeys(firstname);
	}
	
	public void setLattName(String laststname)
	{
		txtLast_name.sendKeys(laststname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setPhoneNum(String phone)
	{
		txttelePhn.sendKeys(phone);
	}
	
	public void setPassword(String pwd)
	{
		txtpwd.sendKeys(pwd);
	}
	
	public void setConfPassword(String cnf_pwd)
	{
		txtcnfpwd.sendKeys(cnf_pwd);
	}
	
	public void CheckOption()
	{
		chkbtn.click();
	}
	

	public void clickOnCOntinueBtn()
	{
		sbtbtn.click();
	}



}

package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchFunctionalty extends baseClass{

	public SearchFunctionalty(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy (xpath = "//input[@placeholder='Search']")
	private WebElement search_Box;
	
	@FindBy (xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement search_btn;
	
	@FindBy (xpath = "//input[@id='description']")
	private WebElement checkbox;
	
	
	
	public void searchProduct(String product)
	{
		search_Box.sendKeys(product);
	}
	
	public void searchProductandClick()
	{
		search_btn.click();
	}
	
	public boolean ClickonCheckBox()
	{
		checkbox.click();
		return true;
	}
}


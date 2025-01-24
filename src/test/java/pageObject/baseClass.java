package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class baseClass {

	public WebDriver driver;

	public baseClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
}

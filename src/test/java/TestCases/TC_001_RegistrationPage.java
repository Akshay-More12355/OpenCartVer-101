package TestCases;

import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.myRegistration;

public class TC_001_RegistrationPage extends Base_Class {

	HomePage hp;
	myRegistration reg;

	@Test(groups = {"Regression","Sanity"})
	public void getRegistered() {
		
		logger.info("<<< Test case started >>>");

        try {
            // Initialize the HomePage object
            hp = new HomePage(driver);
            hp.clickOnMyAccount();
            logger.info("Clicked on 'My Account' link.");

            hp.clickOnRegister();
            logger.info("Clicked on 'Register' link.");

            // Generate a random alphanumeric string for password
            String alphaNumeric = randomeAlphaNumeric();

            // Initialize the myRegistration object
            reg = new myRegistration(driver);
            logger.info("Sending details for registration.");

            // Fill in the registration details
            reg.setFirstName(randomeString());
            reg.setLattName(randomeString());
            reg.setEmail(randomeString() + "@gmail.com");
            reg.setPhoneNum(randomeNumber());
            reg.setPassword(alphaNumeric);
            reg.setConfPassword(alphaNumeric);
            reg.CheckOption();;
            reg.clickOnCOntinueBtn();;

            logger.info("Registration details submitted successfully.");
        } catch (Exception e) {
            logger.error("Test failed: " + e.getMessage(), e);
        } finally {
            logger.info("<<< Test case 'getRegistered()' finished >>>");
        }
		
	}
	
	

}

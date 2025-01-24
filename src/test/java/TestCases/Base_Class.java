package TestCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Base_Class {

	public static WebDriver driver;
	public Logger logger;
	Properties properties;

	@BeforeClass(groups = { "Sanity", "Regression", "DataDrivenTest" })
	@Parameters({ "browser" })
	void setUp(String browser) throws IOException {
		// Load the configuration properties
		FileReader fileReader = new FileReader("./src/test/resources/config.properties");
		properties = new Properties();
		properties.load(fileReader);

		// Initialize logger
		logger = LogManager.getLogger(this.getClass());

		// Setup the WebDriver based on the browser parameter
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			logger.error("Invalid browser specified: " + browser);
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}

		// Configure WebDriver
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Load the URL from the properties file
		String url = properties.getProperty("URL");

		if (url == null || url.isEmpty()) {
			logger.error("URL not specified in the config.properties file.");
			throw new IllegalStateException("URL is missing in the configuration.");
		}

		driver.get(url);
		driver.manage().window().maximize();
		logger.info("Browser setup completed. Navigated to URL: " + url);
	}

	@AfterClass(groups = { "Sanity", "Regression", "DataDrivenTest" })
	void tearDown() {
		driver.close();
	}

	@SuppressWarnings("deprecation")
	public String randomeString() {
		String random_String = RandomStringUtils.randomAlphabetic(6);
		return random_String;
	}

	@SuppressWarnings("deprecation")
	public String randomeNumber() {
		String random_Number = RandomStringUtils.randomNumeric(10);
		return random_Number;
	}

	@SuppressWarnings("deprecation")
	public String randomeAlphaNumeric() {
		String random_Number = RandomStringUtils.randomNumeric(10);
		String random_String = RandomStringUtils.randomAlphabetic(6);
		return (random_String + "@" + random_String);
	}

	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll down by a specific pixel value (e.g., 1000 pixels)
		js.executeScript("window.scrollBy(0,1000)");
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = FastDateFormat.getInstance("yyyyMMdd_HHmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);

		return targetFilePath;

	}
}

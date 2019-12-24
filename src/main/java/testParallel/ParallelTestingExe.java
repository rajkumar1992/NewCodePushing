package testParallel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTestingExe {

	public static WebDriver driver;

	@Parameters({ "Browser" })
	@BeforeMethod
	public static void openBrowser(String Browser) {
		if (Browser.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
	}

	@Test
	public static void openUrl() {
		driver.get("https://mvnrepository.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

}

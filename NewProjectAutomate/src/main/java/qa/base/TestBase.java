package qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		
		try {
	        prop= new Properties();
			FileInputStream fileInputStream= new FileInputStream("");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
		public static void initialization() {
			
		String	browsername=prop.getProperty("browser");
		
		if (browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();	
		}else if(browsername.equals("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver= new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		}
	}


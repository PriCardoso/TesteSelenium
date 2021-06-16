package helpers;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverNavegador {

	
	private static String pathDriver = System.getProperty("user.dir") + File.separator + "WebDriver" + File.separator + "chromedriver.exe";
	protected static WebDriver driver;
		
	public WebDriver setup(){
        System.setProperty("webdriver.chrome.driver", pathDriver);
        WebDriver driver = new ChromeDriver();

        return driver;
    }
	
	public static void finalizarDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}

}

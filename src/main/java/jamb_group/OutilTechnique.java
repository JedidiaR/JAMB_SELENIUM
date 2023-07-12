package jamb_group;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OutilTechnique {

	public static WebDriver driver;

	public enum ENavigateur {
		firefox, chrome,
	}

	public static WebDriver choisirNavigateur(ENavigateur nav) {
		switch (nav) {
		case firefox:
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
			driver = new FirefoxDriver();
			return driver;
		case chrome:
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			return driver;

		default:
			return null;

		}

	}
	
	public static void elementExist(WebElement e) {
		try {
			e.isDisplayed();
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

	public static void remplirChamp(WebElement e, String s) {
		e.clear();
		e.sendKeys(s);
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		OutilTechnique.driver = driver;
	}

	public static WebElement getCellule(int row, int col) {

		WebElement idcell = driver.findElement(By.xpath("//table/tbody/tr[" + row + "]/td[" + col + "]"));

		return idcell;

	}
}

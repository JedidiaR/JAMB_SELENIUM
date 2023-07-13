package tests;


import java.time.Duration;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utils.Utils;
import utils.Utils.ENavigateur;

public class RunTest {
	
	WebDriver driver;
	WebDriverWait wait;

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private String site = "http://localhost:8080/shopizer/shop?locale=fr";
	
	@Before
	public void init() {
		driver = Utils.choisirNavigateur(ENavigateur.chrome);
		driver.get(site);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

}
